package top.neusoftware.learn.datastructure;

public class Queue {	//循环队列，牺牲一个存储单元来判断队满和队空，rear指向队尾元素后面那个下标
	private String[] list;
	private int front, rear;	//队首、队尾
	private final int SIZE;
	public Queue(int size) {
		list=new String[size];
		SIZE=size;
		front=rear=0;
	}
	public boolean isEmpty() {
		if (front==rear) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean enQueue(String data) {
		if((rear+1)%SIZE==front) {	//队满
			return false;	//入队失败
		}
		else {
			list[rear]=data;
			rear=(rear+1)%SIZE;
			return true;
		}
	}
	public String deQueue() {
		if(isEmpty()) {	//队空
			return null;
		}
		else {
			String data=list[front];
			front=(front+1)%SIZE;
			return data;
		}
	}
}
