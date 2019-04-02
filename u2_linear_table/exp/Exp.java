package u2_linear_table.exp;

public class Exp {

	public static void main(String[] args) throws Exception {
		Integer[] val1 = {1,3,4,6,7,9,10};
		Integer[] val2 = {1,5,9};
		
		SinglyList<Integer> list1 = new SinglyList<Integer>(val1);
		System.out.println("list1 : " + list1);
		
		SinglyList<Integer> list2 = new SinglyList<Integer>(val2);
		System.out.println("list2 : " + list2);
		
		SinglyList<Integer> list3 = list1.difference(list2);
		System.out.println(list3);
		
 	}

}
