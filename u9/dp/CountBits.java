package u9.dp;

/*
 * Given a non negative integer number num. 
 * For every numbers i in the range 0 ≤ i ≤ num 
 * calculate the number of 1's in their binary representation 
 * and return them as an array.
 */
public class CountBits {
	public static int[] dp(int n) {
		int[] res = new int[n + 1];
		if (n >= 0)
			res[0] = 0;
		if (n >= 1)
			res[1] = 1;
		if (n >= 2)
			res[2] = 1;
		for (int i = 3; i < n + 1; i++) {
			if (i % 2 == 1) {
				res[i] = res[i - 1] + 1;
			} else {
				res[i] = res[i >> 1];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] res = CountBits.dp(20);
		for (int i = 0; i < res.length; i++) {
			System.out.println(i + ":" + res[i]);
		}
	}
}
