package top.neusoftware.learn;

public class QueueNode<T> {
	private T data;	//数据域
	private QueueNode<T> next;	//指针域
	public QueueNode() {	//保留不带参数的构造方法
		
	}
	public QueueNode(T data) {
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
	public QueueNode<T> getNext() {
		return next;
	}
	public void setNext(QueueNode<T> next) {
		this.next = next;
	}
	
}
