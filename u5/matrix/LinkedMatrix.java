package u5.matrix;

import u2.SeqList;
import u2.singaly.SortedSignalyList;

public class LinkedMatrix {
	private int rows,columns;
	private SeqList<SortedSignalyList<Triple>> rowlist;
	
	public LinkedMatrix(int m,int n) {
		if(m>0&&n>0) {
			this.rows = m;
			this.columns = n;
			this.rowlist = new SeqList<SortedSignalyList<Triple>>(m);
			for(int i = 0;i<m;i++)
				rowlist.insert(new SortedSignalyList<Triple>());
		}else {
			throw new IllegalArgumentException();
		}
		
	}
	public LinkedMatrix(int m) {
		this(m,m);
	}
	public LinkedMatrix(int m,int n,Triple[] triples) {
		this(m,n);
		for(int i=0;i<triples.length;i++) {
			this.set(triples[i]);
		}
	}
	
	public int getRows() {
		return this.rows;
	}
	public int getColums() {
		return this.columns;
	}

	public void set(int i,int j,int x) {
		if(i>0&&i<rows&&j>0&&j<columns) {
			
		}
	}
	public void set(Triple triple) {
		
	}
	public int get(int i,int j) {
		return 0;
	}
	
	public String toString() {
		return "";
	}
	public void printMatrix() {
		
	}
	
	public void setRowsColumns(int m,int n) {
		
	}
	public void addAll(LinkedMatrix matrix) {
		
	}
}
