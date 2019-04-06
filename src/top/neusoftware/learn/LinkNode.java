package top.neusoftware.learn;

public class LinkNode<T> {
	private T data;	//数据域
	private LinkNode<T> next;	//指针域
	public LinkNode() {	//保留不带参数的构造方法
		
	}
	public LinkNode(T data) {
		super();
		this.data = data;
		this.next = null;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public LinkNode<T> getNext() {
		return next;
	}
	public void setNext(LinkNode<T> next) {
		this.next = next;
	}
	
}
