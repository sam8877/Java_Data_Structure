package u10;

public class GenNode<T> {
	public T data; // 数据
	public GenList<T> child; // 子表
	public GenNode<T> next; // 子节点

	public GenNode(T data, GenList<T> child, GenNode<T> next) {
		this.data = data;
		this.child = child;
		this.next = next;
	}

	public GenNode(T data) {
		this.data = data;
		this.child = null;
		this.next = null;
	}

	public GenNode() {
		this.data = null;
		this.child = null;
		this.next = null;
	}
	
	public GenNode(GenNode<T> node) {
		this.data = node.data;
	}

	public String toString() {
		return this.data==null?"":data.toString();
	}

}
