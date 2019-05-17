package u5.matrix;

public class Matrix {
	private int rows, columns;
	private int[][] element;

	public Matrix(int m, int n) {
		this.rows = m;
		this.columns = n;
		this.element = new int[m][n];
	}

	public Matrix(int n) {
		this(n, n);
	}

	public Matrix(int m, int n, int[][] values) {
		this(m, n);
		for (int i = 0; i < values.length && i < m; i++) {
			for (int j = 0; j < values[i].length && j < n; j++) {
				this.element[i][j] = values[i][j];
			}
		}
	}

	public Matrix(Matrix matrix) {
		if (matrix == null)
			throw new NullPointerException();
		this.rows = matrix.rows;
		this.columns = matrix.columns;
		this.element = new int[rows][columns];
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++)
				this.element[i][j] = matrix.get(i, j);

	}

	public int getRows() {
		return this.rows;
	}

	public int getColums() {
		return this.columns;
	}

	public int get(int i, int j) {
		if (i > 0 && j > 0 && i < this.rows && j < this.columns)
			return element[i][j];
		throw new IndexOutOfBoundsException();
	}

	public int set(int i, int j, int x) {
		if (i > 0 && j > 0 && i < this.rows && j < this.columns)
			element[i][j] = x;
		throw new IndexOutOfBoundsException();
	}

	@Override
	public String toString() {
		String str = this.getClass().getSimpleName() + "[" + rows + ", " + columns + "] \n";
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.columns; j++) {
				str += String.format("%4d", this.element[i][j]);
			}
			str += "\n";
		}
		return str;
	}

	public void setRowsColumns(int m, int n) {
		if (m > 0 && n > 0) {
			if (m > this.element.length || n > this.element[0].length) {
				int[][] source = this.element;
				this.element = new int[m][n];
				for (int i = 0; i < this.rows; i++)
					for (int j = 0; j < this.columns; j++)
						this.element[i][j] = source[i][j];
			}
			this.rows = m;
			this.columns = n;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void removeRow(int i) {
		if (i < 0 || i > rows - 1)
			throw new IllegalArgumentException();
		for (int j = i; j < rows - 1; j++) {
			this.element[j] = this.element[j + 1];
		}
		rows--;
	}

	public void removeColumns(int i) {
		if (i < 0 || i > columns - 1)
			throw new IllegalArgumentException();
		for (int j = 0; j < rows; j++) {
			for (int k = i; k < columns - 1; k++) {
				element[j][k] = element[j][k + 1];
			}
		}
		columns--;

	}
}
