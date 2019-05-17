package u3;

public class KMP {

	private static int[] getNext(String pattern) {
		int j = 0, k = -1;
		int[] next = new int[pattern.length()];
		next[0] = -1;
		while (j < pattern.length() - 1) {
			if (k == -1 || pattern.charAt(j) == pattern.charAt(k)) {
				j++;
				k++;
				if (pattern.charAt(j) != pattern.charAt(k))
					next[j] = k;
				else {
					next[j] = next[k];
				}
			} else {
				k = next[k];
			}
		}

		return next;
	}

	public static int indexOf(String target, String pattern, int begin) {

		int n = target.length(), m = pattern.length();
		if (begin < 0)
			begin = 0;
		if (n == 0 || begin >= n || n < m)
			return -1;
		int[] next = getNext(pattern);

		int i = begin, j = 0;
		while (i < n && j < m) {
			if (j == -1 || target.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;// 相同则将下标向后拨
			} else {// 不相同则将j拨到下次匹配的地方
				j = next[j];
				if (n - i < m - j)
					break; // 长度不够则不再处理
			}
			if (j == m)
				return i - j;
		}

		return -1;
	}

	public static void main(String[] args) {
		String target = "0123456789";
		String pattern = "456";
		System.out.println(KMP.indexOf(target, pattern, 1));

	}
}
