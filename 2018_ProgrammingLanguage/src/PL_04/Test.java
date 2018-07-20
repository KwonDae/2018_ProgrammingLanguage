package PL_04;

/*
 * 201402317 �Ǵ��
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
	
	public static int max(Node node) {  //�ִ밪�� �����ϵ��� �ۼ�  //value�� next �� �� ū ���� ����
			
			if(node instanceof ListNode) {
				ListNode list = (ListNode) node; // �Ű����� ��带 ListNode�� ĳ����
				if(list.value != null)			// ListNode�� value�� null �� �ƴҰ��
					max(list.value);	
				if(node.getNext() != null)
					max(node.getNext());
			}
			else {  // node�� IntNode�� ���
				IntNode intnode = (IntNode) node; // �Ű����� ��带 IntNode�� ĳ����
				if( max < intnode.value) {
					max = intnode.value;
				}
				if(node.getNext() != null)
					max(node.getNext());
			}	
			return max;
		} 
		 
		public static int sum(Node node) {  //��� value�� ������ ��ȯ  //value�� next�� �� ���� �����ϸ�� 
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
		
		public static void main(String... args) {  //���� ����� ����ϵ��� �ۼ�
			int maximum=0;
			int sum=0;
			Node node = TreeFactory.createtTree("( ( 3 ( ( 10 ) ) 6 ) 4 1 ( ) -2 ( ) )");  
			maximum = max(node);
			System.out.println("�ִ�: " +maximum);
			sum = sum(node);
			System.out.println("�� ��: "+sum);
			} 
		}


