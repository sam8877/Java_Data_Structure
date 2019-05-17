package u2.exp;

public class SinglyList<T> {
	public Node<T> head;

	public SinglyList() {
		this.head = new Node<T>();
	}
	public SinglyList(T[] values) {
		this();
		Node<T> rear = this.head;
		for (int i = 0; i < values.length; i++) {
			rear.next = new Node<T>(values[i], null);
			rear = rear.next;
		}
	}
	public SinglyList(SinglyList<T> list) {
		this();
		Node<T> p = this.head;
		Node<T> q = list.head;
		while (q.next != null) {
			p.next = new Node<T>(q.next.data, null);
			p = p.next;
			q = q.next;
		}
	}
	public String toString() {
		String str = this.getClass().getSimpleName() + "(";
		for (Node<T> p = this.head.next; p != null; p = p.next) {
			str += p.data.toString();
			if (p.next != null) {
				str += ",";
			}
		}
		return str += ")";
	}

	public T remove(T key) {
		if (key == null)
			throw new NullPointerException();
		Node<T> front = this.head;
		Node<T> p = front.next;
		while (p != null) {
			if (p.data.equals(key)) {
				front.next = p.next;
				return p.data;
			}
			front = front.next;
			p = front.next;
		}
		return null;
	}

	public boolean contains(T key) {
		Node<T> p = this.head.next;
		while (p!= null) {
			if (p.data.equals(key)) {
				return true;
			}
			p = p.next;
		}
		return false;
	}

	public Node<T> insert(int i, T x) throws Exception {
		if (x == null)
			throw new NullPointerException();
		Node<T> front = this.head;
		for (int j = 0; front.next != null && j < i; j++)
			front = front.next;
		front.next = new Node<T>(x, front.next);
		return front.next;
	}

	public Node<T> insert(T x) throws Exception {
		return this.insert(Integer.MAX_VALUE, x);
	}

	/*
	 * 2-8
	 */
	public SinglyList<T> differenceVer1(SinglyList<T> list) {
		SinglyList<T> result = new SinglyList<T>(this);
		Node<T> p = new Node<T>();
		for (p = list.head.next; p != null; p = p.next) {
			result.remove(p.data);
		}
		return result;
	}

	public SinglyList<T> differenceVer2(SinglyList<T> list) throws Exception {
		SinglyList<T> result = new SinglyList<T>();
		for(Node<T> p = this.head.next;p!=null;p = p.next) {
			if(!list.contains(p.data)) {
				result.insert(p.data);
			}
		}
		return result;
	}

}
