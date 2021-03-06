package u6.tree;

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

	public String toString() {
		return this.data==null?"":this.data.toString();
	}

	public boolean isLeaf() {
		return (this.child == null);
	}
}
