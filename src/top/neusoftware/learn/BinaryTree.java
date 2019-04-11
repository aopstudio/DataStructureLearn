package top.neusoftware.learn;

public class BinaryTree<T> {
	protected BiTNode<T> root;
	public void preOrder(BiTNode<T> node) {	//先序遍历
		if(node!=null) {
			System.out.print(node.getData()+"\t");
			preOrder(node.getLchild());
			preOrder(node.getRchild());
		}
	}
	public void preOrder() {
		preOrder(root);
	}
	public void inOrder(BiTNode<T> node) {		//中序遍历
		if(node!=null) {
			inOrder(node.getLchild());
			System.out.print(node.getData()+"\t");
			inOrder(node.getRchild());
		}
	}
	public void inOrder() {
		inOrder(root);
	}
	public void postOrder(BiTNode<T> node) {		//后序遍历
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
		LinkQueue<BiTNode<T>> treeQueue=new LinkQueue<BiTNode<T>>();
		treeQueue.enQueue(root);
		while(!treeQueue.isEmpty()) {	//队列不空循环
			BiTNode<T> node=treeQueue.deQueue();
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
