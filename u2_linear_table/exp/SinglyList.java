package u2_linear_table.exp;

public class SinglyList<T> {
	public Node<T> head;
	
	public SinglyList(){
		this.head = new Node<T>();
	}
	
	public SinglyList(T[] values){
		this();
		Node<T> rear = this.head;
		for(int i=0; i<values.length;i++){
			rear.next = new Node<T>(values[i],null);
			rear = rear.next;
		}
	}
	
	public SinglyList(SinglyList<T> list){
		this();
		Node<T> p = this.head;
		Node<T> q = list.head;
		while(q.next!=null) {
			p.next = new Node<T>(q.next.data, null);
			p = p.next;
			q = q.next;
		}
	}

	public String toString(){
		String str = this.getClass().getSimpleName()+"(";
		for(Node<T> p=this.head.next;p!=null;p=p.next){
			str += p.data.toString();
			if(p.next!=null){
				str += ",";
			}
		}
		return str+=")";
	}

	
	public T remove(T key){
		if(key==null)
			throw new NullPointerException();
		Node<T> front = this.head;
		Node<T> p = front.next;
		while(p!=null) {
			if(p.data.equals(key)) {
				front.next = p.next;
				return p.data;
			}
			front = front.next;
			p = front.next;
		}
		return null;
	}
	

	


	public SinglyList<T> difference(SinglyList<T> list) {
		SinglyList<T> result = new SinglyList<T>(this);
		Node<T> p = new Node<T>();
		for(p = list.head.next; p!=null; p = p.next) {
			result.remove(p.data);
		}
		return result;
		
		
	}
	
	
}
