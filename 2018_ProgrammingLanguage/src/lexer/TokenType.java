package lexer;

/*
 * 201402317 �Ǵ��
 */


public enum TokenType {
	INT, ID, QUESTION, TRUE, FALSE,
	NOT, PLUS, MINUS, TIMES, DIV, LT,
	GT, EQ, APOSTROPHE, L_PAREN, R_PAREN,
	DEFINE, LAMBDA, COND, QUOTE, CAR, CDR, 
	CONS, ATOM_Q, NULL_Q, EQ_Q, SHARP;
	static TokenType fromSpecialCharacter(char ch) {
		switch (ch) {
		// ���� ǥ������ �����Ͽ� ch�� ��Ī�Ǵ� keyword�� ��ȯ�ϴ� case�� �ۼ�
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