package u10;

public class Arm {
	public static boolean isArm(int num) {
		int tmp = num;
		int dig = 0;
		int[] arr = new int[3];
		while (tmp > 0) {
			arr[dig] = tmp % 10;
			dig++;
			tmp /= 10;
		}
		int t2 = (int) (Math.pow(arr[2], 3) + Math.pow(arr[1], 3) + Math.pow(arr[0], 3));
		if (dig != 3 || t2 != num) {
			return false;
		} else {
			return true;
		}
	}

	public static void printArmstrongNum() {
		for (int i = 100; i < 1000; i++) {
			if (isArm(i)) {
				System.out.println(i + " ");
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("------");
		printArmstrongNum();
		// System.out.println(isArm(370));
	}
}
