package u4.stack;

import u2.singaly.SinglyList;

public final class LinkedStack<T> implements Stack<T>{
	private SinglyList<T> list;
	
	public LinkedStack() {
		this.list = new SinglyList<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	@Override
	public void push(T x){
		try {
			this.list.insert(0, x);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public T peek() {
		return this.list.get(0);
	}

	@Override
	public T pop() {
		return this.list.remove(0);
	}
	
}
