package u2_linear_table.singaly;

public class SortedSignalyList<T extends Comparable<? super T>> extends SinglyList<T>{
	
	//默认无参构造方法,创建一个空链表
	public SortedSignalyList() {
		super();
	}
	//对values进行排序
	public SortedSignalyList(T[] values){
		super();//父类方法，构造空链表
		for(int i=0; i<values.length;i++) {
			this.insert(values[i]);
		}
	}
	//拷贝构造方法(已经排好序)
	public SortedSignalyList(SortedSignalyList<T> list) {
		super(list);//父辈拷贝构造函数
	}
	//排序
	public SortedSignalyList(SinglyList<T> list) {
		super();//调用父类构造方法
		Node<T> p = list.head.next;
		while(p!=null) {
			this.insert(p.data);
			p = p.next;
		}
	}
	
	@Override
	public void set(int i, T x) throws Exception{
		throw new Exception("该方法不能使用。。。");
	}
	
	public Node<T> insert(int i, T x) throws Exception{
		throw new Exception("该方法不能使用。。。");
	}
	//值插入
	public Node<T> insert(T x){
		if(x==null)
			throw new NullPointerException();
		Node<T> front =this.head;
		Node<T> p = front.next;
		while(p!=null && x.compareTo(p.data)>0) {
			front = p;
			p = p.next;
		}
		front.next = new Node<T>(x,p);
		return front.next;
	}
	
	public Node<T> search(T key) {
		if(key == null)
			throw new NullPointerException();
		Node<T> p = this.head.next;
		while(p!=null) {
			if(p.data.equals(key)) {
				return p;
			}
			p = p.next;
		}
		return null;
	}
	
	public Node<T> insertDifferent(T x){
		if (x == null)
			throw new NullPointerException();
		Node<T> front =this.head;
		Node<T> p = front.next;
		while(p!=null && x.compareTo(p.data)>0) {
			front = p;
			p = p.next;
		}
		front.next = new Node<T>(x,p);
		return front.next;
	}
	
	//插入排序
	public void addAll(SinglyList<T> list) {
		Node<T> p = list.head.next;
		while(p!=null) {
			this.insert(p.data);
			p = p.next;
		}
	}
	
	
}