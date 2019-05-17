package u2.singaly;

public class Node<T> {
	public T data;
	public Node<T> next;

	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}

	public Node() {
		this(null, null);
	}

	public String toString(){
		if (this.data!=null)
			return this.data.toString();
		else 
			return "null";
	}

}
