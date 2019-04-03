package u4.queue;

public interface Queue<T> {
	public boolean isEmpty();
	public boolean add(T x);
	public T peek();
	public T poll();
}
