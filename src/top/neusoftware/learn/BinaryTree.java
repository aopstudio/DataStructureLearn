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
	public void levelTraversal() {	//层次遍历
		LinkQueue<BiTNode> treeQueue=new LinkQueue<BiTNode>();
		treeQueue.enQueue(root);
		while(!treeQueue.isEmpty()) {	//队列不空循环
			BiTNode node=treeQueue.deQueue();
			System.out.print(node.getData()+"\t");
			if(node.getLchild()!=null) {	//左子结点不空就入队
				treeQueue.enQueue(node.getLchild());
			}
			if(node.getRchild()!=null) {	//右子结点不空就入队
				treeQueue.enQueue(node.getRchild());
			}
		}
	}
}
