package u2.singaly;

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

	public boolean isEmpty() {
		return this.head.next == null;
	}

	public T get(int i) {
		Node<T> p = this.head.next;
		for (int j = 0; j < i && p != null; j++) {
			p = p.next;
		}
		return (i >= 0 && p != null) ? p.data : null;
	}

	public void set(int i, T x) throws Exception {
		if (i < 0 || i > this.size())
			throw new IndexOutOfBoundsException("数组下标越界。。");
		Node<T> p = this.head.next;
		for (int j = 0; j < i && p != null; j++)
			p = p.next;
		p.data = x;
	}

	public int size() {
		Node<T> p = this.head.next;
		int i = 0;
		for (; p.next != null; i++, p = p.next)
			;
		return i;
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

	public T remove(int i) {
		Node<T> front = this.head;
		for (int j = 0; front.next != null && j < i; j++)
			front = front.next;
		if (i >= 0 && front.next != null) {
			T old = front.next.data;
			front.next = front.next.next;
			return old;
		}
		return null;
	}

	public Node<T> search(T key) {
		Node<T> p = this.head.next;
		while (p.next != null)
			if (p.data.equals(key))
				return p;
		return null;
	}

	public Node<T> search(SinglyList<T> pattern) {
		if (pattern == null)
			throw new IllegalArgumentException("匹配串不能为null");
		Node<T> p = this.head.next;
		Node<T> q = pattern.head.next;
		Node<T> tmp = null;
		for (; p != null; p = p.next) {
			tmp = p;
			while (tmp != null && q != null) {
				System.out.println("p:" + p + ",q:" + q + ",tmp:" + tmp);
				if (tmp.data.equals(q.data)) {
					tmp = tmp.next;
					q = q.next;
				} else {
					q = pattern.head.next;
					break;
				}
			}
			if (q == null)
				return p;
		}
		return p;
	}

	public boolean contains(T key) {
		Node<T> p = this.head.next;
		while (p != null) {
			if (p.data.equals(key)) {
				return true;
			}
			p = p.next;
		}
		return false;
	}

	public Node<T> insertDifferent(T x) {
		// x 涓簄ull鏃舵姏鍑虹┖鎸囬拡寮傚父
		if (x == null)
			throw new NullPointerException();
		Node<T> p = this.head;
		// 閬嶅巻閾捐〃锛屽鏋滄湁鍏冪礌鍜寈鐩哥瓑锛屽垯杩斿洖null,濡傛灉娌℃湁锛宲鍒欐寚鍚戞渶鍚庝竴涓妭鐐�
		while (p.next != null) {
			if (x.equals(p.next.data))
				return null;
			p = p.next;
		}
		// 鍦╬涔嬪悗鎻掑叆x鍊肩殑鑺傜偣
		p.next = new Node<T>(x, p.next);
		return p;
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

	public SinglyList<T> reverse() {
		// 鍙湁涓�涓垨娌℃湁鑺傜偣鏃剁洿鎺ヨ繑鍥�
		if (this.head.next == null || this.head.next.next == null) {
			return this;
		}

		Node<T> front = this.head.next;
		Node<T> p = front.next;
		Node<T> succ = p.next;

		while (front != null && p != null && succ != null) {
			// System.out.println(front + ">" + p + ">" + succ);
			// 灏唒鎸囧悜鍓嶄竴涓粨鐐�,骞舵柇寮�鍚庝竴涓妭鐐�
			p.next = front;
			// 鍚戝悗閬嶅巻
			front = p;
			p = succ;
			succ = succ.next;
		}
		p.next = front;
		head.next.next = null;
		head.next = p;
		return this;
	}

	public SinglyList(SinglyList<T> list) {
		Node<T> p = this.head = new Node<T>();
		Node<T> q = list.head;
		while (q.next != null) {
			p.next = new Node<T>(q.next.data, p.next);
			p = p.next;
			q = q.next;
		}
	}

	public void addAll(SinglyList<T> list) {
		// 灏唒鎷ㄥ埌鏈�鍚庝竴涓妭鐐�
		Node<T> p = this.head;
		while (p.next != null)
			p = p.next;
		Node<T> q = list.head;
		while (q.next != null) {
			p.next = new Node<T>(q.next.data, p.next);
			q = q.next;
		}
	}

	public SinglyList<T> difference(SinglyList<T> list) {
		SinglyList<T> result = new SinglyList<T>(this);
		System.out.println("---" + result);
		Node<T> p = new Node<T>();
		for (p = list.head.next; p != null; p = p.next) {
			result.remove(p.data);
		}
		return result;

	}

}
