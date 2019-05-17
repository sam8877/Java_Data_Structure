package u6.binary;

public class BinaryNode<T> {
	public T data;
	public BinaryNode<T> left, right;

	public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public BinaryNode(T data) {
		this(data, null, null);
	}

	public BinaryNode() {
		this(null, null, null);
	}

	public String toString() {
		return this.data.toString();
	}

	public boolean isLeaf() {
		return this.left == null && this.right == null;
	}
}
