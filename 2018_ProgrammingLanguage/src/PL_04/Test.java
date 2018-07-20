package PL_04;

/*
 * 201402317 권대원
 */

import ast.Node;
import ast.ListNode;
import ast.IntNode;
import compile.Printer;
import compile.CuteScanner;
import compile.TreeFactory;

public class Test {
	
	static int max=Integer.MIN_VALUE;
	static int result=0;
	
	public static int max(Node node) {  //최대값을 리턴하도록 작성  //value와 next 값 중 큰 값을 리턴
			
			if(node instanceof ListNode) {
				ListNode list = (ListNode) node; // 매개변수 노드를 ListNode로 캐스팅
				if(list.value != null)			// ListNode의 value가 null 이 아닐경우
					max(list.value);	
				if(node.getNext() != null)
					max(node.getNext());
			}
			else {  // node가 IntNode일 경우
				IntNode intnode = (IntNode) node; // 매개변수 노드를 IntNode로 캐스팅
				if( max < intnode.value) {
					max = intnode.value;
				}
				if(node.getNext() != null)
					max(node.getNext());
			}	
			return max;
		} 
		 
		public static int sum(Node node) {  //노드 value의 총합을 반환  //value와 next의 총 합을 리턴하면됨 
			if(node instanceof ListNode) {
				ListNode list = (ListNode) node;
				if(list.value != null)
					sum(list.value);
				
				if(node.getNext() != null)
					sum(node.getNext());
			} 
			else {
				IntNode intnode = (IntNode) node;
				result += intnode.value;
				if(node.getNext() != null)
					sum(node.getNext());
			}
			return result;
			} 
		
		public static void main(String... args) {  //이하 결과를 출력하도록 작성
			int maximum=0;
			int sum=0;
			Node node = TreeFactory.createtTree("( ( 3 ( ( 10 ) ) 6 ) 4 1 ( ) -2 ( ) )");  
			maximum = max(node);
			System.out.println("최댓값: " +maximum);
			sum = sum(node);
			System.out.println("총 합: "+sum);
			} 
		}


