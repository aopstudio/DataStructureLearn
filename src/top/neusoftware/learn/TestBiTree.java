package top.neusoftware.learn;

public class TestBiTree {
	public static void main(String[] args) {
		BinaryTree tree=new BinaryTree();
		tree.preOrder();
		System.out.println();
		tree.inOrder();
		System.out.println();
		tree.postOrder();
		System.out.println();
		tree.levelTraversal();
	}
}
