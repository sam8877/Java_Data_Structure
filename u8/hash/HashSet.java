package u8.hash;

import u2.singaly.Node;
import u2.singaly.SinglyList;

public class HashSet<T> {
	private SinglyList[] table;
	private int count = 0;
	private static final float LOAD_FACTOR = 0.75f;
	
	public HashSet(int length) {
		if (length<10) length = 10;
		this.table = new SinglyList[length];
		for(int i=0; i<this.table.length; i++) {
			this.table[i] = new SinglyList<T>();
		}
	}
	public HashSet() {
		this(16);
	}
	public HashSet(T[] values) {
		
	}
	
	private int hash(T x) {
		int key = Math.abs(x.hashCode());
		return key%this.table.length;
	}
	
	public T search(T key) {
		Node<T> find = this.table[this.hash(key)].search(key);
		return find==null?null:find.data;
	}
}
