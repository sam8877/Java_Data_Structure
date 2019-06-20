package u6.tree;

import u4.stack.LinkedStack;
import u4.stack.Stack;
import u5.genlist.GenNode;

public class Tree<T> {
	public TreeNode<T> root;

	public Tree() {
		this.root = new TreeNode<T>(null);
	}

	public Tree(T data) {
		this.root = new TreeNode<T>(data);
	}

	public Tree(String[] str) {

	}

	public String toString(TreeNode<T> node) { // 非递归实际函数
		if (node == null)
			return "";
		TreeNode<T> p = node;
		StringBuffer sb = new StringBuffer();
		Stack<TreeNode<T>> stack = new LinkedStack<>();
		while (p != null) {
			if (p.sibling != null)
				stack.push(p.sibling);
			if (p.child != null) {
				sb.append(p + "(");
				p = p.child;
			} else {
				if (p.sibling != null) {
					sb.append(p + ",");
					p = stack.pop();
				} else {
					sb.append(p + ")");
					if (!stack.isEmpty())
						sb.append(",");
					p = stack.pop();

				}

			}
		}
		return "" + sb;
	}

	public String toString() { // 非递归调用函数
		return this.toString(root);
	}

	public String toString1(TreeNode<T> node) { // 非递归版本2
		if (node == null)
			return "";
		TreeNode<T> p = node;
		StringBuffer sb = new StringBuffer();
		Stack<TreeNode<T>> stack = new LinkedStack<>();

		while (p != null) {
			if (!p.isLeaf()) {
				sb.append(p.data + "(");
				stack.push(p);
				p = p.child;
			} else {
				sb.append(p.data);
				if (p.sibling != null) {
					sb.append(",");
					p = p.sibling;
				} else {
					p = stack.pop().sibling;
					sb.append(")");
					if (!stack.isEmpty()) {
						sb.append(",");
					}
				}
			}
			System.out.println(sb);
		}

		return "" + sb;
	}

	public String toString2(TreeNode<T> node) { // 递归实际函数
		if (node == null)
			return "";
		String str = "(";
		for (TreeNode<T> p = node; p != null; p = p.sibling) {
			str += p.data.toString();
			if (p.child != null)
				str += this.toString2(p.child);
			if (p.sibling != null)
				str += ",";
		}
		return str + ")";
	}

	public String toStringWithParent(TreeNode<T> p) throws Exception {
		if (p == null)
			throw new Exception();
		String res = "";
		while (p != null) {
			if (p.child != null) {
				res += p.toString() + "(";
				p = p.child;
			} else {
				res += p.toString();
				while (p.sibling == null && p.parent != null) {
					p = p.parent;
					res += ")";
				}
				p = p.sibling;
				if (p != null)
					res += ",";
			}
		}
		return res;
	}

	public void printGenList() throws Exception {
		System.out.println(this.toStringWithParent(root));
	}

}
