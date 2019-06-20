package u6.binary;

import u4.stack.LinkedStack;
import u4.stack.SeqStack;
import u4.stack.Stack;

public class BinaryTree<T> {

	public BinaryNode<T> root;

	public BinaryTree() {
		this.root = null;
	}

	public BinaryTree(T[] prelist) {

	}

	public BinaryNode<T> create(T[] list) {
		BinaryNode<T> p = null;
		return p;
	}

	public BinaryTree(BinaryTree<T> tree) {
		// construct from p's root
		this.root = this.copy(tree.root);
	}

	public BinaryNode<T> copy(BinaryNode<T> p) {
		BinaryNode<T> q = new BinaryNode<T>(p.data);
		if (p.left != null)
			q.left = this.copy(p.left);
		if (p.right != null)
			q.right = this.copy(p.right);
		return q;

	}

	public BinaryNode<T> copy2(BinaryNode<T> p) {
		BinaryNode<T> q = null;
		if (p != null) {
			q = new BinaryNode<T>(p.data);
			q.left = this.copy(p.left);
			q.right = this.copy(p.right);
		}
		return q;

	}

	public boolean isEmpty() {
		return this.root == null;
	}

	public BinaryNode<T> insert(T x) {
		return this.root = new BinaryNode<T>(x, this.root, null);
	}

	public BinaryNode<T> insert(BinaryNode<T> parent, T x, boolean leftChild) {
		if (x == null)
			return null;
		if (leftChild) {
			return parent.left = new BinaryNode<T>(x, parent.left, null);
		} else {
			return parent.right = new BinaryNode<T>(x, null, parent.right);
		}
	}

	public void remove(BinaryNode<T> parent, boolean leftChild) {
		if (leftChild)
			parent.left = null;
		else
			parent.right = null;
	}

	public void clear() {
		this.root = null;
	}

	public void preorder(BinaryNode<T> p) {
		if (p != null) {
			System.out.print(p.data.toString() + " ");
			preorder(p.left);
			preorder(p.right);
		}
	}

	public void preorder() {
		this.preorder(this.root);
	}

	public void inorder(BinaryNode<T> p) {
		if (p != null) {
			inorder(p.left);
			System.out.print(p.data.toString() + " ");
			inorder(p.right);
		}
	}

	public void inorder() {
		this.inorder(this.root);
	}

	public void postorder(BinaryNode<T> p) {
		if (p != null) {
			inorder(p.left);
			inorder(p.right);
			System.out.print(p.data.toString() + " ");
		}
	}

	public void postorder() {
		this.postorder(this.root);
	}

	public void printGenlist(BinaryNode<T> p) {
		if (p == null) {
			System.out.print("^");
		} else {
			System.out.print(p.data);
			if (!p.isLeaf()) {
				System.out.print("(");
				printGenlist(p.left);
				System.out.print(",");
				printGenlist(p.right);
				System.out.print(")");
			}
		}
	}

	public void printGenlist() {
		this.printGenlist(this.root);
	}

	public int size(BinaryNode<T> p) {
		if (p == null)
			return 0;
		if (p.isLeaf())
			return 1;
		return 1 + size(p.left) + size(p.right);
	}

	public int height(BinaryNode<T> p) {
		if (p == null || p.isLeaf())
			return 0;
		int left_h = this.height(p.left);
		int right_h = this.height(p.right);
		return 1 + (left_h > right_h ? left_h : right_h);
	}

	public int height2(BinaryNode<T> p) {
		return 0;
	}

	public String[] getLeafPaths(BinaryNode<T> p) throws Exception {
		if (p == null)
			return null;
		String[] res1 = getLeafPaths(p.left);
		String[] res2 = getLeafPaths(p.right);
		if (res1 == null && res2 == null) { // 叶子节点直接返回p.data
			return new String[] { p.toString() };
		}
		if (res1 != null && res2 != null) {
			for (int i = 0; i < res1.length; i++) {
				res1[i] = (p.toString() + "->" + res1[i]);
			}
			for (int i = 0; i < res2.length; i++) {
				res2[i] = (p.toString() + "->" + res2[i]);
			}
			String[] res = new String[res1.length + res2.length];

			int j = 0; // 将res1和res2复制到res中
			while (j < res1.length) {
				res[j] = res1[j];
				j++;
			}
			while (j < res.length) {
				res[j] = res2[j - res1.length];
				j++;
			}
			return res;
		}
		if (res1 == null && res2 != null) {
			for (int i = 0; i < res2.length; i++)
				res2[i] = (p.toString() + "->" + res2[i]);
			return res2;
		}
		if (res1 != null && res2 == null) {
			for (int i = 0; i < res1.length; i++)
				res1[i] = (p.toString() + "->" + res1[i]);
			return res1;
		}
		return null;
	}

	public void printLeafPath() throws Exception {
		String[] paths = getLeafPaths(root);
		for (int i = 0; i < paths.length; i++) {
			System.out.println(paths[i]);
		}
	}

	public void printLeafPaths() {
		BinaryNode<T> p = this.root;
		Stack<BinaryNode<T>> path = new LinkedStack<>();
		Stack<Integer> stat = new SeqStack<>();
		while (p != null) {
			path.push(p);
			stat.push(0);
			if (p.isLeaf())
				System.out.println(path);
			if (p.left != null) {
				p = p.left;
			} else {
				if (p.right == null) {
					stat.pop();
					stat.push(1);
					while ((Integer.valueOf(1)).equals(stat.peek())) {
						path.pop();
						stat.pop();
					}
					p = path.peek();
					p = (p == null) ? null : p.right;
					stat.pop();
					stat.push(1);
				} else {
					stat.pop();
					stat.push(1);
					p = p.right;
				}

			}
		}
	}

}
