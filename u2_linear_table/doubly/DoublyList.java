package u2_linear_table.doubly;

public class DoublyList<T> {
	public DoubleNode<T> head;
	
	//默认构造方法，空链表
	public DoublyList(){
		this.head = new DoubleNode<T>();
	}
	//从数组构造双链表
	public DoublyList(T[] values){
		this();
		DoubleNode<T> rear = this.head;
		for(int i = 0; i < values.length; i++){
			DoubleNode<T> temp = new DoubleNode<T>(values[i], rear, null);
			rear.next = temp;
			rear = rear.next;
		}
	}
	//深拷贝构造方法
	public DoublyList(DoublyList<T> list) {
		this();
		DoubleNode<T> rear = this.head;
		for(DoubleNode<T> p = list.head; p != null; p = p.next){
			DoubleNode<T> temp = new DoubleNode<T>(p.next.data, rear, null);
			rear.next = temp;
			rear = rear.next;
		}
		
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public int size() {
		int size = 0;
		for(DoubleNode<T> p = this.head.next; p != null; p = p.next)
			size++;
		return size;
	}
	
	public T get(int i) {
		//指向第一个节点（不是头节点）
		DoubleNode<T> rear = this.head.next;
		
		//将rear指向要找的节点或最后一和节点
		for(int t=0; t<i&&rear!=null; t++){
			rear = rear.next;
		}
		return (i>=0&&rear!=null)?rear.data:null;
	}
	
	public void set(int i, T x) {
		if (i<0||i>this.size())
			throw new IndexOutOfBoundsException("数组下标越界。。");
		DoubleNode<T> p = this.head.next;
		for(int j=0; j<i && p!=null; j++)
			p = p.next;
		p.data = x;
	}
	
	public String toString() {
		String str = this.getClass().getSimpleName()+"(";
		for(DoubleNode<T> p = this.head.next; p != null; p = p.next){
			str += p.data.toString();
			if(p.next != null){
				str += ",";
			}
		}
		return str+=")";
	}
	
	public DoubleNode<T> insert(int i, T x){
		return null;
	}
	public DoubleNode<T> insert(T x){
		return null;
	}
	public DoubleNode<T> insertDifferent(T x){
		return null;
	}
	
	public T remove(T key) {
		return null;
	}
	
	public boolean equals(Object object) {
		return false;
	}
	
	public void addAll(DoublyList<T> list) {
		
	}
	
}
