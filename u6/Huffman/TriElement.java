package u6.Huffman;

public class TriElement {
	int data;
	int parent,left,right;
	public TriElement(int data, int parent, int left, int right) {
		this.data = data;
		this.parent = parent;
		this.left = left;
		this.right = right;
	}
	
	public TriElement(int data) {
		this(data, -1, -1, -1);
	}

	@Override
	public String toString() {
		return "TriElement [data=" + data + ", parent=" + parent + ", left=" + left + ", right=" + right + "]";
	}
	
	public boolean isLeaf() {
		return this.left==-1&&this.right==-1;
	}
}
