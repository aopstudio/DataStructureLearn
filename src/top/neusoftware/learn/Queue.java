package top.neusoftware.learn;

public class Queue {	//链式队列实现
	private QueueNode front,rear;
	public Queue() {
		front=rear=new QueueNode();
		front.setNext(null);
	}
	public boolean isEmpty() {	//判空
		if(front==rear)
			return true;
		else
			return false;
	}
	
}
