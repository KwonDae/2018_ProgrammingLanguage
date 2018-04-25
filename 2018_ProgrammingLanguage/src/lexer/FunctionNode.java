package lexer;

import java.util.HashMap;
import java.util.Map;

public class FunctionNode extends Node{  
	//binaryOpNode클래스를 보고 참고해서 작성  
	enum FunctionType {
		DEFINE  { TokenType tokenType() { return TokenType.DEFINE;} },
		LAMBDA { TokenType tokenType() { return TokenType.LAMBDA;} },
		COND { TokenType tokenType() { return TokenType.COND;} },
		QUOTE { TokenType tokenType() { return TokenType.QUOTE;} },
		NOT { TokenType tokenType() { return TokenType.NOT;} },
		CDR { TokenType tokenType() { return TokenType.CDR;} },
		CAR { TokenType tokenType() { return TokenType.CAR;} },
		CONS { TokenType tokenType() { return TokenType.CONS;} },
		EQ_Q { TokenType tokenType() { return TokenType.EQ_Q;} },
		NULL_Q { TokenType tokenType() { return TokenType.NULL_Q;} },
		ATOM_Q { TokenType tokenType() { return TokenType.ATOM_Q;} };
		
		private static Map<TokenType, FunctionType> fromTokenType = new HashMap<TokenType, FunctionType>();
		static {
			for (FunctionType bType : FunctionType.values()) {
				fromTokenType.put(bType.tokenType(), bType);
			}
		}
		static FunctionType getFunctionType(TokenType tType) {
			return fromTokenType.get(tType);
		}
		abstract TokenType tokenType();
	}
	public FunctionType value;
	
	
	@Override  
	public String toString(){   //내용 채우기 
		return value.name();
	} 
 
	 public void setValue(TokenType tType) {  
		 FunctionType bType = FunctionType.getFunctionType(tType);
			value = bType;
		 }
	 } 
	 
