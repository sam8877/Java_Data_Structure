package u9.sort;

public class BubbleSort {
	
	public static int[] sortUp(int[] list) {
		if (list == null) return null;
		int temp;
		for(int i=0; i<list.length-1; i++) {
			for(int j=0; j<list.length-1-i;j++) {
				if(list[j]>list[j+1]) {
					temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
				}
			}
			System.out.print("第"+i+"次：");
			for(int m=0; m<list.length; m++)
				System.out.print(list[m] + " ");
			System.out.println();
		}
		return list;
	}
	
	public static void main(String[] args) {
		System.out.println("\n--------原数组----------");
		int[] list1 = {46,75,12,8,5,65,3,5,6,89,6,7,4,8,9,45,89};
		for(int i=0; i<list1.length; i++)
			System.out.print(list1[i] + " ");
		
		System.out.println("\n--------排序后-----------");
		int[] list2 = BubbleSort.sortUp(list1);
		for(int i=0; i<list2.length; i++)
			System.out.print(list2[i] + " ");
	}
	
}
