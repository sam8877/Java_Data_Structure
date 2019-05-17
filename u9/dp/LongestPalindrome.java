package u9.dp;

/*
 *	 求最长回文串
 */

public class LongestPalindrome {
	public static String dp(String s) {
		if (s.length() < 2)
			return s;
		int start = 0, end = 0, len = s.length();
		boolean[][] opt = new boolean[len][len];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j <= i; j++) {
				if (i - j < 2) {
					opt[j][i] = s.charAt(i) == s.charAt(j);
				} else {
					opt[j][i] = opt[j + 1][i - 1] && (s.charAt(i) == s.charAt(j));
				}
				if (opt[j][i] && (end - start) < (i - j)) {
					end = i;
					start = j;
				}
			}
		}
		return s.substring(start, end + 1);
	}

	public static void main(String[] args) {
		String s = "12345678000098765431";
		System.out.println(LongestPalindrome.dp(s));
	}
}
