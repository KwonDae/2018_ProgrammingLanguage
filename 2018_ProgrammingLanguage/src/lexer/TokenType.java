package lexer;

/*
 * 201402317 권대원
 */


public enum TokenType {
	INT, ID, QUESTION, TRUE, FALSE,
	NOT, PLUS, MINUS, TIMES, DIV, LT,
	GT, EQ, APOSTROPHE, L_PAREN, R_PAREN,
	DEFINE, LAMBDA, COND, QUOTE, CAR, CDR, 
	CONS, ATOM_Q, NULL_Q, EQ_Q, SHARP;
	static TokenType fromSpecialCharacter(char ch) {
		switch (ch) {
		// 정규 표현식을 참고하여 ch와 매칭되는 keyword를 반환하는 case문 작성
		case '(':
			return L_PAREN;
		case ')':
			return R_PAREN;
		case '+' :
			return PLUS;
		case '*':
			return TIMES;
		case '/':
			return DIV;
		case '<':
			return LT;
		case '=':
			return EQ;
		case '>':
			return GT;
		case '\'':
			return APOSTROPHE;
		case '#':
			return SHARP;
		case '-':
			return MINUS;
		default:
			throw new IllegalArgumentException("unregistered char: " + ch);
		}
	}
}