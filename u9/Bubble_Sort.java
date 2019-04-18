package u9;

public class Bubble_Sort {
	
	public static int[] sort_up(int[] list) {
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
		}
		return list;
	}
	
	public static void main(String[] args) {
		System.out.println("\n--------原数组----------");
		int[] list1 = {46,75,12,4,5,7,5,7,8,5,65,3,5,6,5,89,6,7,4,8,9,45,89};
		for(int i=0; i<list1.length; i++)
			System.out.print(list1[i] + " ");
		
		System.out.println("\n--------排序后-----------");
		int[] list2 = Bubble_Sort.sort_up(list1);
		for(int i=0; i<list2.length; i++)
			System.out.print(list2[i] + " ");
	}
	
}
