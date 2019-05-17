package u7;

import u2.SeqList;

public abstract class AbstarctGraph<T> {
	protected static final int MAX_WEIGHT=0x0000ffff;
	protected SeqList<T> vertexlist;
	
	public AbstarctGraph(int length) {
		this.vertexlist = new SeqList<T>(length);
	}
	public AbstarctGraph() {
		this(10);
	}
	
	public int vertexCount() {
		return this.vertexlist.size();
	}
	
	public String toString() {
		return "point:"+this.vertexlist.toString();
	}
	
	public T getVertex(int i) {
		return this.vertexlist.get(i);
	}
	
	public void setVertex(int i, T x) {
		this.vertexlist.set(i, x);
	}
	
	public abstract int insertVertex(T x);
	public abstract void removeVertex(int i);	//删除第i个节点及边
	public abstract int weight(int i,int j);
	public abstract int next(int i,int j);
	
	
	
}
