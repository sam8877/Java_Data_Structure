package u9.sort;

public class InsertSort {
	public static int[] sortUp(int[] list) {
		int temp;
		for(int i=1;i<list.length;i++) {//进行length-1次插入
			for(int j=0; j<i ;j++) {
				if(list[i]<list[j]) {	//定位到要插入的位置
					temp = list[i];
					for(int k=i-1;k>=j;k--) {
						list[k+1] = list[k];
					}
					list[j] = temp;
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
		System.out.println("插入排序");
		System.out.println("\n--------原数组----------");
		int[] list1 = {46,75,12,7,65,3,5,89,6,8,9,45,89};
		for(int i=0; i<list1.length; i++)
			System.out.print(list1[i] + " ");
		
		System.out.println("\n--------排序-----------");
		int[] list2 = InsertSort.sortUp(list1);
		for(int i=0; i<list2.length; i++)
			System.out.print(list2[i] + " ");
	}
}
