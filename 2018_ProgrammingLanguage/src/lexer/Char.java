package lexer;

/*
 * 201402317 권대원
 */

class Char {
	private final char value;
	private final CharacterType type;

	enum CharacterType {
		LETTER, DIGIT, SPECIAL_CHAR, WS, END_OF_STREAM, SHARP, MINUS
	}

	static Char of(char ch) {
		return new Char(ch, getType(ch));
	}

	static Char end() {
		return new Char(Character.MIN_VALUE, CharacterType.END_OF_STREAM);
	}

	private Char(char ch, CharacterType type) {
		this.value = ch;
		this.type = type;
	}

	char value() {
		return this.value;
	}

	CharacterType type() {
		return this.type;
	}

	private static CharacterType getType(char ch) {
		int code = (int) ch;
		if ((code >= (int) 'A' && code <= (int) 'Z') || (code >= (int) 'a' && code <= (int) 'z')) {
			return CharacterType.LETTER;
		}

		if (Character.isDigit(ch)) {
			return CharacterType.DIGIT;
		}

		switch (ch) {
		case '(':
			return CharacterType.SPECIAL_CHAR;
		case ')':
			return CharacterType.SPECIAL_CHAR;
		case '+' :
			return CharacterType.SPECIAL_CHAR;
		case '*' :
			return CharacterType.SPECIAL_CHAR;
		case '/' :
			return CharacterType.SPECIAL_CHAR;
		case '<' :
			return CharacterType.SPECIAL_CHAR;
		case '=' :
			return CharacterType.SPECIAL_CHAR;
		case '>' :
			return CharacterType.SPECIAL_CHAR;
		case '\'' :
			return CharacterType.SPECIAL_CHAR;
		case '#' :
			return CharacterType.SHARP;  // SHARP는 예외처리
		case '-':
			return CharacterType.MINUS;
		case '?':
			return CharacterType.LETTER;  // ? 를 LETTER로 처리해줘 토큰과 함께 출력
		
		}

		if (Character.isWhitespace(ch)) {
			return CharacterType.WS;
		}
		if(ch=='\'' ) {
			return CharacterType.END_OF_STREAM;
		}

		throw new IllegalArgumentException("input=" + ch);
	}
}