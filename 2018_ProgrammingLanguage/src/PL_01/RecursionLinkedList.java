package PL_01;

/* 201402317_±Ç´ë¿ø
 * 
 */

public class RecursionLinkedList {
	private Node head;
	private static char UNDEF = Character.MIN_VALUE;

	private void linkFirst(char element) {
		head = new Node(element, head);
	}

	private void linkLast(char element, Node x) {
		if(x.next == null) 
			x.next = new Node(element, null);
		else
			linkLast(element, x.next);
	}

	private void linkNext(char element, Node pred) {
		Node next = pred.next;
		pred.next = new Node(element, next);
	}

	private char unlinkFirst() {
		Node x = head;
		char element = x.item;
		head = head.next;
		x.item = UNDEF;
		x.next = null;
		return element;
	}

	private char unlinkNext(Node pred) {
		Node x = pred.next;
		Node next = x.next;
		char element = x.item;
		x.item = UNDEF;
		x.next = null;
		pred.next = next;
		return element;
	}

	private Node node(int index, Node x) {
		if( index == 0)
			return x;
		else {
			return node(--index, x.next);
		}
		
	}

	private int length(Node x) {
		if(x == null)
			return 0;
		else 
			return 1+length(x.next);
	}

	private String toString(Node x) {
		if(x == null)
			return "";
		else 
			return x.item+" "+toString(x.next); 		
	}

	public boolean add(char element) {
		if (head == null) {
			linkFirst(element);
		} else {
			linkLast(element, head);
		}

		return true;
	}

	public void add(int index, char element) {
		if (!(index >= 0 && index <= size()))
			throw new IndexOutOfBoundsException("" + index);

		if (index == 0)
			linkFirst(element);
		else
			linkNext(element, node(index - 1, head));
	}

	public char get(int index) {
		if (!(index >= 0 && index < size()))
			throw new IndexOutOfBoundsException("" + index);

		return node(index, head).item;
	}

	public char remove(int index) {
		if (!(index >= 0 && index < size()))
			throw new IndexOutOfBoundsException("" + index);

		if (index == 0) {
			return unlinkFirst();
		}
		return unlinkNext(node(index - 1, head));
	}

	public int size() {
		return length(head);
	}

	public String toString() {
		if (head == null)
			return "[]";

		return "[ " + toString(head) + "]";
	}

	private static class Node {
		char item;
		Node next;

		Node(char element, Node next) {
			this.item = element;
			this.next = next;
		}
	}
}
