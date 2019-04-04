package top.neusoftware.learn;

public class BinaryTree {
	private BiTNode root;
	public BinaryTree() {
		BiTNode six=new BiTNode("6");
		BiTNode four=new BiTNode("4",six,null);
		BiTNode two=new BiTNode("2",null,four);
		BiTNode five=new BiTNode("5");
		BiTNode three=new BiTNode("3",null,five);
		BiTNode first=new BiTNode("1",two,three);
		this.root=first;
	}
	public void preOrder(BiTNode node) {	//先序遍历
		if(node!=null) {
			System.out.print(node.getData()+"\t");
			preOrder(node.getLchild());
			preOrder(node.getRchild());
		}
	}
	public void preOrder() {
		preOrder(root);
	}
	public void inOrder(BiTNode node) {		//中序遍历
		if(node!=null) {
			inOrder(node.getLchild());
			System.out.print(node.getData()+"\t");
			inOrder(node.getRchild());
		}
	}
	public void inOrder() {
		inOrder(root);
	}
	public void postOrder(BiTNode node) {		//后序遍历
		if(node!=null) {
			postOrder(node.getLchild());
			postOrder(node.getRchild());
			System.out.print(node.getData()+"\t");
		}
	}
	public void postOrder() {
		postOrder(root);
	}
	public void levelTraversal() {
		Queue treeQueue=new Queue();
		
	}
}
