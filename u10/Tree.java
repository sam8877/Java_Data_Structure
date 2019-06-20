package u10;

import u4.stack.LinkedStack;
import u4.stack.Stack;

public class Tree<T> {
	public TreeNode<T> root;

	public Tree() {
		this.root = new TreeNode<T>();
	}

	public Tree(T data) {
		this.root = new TreeNode<T>(data);
	}

	public Tree(T[] list) {
		TreeNode<T> head = new TreeNode<>();
		TreeNode<T> p = head;
		for (int i = 0; i < list.length; i++) {
			p.sibling = new TreeNode<T>(list[i], null, null, null);
			p = p.sibling;
		}
		this.root = head.sibling;
	}

	public TreeNode<T> copyTreeFrom1(TreeNode<T> node) {
		TreeNode<T> res = null;
		if(node!=null){
			res = new TreeNode<T>(node.data);
			res.child = copyTreeFrom1(node.child);
			res.sibling = copyTreeFrom1(node.sibling);
		}
		return res;
	}

	public TreeNode<T> copyTreeFrom2(TreeNode<T> node) {
		if (node == null)
			return null;
		TreeNode<T> head = new TreeNode<T>();
		TreeNode<T> p = head;
		TreeNode<T> q = node;
		while (q != null) {
			p.sibling = new TreeNode<T>(q.data, null, null, null);
			if (q.child != null) {
				p.sibling.child = copyTreeFrom2(q.child);
			}
			q = q.sibling;
			p = p.sibling;
		}

		return head.sibling;
	}
	
	public TreeNode<T> copyTreeFrom3(TreeNode<T> node) {
		TreeNode<T> p = node;
		TreeNode<T> q = new TreeNode<T>(node.data);
		TreeNode<T> res = new TreeNode<>(null, null, null, p);

		Stack<TreeNode<T>> p_path = new LinkedStack<>();
		Stack<TreeNode<T>> q_path = new LinkedStack<>();
		while (p != null) {
			if (p.child!=null) {
				p_path.push(p);
				q_path.push(q);
				q.child = new TreeNode<T>(p.child.data);
				p = p.child;
				q = q.child;
			} else {
				while (p.sibling == null && !p_path.isEmpty()) {
					p = p_path.pop();
					q = q_path.pop();
				}
				q.sibling = new TreeNode<T>(p.sibling);
				p = p.sibling;
				q = q.sibling;
			}
		}
		
		return res.sibling;
	}

	@Override
	public String toString() {
		return this.toString(root);
	}

	public String toString(TreeNode<T> node) {
		if (node == null)
			return "";
		String str = "(";
		for (TreeNode<T> p = node; p != null; p = p.sibling) {
			str += p.toString();
			if (p.child != null)
				str += toString(p.child);
			if (p.sibling != null)
				str += ",";
		}
		return str + ")";
	}

	public static void main(String[] args) {
		Integer[] list1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Integer[] list2 = { 11, 22, 33, 44, 55 };
		Tree<Integer> tree1 = new Tree<>(list1);
		Tree<Integer> tree2 = new Tree<>(list2);
		tree1.root.sibling.child = tree2.root;
		System.out.println(tree1+"\n------------构建tree1-----------\n");
		
		Tree<Integer> tree3 = new Tree<>();
		tree3.root = tree3.copyTreeFrom1(tree1.root);
		
		Tree<Integer> tree4 = new Tree<>();
		tree4.root = tree4.copyTreeFrom2(tree1.root);
		
		Tree<Integer> tree5 = new Tree<>();
		tree5.root = tree5.copyTreeFrom3(tree1.root);
		
		System.out.println(tree3+"\n------------构建tree3(方法1)-----------\n");
		System.out.println(tree4+"\n------------构建tree4(方法2)-----------\n");
		System.out.println(tree5+"\n------------构建tree5(方法3)-----------\n");
		
		
	}
}
