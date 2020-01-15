package top.neusoftware.learn.datastructure;

public class LinkStack<T> {	//带头结点的链式栈
	private LinkNode<T> hNode;	//头结点
	public LinkStack() {
		hNode=new LinkNode<>();
	}
	public void push(T data) {
		LinkNode<T> node=new LinkNode<T>(data);
		node.setNext(hNode.getNext());
		hNode.setNext(node);
	}
	public boolean isEmpty() {
		if(hNode.getNext()==null) {
			return true;
		}
		else {
			return false;
		}
	}
	public T pop() {
		if(!isEmpty()) {
			LinkNode<T> node=hNode.getNext();
			hNode.setNext(node.getNext());
			return node.getData();
		}
		else {
			return null;
		}
	}
}
