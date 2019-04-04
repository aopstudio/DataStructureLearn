package top.neusoftware.learn;

public class QueueNode {
	private String data;	//数据域
	private QueueNode next;	//指针域
	public QueueNode() {
		super();
	}
	public QueueNode(String data, QueueNode next) {
		super();
		this.data = data;
		this.next = next;
	}
	public QueueNode(String data) {
		super();
		this.data = data;
		this.next = null;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public QueueNode getNext() {
		return next;
	}
	public void setNext(QueueNode next) {
		this.next = next;
	}
	
}
