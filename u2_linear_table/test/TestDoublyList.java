package u2_linear_table.test;

import u2_linear_table.doubly.DoublyList;

public class TestDoublyList {
	public static void main(String[] args) {
		Integer[] values = {1,2,3,4,5,6,7,8,9,0};
		
		System.out.println("--------由数组创建双链表------------");
		DoublyList<Integer> list1 = new DoublyList<>(values);
		System.out.println(list1);
		
		System.out.println("\n--------由双链表创建双链表-----------");
		DoublyList<Integer> list2 = new DoublyList<>(values);
		System.out.println(list2);
		System.out.println("list的长度 ：" + list2.size());
		
		System.out.println("\n------测试get(int i)------------");
		for(int i=0; i < 16; i++)
			System.out.println("get(" + i + ")-->" + " : " + list1.get(i));
		
		System.out.println("\n-----测试set(int i, T x)--------下标越界提醒");
		list1.set(0,23);
		System.out.println(list1);
		
	}
}
