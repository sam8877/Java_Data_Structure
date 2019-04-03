package u2.test;

import u2.doubly.DoublyList;

public class TestDoublyList {
	public static void main(String[] args) {
		Integer[] values = {1,2,3,4,5,6,7,8,9,0};
		
		System.out.println("--------�����鴴��˫����------------");
		DoublyList<Integer> list1 = new DoublyList<>(values);
		System.out.println(list1);
		
		System.out.println("\n--------��˫������˫����-----------");
		DoublyList<Integer> list2 = new DoublyList<>(values);
		System.out.println(list2);
		System.out.println("list�ĳ��� ��" + list2.size());
		
		System.out.println("\n------����get(int i)------------");
		for(int i=0; i < 16; i++)
			System.out.println("get(" + i + ")-->" + " : " + list1.get(i));
		
		System.out.println("\n-----����set(int i, T x)--------�±�Խ������");
		list1.set(0,23);
		System.out.println(list1);
		
	}
}
