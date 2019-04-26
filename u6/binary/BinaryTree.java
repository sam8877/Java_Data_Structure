package u6.binary;

public class BinaryTree<T> {
	
	public BinaryNode<T> root;
	
	public BinaryTree() {
		this.root = null;
	}
	public BinaryTree(T[] prelist) {
		
	}
	public BinaryNode<T> create(T[] list){
		BinaryNode<T> p = null;
		return p;
	}
	
	public boolean isEmpty() {
		return this.root==null;
	}
	
	public BinaryNode<T> insert(T x){
		return this.root = new BinaryNode<T>(x, this.root, null);
	}
	public BinaryNode<T> insert(BinaryNode<T> parent, T x, boolean leftChild){
		if(x==null) return null;
		if(leftChild) {
			return parent.left = new BinaryNode<T>(x, parent.left, null);
		}else {
			return parent.right = new BinaryNode<T>(x, null, parent.right);
		}
	}
	
	public void remove(BinaryNode<T> parent, boolean leftChild) {
		if(leftChild)
			parent.left = null;
		else
			parent.right = null;
	}
	public void clear() {
		this.root = null;
	}
	
	public void preorder(BinaryNode<T> p) {
		if(p!=null) {
			System.out.print(p.data.toString() + " ");
			preorder(p.left);
			preorder(p.right);
		}
	}
	public void preorder() {
		this.preorder(this.root);
	}
	public void inorder(BinaryNode<T> p) {
		if(p!=null) {
			inorder(p.left);
			System.out.print(p.data.toString() + " ");
			inorder(p.right);
		}
	}
	public void inorder() {
		this.inorder(this.root);
	}
	public void postorder(BinaryNode<T> p) {
		if(p!=null) {
			inorder(p.left);
			inorder(p.right);
			System.out.print(p.data.toString() + " ");
		}
	}
	public void postorder() {
		this.postorder(this.root);
	}
	
	public void printGenlist(BinaryNode<T> p) {
		if(p==null) {
			System.out.print("^");
		}else {
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
		if(p==null) return 0;
		if(p.isLeaf()) return 1;
		return 1+size(p.left)+size(p.right);
	}
	public int height(BinaryNode<T> p) {
		if(p==null||p.isLeaf())
			return 0;
		int left_h = this.height(p.left);
		int right_h = this.height(p.right);
		return 1+(left_h>right_h?left_h:right_h);
	}
	
}
