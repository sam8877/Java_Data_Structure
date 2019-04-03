package u2;

public class Josephus {
	
	public Josephus(int number, int start, int distance) {
		System.out.println("Josephus[" + number + "," + start + "," + distance + "]");
		SeqList<String> list = new SeqList<String>(number);
		for (int i=0; i<number; i++)
			list.insert((char)('A'+i)+"");
		System.out.println(list);
		int i = start;
		while(list.size()>1) {
			i = (i+distance-1)%list.size();
			System.out.print("delete " + list.remove(i).toString()+", ");
			System.out.println(list.toString());
		}
		System.out.println("被赦免的是:" + list.get(0));
	}
	
	public static void main(String[] args) {
		new Josephus(9, 6, 3);
	}
}
