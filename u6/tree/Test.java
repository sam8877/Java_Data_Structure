package u6.tree;

public class Test {
	public static void main(String[] args) throws Exception {
		Tree<String> tree = new Tree<String>("root");
		TreeNode<String> a = new TreeNode<String>("a");
		TreeNode<String> b = new TreeNode<String>("b");
		TreeNode<String> c = new TreeNode<String>("c");
		TreeNode<String> d = new TreeNode<String>("d");
		tree.root.child = a;
		a.sibling = b;
		a.child = c;
		tree.root.sibling = d;
		b.parent=tree.root;
		a.parent=tree.root;
		c.parent = a;
		d.parent = null;
		tree.printGenList();
		//System.out.println(tree.toStringWithParent(tree.root));
		
		
	}
}
