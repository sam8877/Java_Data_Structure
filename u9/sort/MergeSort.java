package u9.sort;

/*
 * 归并排序
 */
public class MergeSort {
	
	public static void sort(int[] list) {
		int[] temp = new int[list.length];
		MergeSort.sort(list, 0, list.length, temp);
	}
	
	private static void sort(int[] list,int left,int right,int []temp){
        if(left+1!=right){
            int mid = (left+right)/2;
            MergeSort.sort(list,left,mid,temp);//左边归并排序，使得左子序列有序
            MergeSort.sort(list,mid,right,temp);//右边归并排序，使得右子序列有序
            MergeSort.merge(list,left,mid,right,temp);//将两个有序子数组合并操作
        }
    }
	
	private static void merge(int[] list,int left,int mid, int right, int[] res) {
		int i = left, j=mid ,k=left;
		while(i<mid&&j<right)
			res[k++] = list[i]<list[j]?list[i++]:list[j++];
		if(i==mid)
			while(k<right)
				res[k++]=list[j++];
		if(j==right)
			while(k<right)
				res[k++]=list[i++];
		for(int z=left; z<right;z++) {
			list[z] = res[z];
		}
	}
	
	
	public static void main(String[] args) {
		//int[] list = {3,5,7,9,11,13,2,4,6,8,10,12,14,16};
		int[] list = {2,5,6,7,9,4,3,8,1,0};
		//MergeSort.merge(list, 0, 6, list.length,new int[20]);
		
		MergeSort.sort(list);
		for(int i=0;i<list.length;i++)
			System.out.print(list[i] + " ");
	}

}
