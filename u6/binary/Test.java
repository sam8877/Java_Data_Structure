package u6.binary;

public class Test {
	
	public static void main(String[] args) {
		BinaryTree<String> tree = new BinaryTree<String>();
		tree.preorder();
		System.out.println("is empty: " + tree.isEmpty());
		
		tree.insert("root");
		tree.preorder();
		System.out.println("is empty: " + tree.isEmpty());
		
		tree.insert(tree.root,"left",true);
		tree.insert(tree.root,"right",false);
		System.out.println("------------insert--------");
		tree.preorder();
		System.out.println("is empty: " + tree.isEmpty());
	}
	
}
