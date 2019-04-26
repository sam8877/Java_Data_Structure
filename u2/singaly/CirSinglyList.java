package u2.singaly;

public class CirSinglyList<T> extends SinglyList<T>{
	
	public Node<T> head;
	
	public CirSinglyList(){
	    this.head = new Node<T>();
	    head.next=head;
	}
	
	public CirSinglyList(T[] values){
		this();
		Node<T> rear = this.head;
		for(int i = 0; i<values.length;i++) {
			rear.next = new Node<T>(values[i], rear.next);
			rear = rear.next;
		}
	}
	
	public SinglyList<T> sublist(int i, int n){
		SinglyList<T> res = new SinglyList<T>();
		if(i<0||n<0) return res;
		Node<T> rear = this.head.next;
		
		for(int j=0;j<i&&rear!=head;j++)
			rear = rear.next;//将rear拨到第i个元素或者尾部
		
		Node<T> res_rear = res.head;
		for(int k=0;k<n&&rear!=head;k++) {
			res_rear.next = new Node<T>(rear.data, null);
			rear = rear.next;
			res_rear = res_rear.next;
		}
		
		return res;
		
	}
	
	
	public static void main(String[] args) throws Exception {
//		CirSinglyList<Integer> circularSignalyList = new CirSinglyList<Integer>();
//		circularSignalyList.insert(4);
//		circularSignalyList.insert(5);
//		System.out.println(circularSignalyList);
		
		Integer[] values = {0,1,2,3,4,5,6,7,8,9};
 		CirSinglyList<Integer> list = new CirSinglyList<Integer>(values);
// 		for(Node<Integer> node = list.head.next;node!=list.head;node=node.next) {
// 			System.out.println(node.data);
// 		}
 		
 		SinglyList<Integer> list1 = list.sublist(100,11);
 		System.out.println(list1);
		
	}
	
}
