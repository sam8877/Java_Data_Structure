package u2.doubly;

public class DoublyList<T> {
	public DoubleNode<T> head;
	
	public DoublyList(){
		this.head = new DoubleNode<T>();
	}
	public DoublyList(T[] values){
		this();
		DoubleNode<T> rear = this.head;
		for(int i = 0; i < values.length; i++){
			DoubleNode<T> temp = new DoubleNode<T>(values[i], rear, null);
			rear.next = temp;
			rear = rear.next;
		}
	}
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
		DoubleNode<T> rear = this.head.next;
		
		for(int t=0; t<i&&rear!=null; t++){
			rear = rear.next;
		}
		return (i>=0&&rear!=null)?rear.data:null;
	}
	
	public void set(int i, T x) {
		if (i<0||i>this.size())
			throw new IndexOutOfBoundsException("鏁扮粍涓嬫爣瓒婄晫銆傘��");
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
	
	public DoublyList<T> intersection(DoublyList<T> list){
		DoubleNode<T> p=null,q=null;
		DoublyList<T> result = new DoublyList<T>();
		DoubleNode<T> rear = result.head;
		
		for(p = this.head.next;p!=null;p=p.next) {
			for(q = list.head.next;q!=null;q=q.next) {
				System.out.println("p:" + p.data + ", q:" + q.data);
				if(p.data.equals(q.data)) {
					rear.next = new DoubleNode<T>(p.data,rear,null);
					rear = rear.next;
					break;
				}
			}
		}
		return result;
	}
}
