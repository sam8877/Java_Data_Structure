package u2_linear_table.doubly;

public class DoubleNode<T> {
	public T data;
	public DoubleNode<T> pre,next;
	
	public DoubleNode(T data, DoubleNode<T> pre, DoubleNode<T> next) {
		this.data = data;
		this.next = next;
		this.pre = pre;
	}
	public DoubleNode(T data) {
		this(data,null,null);
	}
	public DoubleNode() {
		this(null, null, null);
	}
	public String toString() {
		return this.data.toString();
	}
	
}
