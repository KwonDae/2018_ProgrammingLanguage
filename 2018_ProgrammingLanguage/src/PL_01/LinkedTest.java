package PL_01;

/* 201402317_±Ç´ë¿ø
 * 
 */

public class LinkedTest {

	public static void main(String[] args) {
		RecursionLinkedList list = new RecursionLinkedList();
		list.add('a');
		list.add('b');
		list.add('c');
		list.add('d');
		list.add('e');
		System.out.println(list);
		list.add(0, 'z');
		System.out.println(list);
		System.out.println(list.get(4));
		System.out.println(list.remove(0));
		System.out.println(list);
		//list.reverse();
		//System.out.println(list);

	}

}
