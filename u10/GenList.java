package u10;

import u4.stack.LinkedStack;
import u4.stack.Stack;

public class GenList<T> {
	public GenNode<T> head;

	public GenList() {
		this.head = new GenNode<T>();
	}

	// 插入子表作为第i个元素,对i容错
	public GenNode<T> insert(int i, GenList<T> genList) {
		if (i < 0)
			i = 0;
		GenNode<T> p = this.head; // 指向头节点
		for (int k = 0; k < i && p.next != null; k++)// 将指针拨到插入点
			p = p.next;
		p.next = new GenNode<T>(null, genList, p.next);
		return p;
	}

	public GenNode<T> insertAs(int i, T data, GenList<T> genList) {
		if (i < 0)
			i = 0;
		GenNode<T> p = this.head; // 指向头节点
		for (int k = 0; k < i && p.next != null; k++)// 将指针拨到插入点
			p = p.next;
		p.next = new GenNode<T>(data, genList, p.next);
		return p;
	}

	public GenList(T[] atoms) {
		this();
		GenNode<T> p = this.head;
		for (T atom : atoms) {
			p.next = new GenNode<T>(atom, null, p.next);// 尾插入
			p = p.next;
		}
	}

	public GenNode<T> insert(GenList<T> genList) {
		return this.insert(Integer.MAX_VALUE, genList);
	}

	public String toString() {
		return this.toString("");
	}

	public String toString(String str) {
		str += "(";
		for (GenNode<T> p = this.head.next; p != null; p = p.next) {
			if (p.data != null) {
				str += p.toString();
			}
			if (p.child != null) {
				str += p.child.toString();
			}
			if (p.next != null)
				str += ",";
		}
		str += ")";
		return str;
	}

	// 图的深度优先搜索遍历算法，先根次序递归遍历孩子子树，循环遍历兄弟子树
	public GenList<T> copyGenListFrom1(GenList<T> genList) { // 广义表拷贝构造方法（递归实现）
		if (genList == null)
			return null;
		GenList<T> res = new GenList<T>();
		GenNode<T> fro = res.head;
		GenNode<T> p = genList.head.next;
		GenNode<T> q = null;
		while (p != null) {
			fro.next = new GenNode<T>(p.data);
			q = fro.next;
			if (p.child != null) {
				q.child = copyGenListFrom1(p.child);
			}
			fro = fro.next;
			p = p.next;
		}
		return res;
	}

	// 先根次序遍历树的递归算法，递归遍历孩子子树和兄弟子树
	public GenList<T> copyGenListFrom2(GenList<T> genList) {
		if (genList == null)
			return null;
		GenList<T> res = new GenList<T>();
		GenNode<T> fro = res.head;
		GenNode<T> p = genList.head.next;
		while (p != null) {
			fro.next = copyGenListFrom2(p);
			fro = fro.next;
			p = p.next;
		}
		return res;
	}

	public GenNode<T> copyGenListFrom2(GenNode<T> node) {
		if (node == null)
			return null;
		GenNode<T> res = new GenNode<T>(node.data);
		if (node.child != null) {
			res.child = node.child.copyGenListFrom2(node.child);
		}
		return res;
	}

	// 先根次序遍历树的非递归算法，使用栈
	public GenList<T> copyGenListFrom3(GenList<T> genList) {
		GenList<T> res = new GenList<T>();
		Stack<GenNode<T>> pathStack = new LinkedStack<GenNode<T>>(); // 记录路径
		Stack<GenNode<T>> reverseStack = new LinkedStack<GenNode<T>>(); // 翻转顺序
		GenNode<T> p = genList.head;
		while (p != null) {
			pathStack.push(p);
			if (p.child != null) {
//				System.out.println("p:" + p + "有孩子");
				p = p.child.head;
			} else {
				if (p.next != null) {
//					System.out.println("p:" + p + "有兄弟");
					p = p.next;
				} else {
					while (p != null && p.next == null) {
						// head 的特点：data和child不能都为null
//						System.out.println("--->path " + pathStack);
//						System.out.println("--->reverse " + reverseStack);
						
						//弹出当前层的所有节点，并将非头节点压入翻转栈
						while (pathStack.peek().data != null || pathStack.peek().child != null)
							reverseStack.push(pathStack.pop());
						pathStack.pop();
						
//						System.out.println(pathStack);
//						System.out.println(reverseStack);

						//将reverse栈中的元素构建成一张表
						GenList<T> list = new GenList<T>();
						GenNode<T> tmp = null;
						for (p = list.head; p != null; p = p.next) {
							tmp = reverseStack.pop();
							if (tmp != null) {
								if (tmp.child != null) {
									p.next = tmp;
								}else {
									p.next = new GenNode<T>(tmp);
								}
							}
						}

						p = pathStack.pop();		//弹出构建出来表的父节点
						if (p != null) {
							res.head.next = new GenNode<T>(p.data, list, null);
//							System.out.println("head.next:  " + res.head.next);
							pathStack.push(res.head.next);
							if (p.next != null)
								p = p.next;
						} else {
							res = list;
						}
//						System.out.println("res-->" + res);
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Integer[] list1 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Integer[] list2 = { 11, 22, 33, 44, 55 };
		GenList<Integer> genList1 = new GenList<Integer>(list1);
		GenList<Integer> genList2 = new GenList<Integer>(list2);
		genList1.insertAs(2, 500, genList2);
		GenList<Integer> genList3 = genList1.copyGenListFrom1(genList1);
		GenList<Integer> genList4 = genList1.copyGenListFrom2(genList1);
		GenList<Integer> genList5 = new GenList<Integer>();
		genList5.insertAs(0, -1, genList1);
		GenList<Integer> genList6 = genList1.copyGenListFrom3(genList5);
		GenList<Integer> genList7 = genList1.copyGenListFrom3(genList1);

		System.out.println("genlist1-->" + genList1 + "---------原子构造方法,加插入(森林)");
		System.out.println("genlist3-->" + genList3 + "-------从genList1拷贝构造,方法1(森林)");
		System.out.println("genlist4-->" + genList4 + "-------从genList1拷贝构造,方法2(森林) ");
		System.out.println("genlist5-->" + genList5 + "-------构建一棵树 ");
		System.out.println("genlist6-->" + genList6);
		System.out.println("genlist7-->" + genList7);

	}

}
