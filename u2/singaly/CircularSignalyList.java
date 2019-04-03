package u2.singaly;

/*
 * -循环单链表
 */
public class CircularSignalyList<T> extends SinglyList<T>{
	
	public Node<T> head;
	
	public CircularSignalyList() {
		this.head = new Node<T>();
		head.next = head;
		//this.head = new Node<T>(null,head); ?????
	}
	
	
	public static void main(String[] args) throws Exception {
		CircularSignalyList<Integer> circularSignalyList = new CircularSignalyList<Integer>();
		circularSignalyList.insert(4);
		circularSignalyList.insert(5);
		System.out.println(circularSignalyList);
	}
	
}
