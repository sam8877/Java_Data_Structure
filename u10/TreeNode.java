package u10;

public class TreeNode<T> {
	public T data;
	public TreeNode<T> parent, child, sibling;

	public TreeNode(T data, TreeNode<T> parent, TreeNode<T> child, TreeNode<T> sibling) {
		this.data = data;
		this.parent = parent;
		this.child = child;
		this.sibling = sibling;
		
	}

	public TreeNode(T data) {
		this(data, null, null, null);
	}

	public TreeNode() {
		this(null, null, null, null);
	}

	public TreeNode(TreeNode<T> node) {
		this();
		if(node!=null){
			this.data = node.data;
			this.parent = node.parent;
			this.child = node.child;
			this.sibling = node.sibling;
		}
	}

	public String toString() {
		return this.data==null?"null":this.data.toString();
	}
	
	public boolean isLeaf() {
		return (this.child == null);
	}
}
