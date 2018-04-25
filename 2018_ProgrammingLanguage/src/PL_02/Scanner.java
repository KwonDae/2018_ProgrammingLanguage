package PL_02;

/*
 * 201402317
 * 권대원
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Scanner {

	private int transM[][];
	private String source;
	private StringTokenizer st;

	public Scanner(String source) {
		this.transM = new int[4][128];
		this.source = source == null ? "" : source;
		this.st = new StringTokenizer(source);  // st 객체 정의
		initTM();
	}

	public enum TokenType {
		ID(3), INT(2);
		private final int finalState;

		TokenType(int finalState) {
			this.finalState = finalState;
		}
	}

	public static class Token {
		public final TokenType type;
		public final String lexme;

		Token(TokenType type, String lexme) {
			this.type = type;
			this.lexme = lexme;
		}

		@Override
		public String toString() {
			return String.format("[%s: %s]", type.toString(), lexme);
		}
	}

	private void initTM() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 128; j++) {
				transM[i][j] = -1;
			}
		}
		transM[0]['0'] = 2;
		transM[0]['1'] = 2;
		transM[0]['2'] = 2;
		transM[0]['3'] = 2;
		transM[0]['4'] = 2;
		transM[0]['5'] = 2;
		transM[0]['6'] = 2;
		transM[0]['7'] = 2;
		transM[0]['8'] = 2;
		transM[0]['9'] = 2;
		transM[0]['-'] = 1;
		transM[0]['a'] = 3;
		transM[0]['b'] = 3;
		transM[0]['c'] = 3;
		transM[0]['d'] = 3;
		transM[0]['e'] = 3;
		transM[0]['f'] = 3;
		transM[0]['g'] = 3;
		transM[0]['h'] = 3;
		transM[0]['i'] = 3;
		transM[0]['j'] = 3;
		transM[0]['k'] = 3;
		transM[0]['l'] = 3;
		transM[0]['m'] = 3;
		transM[0]['n'] = 3;
		transM[0]['o'] = 3;
		transM[0]['p'] = 3;
		transM[0]['q'] = 3;
		transM[0]['r'] = 3;
		transM[0]['s'] = 3;
		transM[0]['t'] = 3;
		transM[0]['u'] = 3;
		transM[0]['v'] = 3;
		transM[0]['w'] = 3;
		transM[0]['x'] = 3;
		transM[0]['y'] = 3;
		transM[0]['z'] = 3;
		transM[0]['A'] = 3;
		transM[0]['B'] = 3;
		transM[0]['C'] = 3;
		transM[0]['D'] = 3;
		transM[0]['E'] = 3;
		transM[0]['F'] = 3;
		transM[0]['G'] = 3;
		transM[0]['H'] = 3;
		transM[0]['I'] = 3;
		transM[0]['J'] = 3;
		transM[0]['K'] = 3;
		transM[0]['L'] = 3;
		transM[0]['M'] = 3;
		transM[0]['N'] = 3;
		transM[0]['O'] = 3;
		transM[0]['P'] = 3;
		transM[0]['Q'] = 3;
		transM[0]['R'] = 3;
		transM[0]['S'] = 3;
		transM[0]['T'] = 3;
		transM[0]['U'] = 3;
		transM[0]['V'] = 3;
		transM[0]['W'] = 3;
		transM[0]['X'] = 3;
		transM[0]['Y'] = 3;
		transM[0]['Z'] = 3;

		transM[1]['0'] = 2;
		transM[1]['1'] = 2;
		transM[1]['2'] = 2;
		transM[1]['3'] = 2;
		transM[1]['4'] = 2;
		transM[1]['5'] = 2;
		transM[1]['6'] = 2;
		transM[1]['7'] = 2;
		transM[1]['8'] = 2;
		transM[1]['9'] = 2;

		transM[2]['0'] = 2;
		transM[2]['1'] = 2;
		transM[2]['2'] = 2;
		transM[2]['3'] = 2;
		transM[2]['4'] = 2;
		transM[2]['5'] = 2;
		transM[2]['6'] = 2;
		transM[2]['7'] = 2;
		transM[2]['8'] = 2;
		transM[2]['9'] = 2;

		transM[3]['A'] = 3;
		transM[3]['B'] = 3;
		transM[3]['C'] = 3;
		transM[3]['D'] = 3;
		transM[3]['E'] = 3;
		transM[3]['F'] = 3;
		transM[3]['G'] = 3;
		transM[3]['H'] = 3;
		transM[3]['I'] = 3;
		transM[3]['J'] = 3;
		transM[3]['K'] = 3;
		transM[3]['L'] = 3;
		transM[3]['M'] = 3;
		transM[3]['N'] = 3;
		transM[3]['O'] = 3;
		transM[3]['P'] = 3;
		transM[3]['Q'] = 3;
		transM[3]['R'] = 3;
		transM[3]['S'] = 3;
		transM[3]['T'] = 3;
		transM[3]['U'] = 3;
		transM[3]['V'] = 3;
		transM[3]['W'] = 3;
		transM[3]['X'] = 3;
		transM[3]['Y'] = 3;
		transM[3]['Z'] = 3;
		transM[3]['a'] = 3;
		transM[3]['b'] = 3;
		transM[3]['c'] = 3;
		transM[3]['d'] = 3;
		transM[3]['e'] = 3;
		transM[3]['f'] = 3;
		transM[3]['g'] = 3;
		transM[3]['h'] = 3;
		transM[3]['i'] = 3;
		transM[3]['j'] = 3;
		transM[3]['k'] = 3;
		transM[3]['l'] = 3;
		transM[3]['m'] = 3;
		transM[3]['n'] = 3;
		transM[3]['o'] = 3;
		transM[3]['p'] = 3;
		transM[3]['q'] = 3;
		transM[3]['r'] = 3;
		transM[3]['s'] = 3;
		transM[3]['t'] = 3;
		transM[3]['u'] = 3;
		transM[3]['v'] = 3;
		transM[3]['w'] = 3;
		transM[3]['x'] = 3;
		transM[3]['y'] = 3;
		transM[3]['z'] = 3;
		transM[3]['0'] = 3;
		transM[3]['1'] = 3;
		transM[3]['2'] = 3;
		transM[3]['3'] = 3;
		transM[3]['4'] = 3;
		transM[3]['5'] = 3;
		transM[3]['6'] = 3;
		transM[3]['7'] = 3;
		transM[3]['8'] = 3;
		transM[3]['9'] = 3;

		// ... // The values of the other entries are all -1.

	}

	private Token nextToken() {
		int stateOld = 0, stateNew;
		if (!st.hasMoreTokens())
			return null;
		String temp = st.nextToken();
		Token result = null;
		for (int i = 0; i < temp.length(); i++) {
			stateNew = transM[stateOld][temp.charAt(i)];
			if (stateNew == -1) {
				System.out.println(String.format("accepState error %s\n", temp));
				return null;
			}
			stateOld = stateNew;
		}
		for (TokenType t : TokenType.values()) {
			if (t.finalState == stateOld) {
				result = new Token(t, temp);
				break;
			}
		}
		return result;
	}

	public List<Token> tokenize() { // Token 리스트반환, nextToken()이용..
		List<Token> list = new ArrayList<Token>();
		Token temp = this.nextToken();
		while (temp != null) {
			list.add(temp);
			temp = this.nextToken();
		}
		return list;
	}

	public static void main(String[] args) { // txt file to String

		try {
			FileReader fr;
			fr = new FileReader("C:\\Users\\goodd\\Desktop\\hw02.txt");
			BufferedReader br = new BufferedReader(fr);
			String source = br.readLine();

			Scanner s = new Scanner(source);
			List<Token> tokens = s.tokenize();

			int size = tokens.size();
			for (int index = 0; index < size; index++) {
				System.out.println(tokens.get(index));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}