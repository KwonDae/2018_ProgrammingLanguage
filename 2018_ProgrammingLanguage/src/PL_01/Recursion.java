package PL_01;

/* 201402317_권대원
 * 
 */
public class Recursion {

	public static int fibonacci(int n) {
		if (n == 0 || n == 1)
			return n;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	
	  public static String recursiveAnt(int n) { 
		  if(n==1) {
			  return "1";
		  }
		  else {
			  return makeResult(recursiveAnt(--n));
		  }
	  }
	 

	public static String makeResult(String previous) {
		int count = 1;
		String print = "";

		if (previous.length() == 1) {   // 매개변수길이가 1인경우
			print += previous.charAt(0);
			print += "1";
			return print;
		}
		for (int i = 1; i < previous.length(); i++) {

			if (i != previous.length() - 1 && previous.charAt(i - 1) == previous.charAt(i)) {
				count++;
			} else if (i == previous.length() - 1) {  // 마지막숫자 처리
				if (previous.charAt(i - 1) == previous.charAt(i)) {
					count++;
					print += previous.charAt(i);
					print += count;

				} else { // 앞의 숫자와 같지 않을경우
					print += previous.charAt(i - 1);
					print += count;
					print += previous.charAt(i);
					print += "1";

				}
			} else { // 앞의 숫자와 같지 않을경우
				print += previous.charAt(i - 1);
				print += count;
				count = 1;
			}
		}
		return print;
	}

	public static void main(String[] args) {
		System.out.println(fibonacci(10));
		System.out.println(recursiveAnt(10));

	}
}
