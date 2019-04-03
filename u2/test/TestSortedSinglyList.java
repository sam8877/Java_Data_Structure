package u2.test;

import u2.singaly.Node;
import u2.singaly.SortedSignalyList;

public class TestSortedSinglyList {
	
	
	public static void main(String[] args) {
		Integer[] values = {0,1,2,3,4,5,6,7,8,9,10,11,12,13};
		//Integer[] values2 = {9,8,7,6,5,4,3,2,1,0};
		//Integer[] values3 = {0};
		
		System.out.println("\n------由数组构造排序单链表------------");
		SortedSignalyList<Integer> list0 = new SortedSignalyList<Integer>(values);
		System.out.println(list0);
		list0.reverse();	//翻转
		
		System.out.println("\n------由单链表构造排序单链表------------");
		SortedSignalyList<Integer> list1 = new SortedSignalyList<Integer>(list0);
		System.out.println(list1);
		
		System.out.println("\n------由排序单链表构造排序单链表------------");
		SortedSignalyList<Integer> list2 = new SortedSignalyList<Integer>(list1);
		System.out.println(list2);
		
		System.out.println("\n------测试Search()方法------------");
		Integer integer = new Integer(0);
		Node<Integer> p = list2.search(integer);
		System.out.println(p.hashCode() + "   " + p);
		
		
	}
}
