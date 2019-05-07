package u9.sort;

/*
 * 快速排序
 */
public class Quicksort {
	
	private static void sort(int[] list, int left, int right) {
		if(left>=right)
			return;
		int i = left, j = right ,temp;
		int key = list[left];
		while(i<j) {
			while(i<j&&list[j]>=key)
				j--;
			while(i<j&&list[i]<=key)
				i++;
			if(i<j) {
				temp = list[i];
				list[i] = list[j];
				list[j] = temp;
			}
		}
		list[left]=list[i];
	    list[i]=key;
	    Quicksort.sort(list, left, i-1);
	    Quicksort.sort(list, i+1, right);
	    
	}
	
	public static void main(String[] args) {
		int[] list = {2,5,6,7,9,4,3,8,1,0};
		Quicksort.sort(list,0,list.length-1);
		for(int i=0;i<list.length;i++)
			System.out.print(list[i] + " ");
	}
	
}
