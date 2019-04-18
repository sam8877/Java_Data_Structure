package u5.genlist;

public class GenList<T> {
	public GenNode<T> head;
	
	public GenList() {
		this.head = new GenNode<T>();
	}
	
	public String toString() {
		return this.toString("");
	}	
	public String toString(String str) {
		str += "(";
		for(GenNode<T> p = this.head.next; p!=null; p=p.next) {
			if(p.child==null) {
				str += p.data.toString();
			}else {
				str += p.child.toString();
			}
			if(p.next!=null)
				str += ",";
		}
		str += ")";
		return str;
	}
	
	//返回深度
	public int depth() {
		GenNode<T> p = this.head.next;
		int max=0,i=0;
		while(p!=null) {		//对每一个元素进行操作
			if(p.child!=null) {	//如果有子表
				i = p.child.depth()+1;
			}else{				//如果为原子节点
				i = 1;
			}
			max = max>i?max:i;
			p = p.next;
		}
		return max;
	}
	
	public GenList(T[] atoms) {
		this();
		GenNode<T> p = this.head;
		for(T atom: atoms) {
			p.next = new GenNode<T>(atom, null, p.next);//尾插入
			p = p.next;
		}
	}
	
	public boolean isEmpty() {
		return this.head.child==null&&this.head.next==null;
	}
	
	//返回长度
	public int size() {
		int i = 0;
		GenNode<T> p = this.head.next;
		while(p!=null) {
			i++;
			p = p.next;
		}
		return i;
	}
	
	//插入原子 X 作为第i个元素，对i容错
	public GenNode<T> insert(int i, T x){
		if(i<0)	i=0;
		GenNode<T> p = this.head;			//指向头节点
		for(int k=0;k<i&&p.next!=null;k++)//将指针拨到尾部
			p = p.next;
		p.next = new GenNode<T>(x, null, p.next);
		return p;
	}
	public GenNode<T> insert(T x){
		this.insert(Integer.MAX_VALUE, x);
		return null;
	}
	//插入子表作为第i个元素,对i容错
	public GenNode<T> insert(int i, GenList<T> genList){
		if(i<0)	i=0;
		GenNode<T> p = this.head;			//指向头节点
		for(int k=0;k<i&&p.next!=null;k++)//将指针拨到插入点
			p = p.next;
		p.next = new GenNode<T>(null, genList, p.next);
		return p;
	}
	public GenNode<T> insert(GenList<T> genList){
		return this.insert(Integer.MAX_VALUE, genList);
	}
	
	public void remove(int i) {
		if(i<0)	i=0;
		if(this.isEmpty()) return;
		GenNode<T> fro = this.head;
		GenNode<T> p = fro.next;
		for(int k=0;k<i&&p.next!=null;k++) {
			fro = p;
			p = p.next;
		}
		if(p.next!=null)
			fro.next = fro.next.next;//删除fro后的一个节点
		else
			fro.next = null;		//删除最后一个节点
	}
}
