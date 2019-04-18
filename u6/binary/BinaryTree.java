package u6.binary;

public class BinaryTree<T> {
	
	public BinaryNode<T> root;
	
	public BinaryTree() {
		this.root = null;
	}
	
	public boolean isEmpty() {
		return this.root==null;
	}
	
	//插入x作为根节点， 原根节点作为x的子节点，返回插入节点
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
			System.out.println(p.data.toString() + "");
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
			System.out.println(p.data.toString() + " ");
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
			System.out.println(p.data.toString() + " ");
		}
	}
	public void postorder() {
		this.inorder(this.root);
	}
	
	public int size(BinaryNode<T> p) {
		return 0;
	}
	public int height() {
		return 0;
	}
}
