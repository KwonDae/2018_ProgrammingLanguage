package PL_01;

/* 201402317_±Ç´ë¿ø
 * 
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderLinkedTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecursionLinkedList list = new RecursionLinkedList();
		FileReader fr;
		try {
		fr = new FileReader("C:\\Users\\goodd\\Desktop\\hw01.txt");
		BufferedReader br = new BufferedReader(fr);
		String inputString = br.readLine();
		for(int i = 0; i < inputString.length(); i++)
		list.add(inputString.charAt(i));
		} catch (IOException e) {
		e.printStackTrace();
		}
		System.out.println(list.toString());
		list.add(3, 'b'); System.out.println(list.toString());

	}
}
