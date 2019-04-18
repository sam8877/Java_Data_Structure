package u6.Huffman;

public class HuffmanTree {
	private String charset;
	private TriElement[] huftree;
	
	public HuffmanTree(int[] weights) {
		this.charset="";
		for(int i=0;i<weights.length;i++)
			this.charset+=(char)('A'+i);
		int n = weights.length;
		this.huftree = new TriElement[2*n-1];
		
	}
	
	
}