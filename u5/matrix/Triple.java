package u5.matrix;

public class Triple {
	public int row,column,value;
	
	public Triple(int row, int column, int value) {
		if(row>=0&&column>=0) {
			this.row = row;
			this.column = column;
			this.value = value;
		}else {
			throw new IllegalArgumentException();
		}
	}
	public Triple(Triple triple) {
		this(triple.row, triple.column, triple.value);
	}
	
	public String toString() {
		return "(" + this.row + "," + this.column + "," + this.value + ")";
	}
	
	public int compareTo(Triple triple) {
		if(this.column==triple.column&&this.row==triple.row)
			return 0;
		return (this.row<triple.row||this.row==triple.row&&this.column<triple.column)?-1:1;
	}
	
	public boolean equals() {
		return false;
	}
	
	public void add(Triple triple) {
		
	}
	
	public boolean removable() {
		return this.value == 0;
	}
	
	public Triple toSymmetry() {
		return new Triple(this.column, this.row, this.value);
	}
}
