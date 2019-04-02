package u2_linear_table.test;

import u2_linear_table.singaly.SinglyList;

public class TestSinglylList {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Integer[]  values = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		SinglyList<Integer> list = new SinglyList<Integer>(values);
		System.out.println(list);
		System.out.println("------------");
		System.out.println(list.reverse());
		
		
		SinglyList<Integer> list3 = new SinglyList<Integer>(list);
		System.out.println(list3);
		list3.addAll(list);
		System.out.println(list3);
		
	}
	
}
