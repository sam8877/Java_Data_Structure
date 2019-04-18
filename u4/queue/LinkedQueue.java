package u4.queue;

import u2.singaly.Node;

public class LinkedQueue<T> implements Queue<T>{
	public Node<T> front,rear;
	
	public LinkedQueue() {
		this.rear = this.front = null;
	}

	@Override
	public boolean isEmpty() {
		return front==null&&rear==null;
	}

	@Override
	public boolean add(T x) {
		
		if(x==null) return false;
		Node<T> p = new Node<T>(x, null);
		
		if (this.isEmpty()) {
			this.front = p;
		}else {
			this.rear.next=p;
		}
		this.rear=p;
		return true;
	}

	@Override
	public T peek() {
		return this.isEmpty()?null:this.front.data;
	}

	@Override
	public T poll() {
		if (this.isEmpty()) return null;
		T x = this.front.data;
		this.front = this.front.next;
		if (this.front==null) this.rear=null;
		return x;
	}
	
}
