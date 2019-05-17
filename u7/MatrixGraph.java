package u7;

import u5.matrix.Matrix;
import u5.matrix.Triple;

public class MatrixGraph<T> extends AbstarctGraph<T>{
	protected Matrix matrix;
	
	public MatrixGraph(int length) {
		super(length);
		this.matrix = new Matrix(length);
	}
	public MatrixGraph(){
		this(10);
	}
	public MatrixGraph(T[] vertices) {
		this(vertices.length);
		for (int i = 0; i < vertices.length; i++) {
			this.insertVertex(vertices[i]);
		}
	}
	public MatrixGraph(T[] vertices, Triple[] edges) {
		this(vertices);
		for (int i = 0; i < edges.length; i++) {
			this.insertEdge(edges[i]);
		}
	}
	
	public void insertEdge(int i, int j,int weight) {
		if(i!=j) {
			if(weight<0||weight>MAX_WEIGHT)
				weight=MAX_WEIGHT;
			this.matrix.set(i,j,weight);
		}
	}
	public void insertEdge(Triple triple) {
		this.insertEdge(triple.row, triple.column, triple.value);
	}
	public void removeEdge(int i,int j) {
		if(i!=j) {
			this.matrix.set(i, j, MAX_WEIGHT);
		}
	}
	public void removeEdge(Triple triple) {
		this.removeEdge(triple.row, triple.column);
	}
	
	@Override
	public int insertVertex(T x) {
		int i = this.vertexlist.insert(x);
		if(i>=this.matrix.getRows())
			this.matrix.setRowsColumns(i+1, i+1);
		for(int j=0;j<i;j++) {
			this.matrix.set(i, j, MAX_WEIGHT);
			this.matrix.set(j, i, MAX_WEIGHT);
		}
		return i;
	}
	@Override
	public void removeVertex(int i) {
		vertexlist.remove(i);
		matrix.removeRow(i);
		matrix.removeColumns(i);
	}
	@Override
	public int weight(int i, int j) {
		return this.matrix.get(i, j);
	}
	@Override
	public int next(int i, int j) {
		int n = this.vertexCount();
		if(i>=0&&i<n&&j>=-1&&j<n&&i!=j) {
			for (int k = j+1; k < n; k++) {
				if(this.matrix.get(i, k)>0&&this.matrix.get(i, k)<MAX_WEIGHT)
					return k;
			}
		}
		return -1;
	}
	
	
}
