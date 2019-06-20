package u5.test;

import u5.genlist.GenList;
import u5.matrix.Matrix;

public class Test {

	public static void testMatrix() {
		int[][] values = new int[3][4];
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 4; j++)
				values[i][j] = i + j;
		Matrix m = new Matrix(5, 6, values);
		System.out.println(m);
	}

	public static void testGenList() {
		Integer[] integers_1 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Integer[] integers_2 = { 20, 21, 22, 23 };
		Integer[] integers_3 = { 45, 56, 67 };
		GenList<Integer> genList = new GenList<Integer>(integers_1);
		GenList<Integer> genList2 = new GenList<Integer>(integers_2);
		GenList<Integer> genList3 = new GenList<Integer>(integers_3);
		//GenList<Integer> genList4 = new GenList<Integer>(genList);
		System.out.println("\n-------原子构造-----------");
		System.out.println("genlist---" + genList);
		System.out.println("genlist2--" + genList2);
		System.out.println("genlist3--" + genList3);
		
		System.out.println("----拷贝构造（递归实现）---------");
		//System.out.println("genlist4--" + genList4);

		System.out.println("\n-----插入原子-----------");
		genList.insert(100);
		System.out.println(genList);
		genList.insert(1, 500);
		System.out.println(genList);

		System.out.println("\n-----插入子表-----------");
		genList.insert(genList2);
		System.out.println(genList);
		genList.insert(5, genList2);
		System.out.println(genList);

		System.out.println("\n------删除元素----------");
		genList.remove(4);
		System.out.println(genList);
		genList.remove(12);
		System.out.println(genList);
		genList.remove(Integer.MAX_VALUE);
		System.out.println(genList);

		System.out.println("\n------深度和广度----------");
		genList = new GenList<Integer>(integers_1);
		System.out.println("genList: " + genList);
		System.out.println("genList " + "size: " + genList.size() + "\tdepth:" + genList.depth());
		genList.insert(genList2);
		genList2.insert(genList3);
		System.out.println("genList: " + genList);
		System.out.println("genList " + "size: " + genList.size() + "\tdepth:" + genList.depth());
		genList.insert(genList3);
		System.out.println("genList: " + genList);
		System.out.println("genList " + "size: " + genList.size() + "\tdepth:" + genList.depth());
		
	}

	public static void main(String[] args) {
		//testMatrix();
		testGenList();
	}
}
