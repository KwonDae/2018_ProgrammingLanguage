package lexer;

/*
 * 201402317 권대원
 */


import java.util.Optional;

class TransitionOutput {
	private final State nextState;
	private final Optional<Token> token;

	static TransitionOutput GOTO_START = new TransitionOutput(State.START);
	static TransitionOutput GOTO_ACCEPT_ID = new TransitionOutput(State.ACCEPT_ID);
	static TransitionOutput GOTO_ACCEPT_INT = new TransitionOutput(State.ACCEPT_INT);
	static TransitionOutput GOTO_SIGN = new TransitionOutput(State.SIGN);
	static TransitionOutput GOTO_FAILED = new TransitionOutput(State.FAILED);
	static TransitionOutput GOTO_EOS = new TransitionOutput(State.EOS);
	static TransitionOutput GOTO_ACCEPT_TRUE = new TransitionOutput(State.ACCEPT_TRUE);
	static TransitionOutput GOTO_ACCEPT_MINUS = new TransitionOutput(State.ACCEPT_MINUS);
	static TransitionOutput GOTO_ACCEPT_FALSE = new TransitionOutput(State.ACCEPT_FALSE);
	static TransitionOutput GOTO_ACCEPT_SHARP = new TransitionOutput(State.ACCEPT_SHARP); //SHARP가 들어왔을때 SHARP 상태로 가게해줌
	
	static TransitionOutput GOTO_MATCHED(TokenType type, String lexime) {
		return new TransitionOutput(State.MATCHED, new Token(type, lexime));
	}
	static TransitionOutput GOTO_MATCHED(Token token) {
		return new TransitionOutput(State.MATCHED, token);
	}
	
	TransitionOutput(State nextState, Token token) {
		this.nextState = nextState;
		this.token = Optional.of(token);
	}
	
	TransitionOutput(State nextState) {
		this.nextState = nextState;
		this.token = Optional.empty();
	}
	
	State nextState() {
		return this.nextState;
	}
	
	Optional<Token> token() {
		return this.token;
	}
}