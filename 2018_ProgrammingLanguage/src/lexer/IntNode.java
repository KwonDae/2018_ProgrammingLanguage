package lexer;


/*
 * 201402317 �Ǵ��
 */

public class IntNode extends Node {
		public int value;   
		@Override  
		public String toString(){ 
			return "INT: " + Integer.toString(value);  
				}
} 