package u6.tree;

public class TreeNode<T> {
	public T data;
	public TreeNode<T> parent, child, sibling;
	public int level;

	public TreeNode(T data, TreeNode<T> parent, TreeNode<T> child, TreeNode<T> sibling, int level) {
		this.data = data;
		this.parent = parent;
		this.child = child;
		this.sibling = sibling;
		this.level = level;
	}

	public TreeNode(T data, int level) {
		this(data, null, null, null, level);
	}

	public TreeNode() {
		this(null, null, null, null, 0);
	}

	public String toString() {
		if (this.data != null)
			return this.data.toString();
		else
			return "";
	}

	public boolean isLeaf() {
		return (this.child == null);
	}
}
