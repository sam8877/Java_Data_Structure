package u6.tree;

import u4.stack.LinkedStack;
import u4.stack.Stack;

public class Tree<T> {
	public TreeNode<T> root;

	public Tree() {
		this.root = new TreeNode<T>(null, 0);
	}
	
	public Tree(T data) {
		this.root = new TreeNode<T>(data, 0);
	}

	public Tree(String[] str) {

	}
	
	public String toString(TreeNode<T> node) {
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
					if(!stack.isEmpty())
						sb.append(",");
					p = stack.pop();
					
				}

			}
		}
		return ""+sb;
	}
	public String toString() {
		return this.toString(root);
	}
	
	public void printGenList() {
		System.out.println(this.toString(root));
	}


	
}
