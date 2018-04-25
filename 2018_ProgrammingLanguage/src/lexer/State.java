package lexer;

/*
 * 201402317 권대원
 */


import static lexer.TokenType.ID;
import static lexer.TokenType.INT;
import static lexer.TokenType.TRUE;
import static lexer.TokenType.FALSE;
import static lexer.TokenType.SHARP;
import static lexer.TokenType.MINUS;
import static lexer.TransitionOutput.GOTO_ACCEPT_ID;
import static lexer.TransitionOutput.GOTO_ACCEPT_INT;
import static lexer.TransitionOutput.GOTO_EOS;
import static lexer.TransitionOutput.GOTO_FAILED;
import static lexer.TransitionOutput.GOTO_MATCHED;
import static lexer.TransitionOutput.GOTO_SIGN;
import static lexer.TransitionOutput.GOTO_START;
import static lexer.TransitionOutput.GOTO_ACCEPT_MINUS;
import static lexer.TransitionOutput.GOTO_ACCEPT_TRUE;
import static lexer.TransitionOutput.GOTO_ACCEPT_FALSE;
import static lexer.TransitionOutput.GOTO_ACCEPT_SHARP;


enum State {
	START {
		@Override
		public TransitionOutput transit(ScanContext context) {
			Char ch = context.getCharStream().nextChar();
			char v = ch.value();
			switch ( ch.type() ) {
				case LETTER:
					context.append(v);
					return GOTO_ACCEPT_ID;
				case DIGIT:
					context.append(v);
					return GOTO_ACCEPT_INT;
				case SPECIAL_CHAR:
					context.append(v);
					return GOTO_SIGN;
				case WS:
					return GOTO_START;
				case END_OF_STREAM:
					return GOTO_EOS;
				case SHARP:
					context.append(v);
					return GOTO_ACCEPT_SHARP;  // char를 append 해주고 SHARP로 상태이동
				case MINUS:
					context.append(v);
					return GOTO_ACCEPT_MINUS;
				default:
					throw new AssertionError();
			}
		}
	},
	ACCEPT_ID {
		@Override
		public TransitionOutput transit(ScanContext context) {
			Char ch = context.getCharStream().nextChar();
			char v = ch.value();
			switch ( ch.type() ) {
				case LETTER:
				case DIGIT:
					context.append(v);
					return GOTO_ACCEPT_ID;
				case SPECIAL_CHAR:
					return GOTO_FAILED;
				case WS:
				case END_OF_STREAM:
					return GOTO_MATCHED(Token.ofName(context.getLexime()));
				default:
					throw new AssertionError();
			}
		}
	},
	ACCEPT_INT {
		@Override
		public TransitionOutput transit(ScanContext context) {
			Char ch = context.getCharStream().nextChar();
			switch ( ch.type() ) {
				case LETTER:
					return GOTO_FAILED;
				case DIGIT:
					context.append(ch.value());
					return GOTO_ACCEPT_INT;
				case SPECIAL_CHAR:
					return GOTO_FAILED;
				case WS:
				case END_OF_STREAM:
					return GOTO_MATCHED(INT, context.getLexime());
				default:
					throw new AssertionError();
			}
		}
	},
	SIGN {
		@Override
		public TransitionOutput transit(ScanContext context) {
			String str = context.getLexime();
			Char ch = context.getCharStream().nextChar();
			char v = ch.value();
			switch ( ch.type() ) {
				case LETTER:
					return GOTO_FAILED;
				case DIGIT:
					context.append(v);
					return GOTO_ACCEPT_INT;
				case WS: 
				case END_OF_STREAM:
					return GOTO_MATCHED(TokenType.fromSpecialCharacter(str.charAt(0)),str);
				default:
					throw new AssertionError();
			}
		}
	},
	MATCHED {
		@Override
		public TransitionOutput transit(ScanContext context) {
			throw new IllegalStateException("at final state");
		}
	},
	FAILED{
		@Override
		public TransitionOutput transit(ScanContext context) {
			throw new IllegalStateException("at final state");
		}
	},
	EOS {
		@Override
		public TransitionOutput transit(ScanContext context) {
			return GOTO_EOS;
		}
	},
	
	ACCEPT_TRUE { // TRUE 를 받았을때 상태처리
		@Override
		public TransitionOutput transit(ScanContext context) {
			Char ch = context.getCharStream().nextChar();
			char v = ch.value();
			switch(ch.type()) {
			case LETTER:
				if( v=='T') {
					context.append(v);
					return GOTO_MATCHED(TRUE, context.getLexime());
				} else
					return GOTO_FAILED;
			case DIGIT:
				return GOTO_FAILED;
			case WS:
				return GOTO_FAILED;
			case END_OF_STREAM:
				return GOTO_FAILED;
				default:
					throw new AssertionError();
			}
		}
	},
	ACCEPT_FALSE { // FALSE를 받았을때 상태처리
		@Override
		public TransitionOutput transit(ScanContext context) {
			Char ch = context.getCharStream().nextChar();
			char v = ch.value();
			switch(ch.type()) {
			case LETTER:
				if( v=='F') {
					context.append(v);
					return GOTO_MATCHED(FALSE, context.getLexime());
				} else
					return GOTO_FAILED;
			case DIGIT:
				return GOTO_FAILED;
			case WS:
				return GOTO_FAILED;
			case END_OF_STREAM:
				return GOTO_FAILED;
				default:
					throw new AssertionError();
			}
		}
	},
	
	ACCEPT_MINUS { // FALSE를 받았을때 상태처리
		@Override
		public TransitionOutput transit(ScanContext context) {
			Char ch = context.getCharStream().nextChar();
			char v = ch.value();
			switch(ch.type()) {
			case LETTER:
				return GOTO_FAILED;
			case DIGIT:
				context.append(v);
				return GOTO_ACCEPT_INT;
			case WS:
			case END_OF_STREAM:
				return GOTO_MATCHED(MINUS, context.getLexime());
				default:
					throw new AssertionError();
			}
		}
	},
	
	ACCEPT_SHARP {  // SHARP가 들어왔을때 상태처리
		@Override
		public TransitionOutput transit(ScanContext context) {
			Char ch = context.getCharStream().nextChar();
			char v = ch.value();
			switch(ch.type()) {
			case LETTER:
				if( v=='T') {
					context.append(v);
					return GOTO_MATCHED(TRUE, context.getLexime());
				} else if( v=='F') {
					context.append(v);
					return GOTO_FAILED;
				}
			case DIGIT:
				return GOTO_FAILED;
			case WS:
				return GOTO_FAILED;
			case END_OF_STREAM:
				return GOTO_FAILED;
				default:
					throw new AssertionError();
			}
		}
	};
	abstract TransitionOutput transit(ScanContext context);
}