package u9.sort;

public class SelectSort {
	public static int[] sortUp(int[] list) {
		int temp, max = 0;
		for (int i = list.length; i > 0; i--) {
			for (int j = 0; j < i; j++) { // 找出最大值的下标
				if (list[j] > list[max]) {
					max = j;
				}
			}
			if (max != i) {
				temp = list[max];
				list[max] = list[i - 1];
				list[i - 1] = temp;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		System.out.println("\n--------原数组----------");
		int[] list1 = { 46, 75, 12, 4, 5, 7, 5, 7, 8, 5, 65, 3, 5, 6, 5, 89, 6, 7, 4, 8, 9, 45, 89 };
		for (int i = 0; i < list1.length; i++)
			System.out.print(list1[i] + " ");

		System.out.println("\n--------排序后-----------");
		int[] list2 = SelectSort.sortUp(list1);
		for (int i = 0; i < list2.length; i++)
			System.out.print(list2[i] + " ");
	}
}
