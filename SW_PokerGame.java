import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_PokerGame {
	static String[] str;
	static int[] s, r;
	static String result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			result = "High card";
			s = new int[4];
			r = new int[14];
			str = new String[5];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 5; i++) {
				str[i] = st.nextToken();
				s[find_suit(str[i].charAt(0))]++;
				r[find_rank(str[i].charAt(1))]++;

			}
			
			find(str);

			System.out.println("#" + t + " " + result);

		}
	}

	static int find_suit(char c) {
		if (c == 'S')
			return 0;
		else if (c == 'D')
			return 1;
		else if (c == 'H')
			return 2;
		else
			return 3;
	}

	static int find_rank(char c) {
		if (c == 'A') {
			return 1;
		} else if (c == 'T') {
			return 10;
		} else if (c == 'J') {
			return 11;
		} else if (c == 'Q') {
			return 12;
		} else if (c == 'K') {
			return 13;
		} else {
			return c - '0';
		}
	}

	static void find(String[] str) {
		for (int i = 1; i < 14; i++) {
			if (r[i] == 2) {
				result = "One pair";
				break;
			}
		}
		boolean two = false;
		for (int i = 1; i < 14; i++) {
			if (!two && r[i] == 2) {
				two = true;
			} else if (two && r[i] == 2) {
				result = "Two pair";
				break;
			}
		}

		for (int i = 1; i < 14; i++) {
			if (r[i] == 3) {
				result = "Three of a kind";
				break;
			}
		}

		for (int i = 1; i < 10; i++) {
			if (r[i] == 1 && r[i + 1] == 1 && r[i + 2] == 1 && r[i + 3] == 1 && r[i + 4] == 1) {
				result = "Straight";
				break;
			}
		}
		boolean flush = false;
		for (int i = 0; i < 4; i++) {
			if (s[i] == 5) {
				result = "Flush";
				flush = true;
				break;
			}
		}
		boolean fw = false, ft = false;
		for (int i = 0; i < 14; i++) {
			if (r[i] == 2) {
				fw = true;
			} else if (r[i] == 3) {
				ft = true;
			}
			if (fw && ft) {
				result = "Full House";
				break;
			}
		}

		for (int i = 0; i < 14; i++) {
			if (r[i] == 4) {
				result = "Four of a Kind";
				break;
			}
		}

		if (flush) {
			for (int i = 0; i < 10; i++) {
				if (r[i] == 1 && r[i + 1] == 1 && r[i + 2] == 1 && r[i + 3] == 1 && r[i + 4] == 1) {
					result = "Straight Flush";
					break;
				}
			}
		}
	}
}
