package u6.binary;

public class Test {
	
	public static void main(String[] args) {
		BinaryTree<String> tree = new BinaryTree<String>();
		System.out.println("------------insert--------");
		tree.insert("A");
		tree.insert(tree.root,"B",true);
		tree.insert(tree.root,"C",false);
		//tree.insert(tree.root.left,"D",true);
		//tree.insert(tree.root.left,"E",false);
		tree.preorder();
		
		System.out.println("\nhight: "+tree.height(tree.root));
		System.out.println("size : "+tree.size(tree.root));
		
		tree.printGenlist();
	}
	
}
