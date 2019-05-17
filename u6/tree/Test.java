package u6.tree;

public class Test {
	public static void main(String[] args) {
		Tree<String> tree = new Tree<String>();
		TreeNode<String> node1 = new TreeNode<String>("a", 0);
		TreeNode<String> node2 = new TreeNode<String>("b", 0);
		TreeNode<String> node3 = new TreeNode<String>("c", 0);
		TreeNode<String> node4 = new TreeNode<String>("d", 0);
		tree.root.child = node1;
		tree.root.child.sibling = node2;
		tree.root.child.child = node3;
		tree.root.child.child.sibling = node4;
		tree.printGenList();
	}
}
