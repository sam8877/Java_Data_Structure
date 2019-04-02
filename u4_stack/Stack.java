package u4_stack;

public interface Stack<T> {
	public boolean isEmpty();
	public void push(T x);//入栈
	public T peek();	//返回栈顶元素
	public T pop();		//出栈，返回栈顶元素
}
