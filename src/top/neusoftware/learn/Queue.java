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
	public void enQueue(String data) {	//入队
		QueueNode node=new QueueNode(data);
		rear.setNext(node);
		rear=rear.getNext();
	}
	public String deQueue() {	//出队
		if(isEmpty())
			return null;
		QueueNode node=front.getNext();
		String data=node.getData();
		front.setNext(node.getNext());
		if(rear==node)	//原队列中只有一个结点
			rear=front;	//置空
		return data;
	}
}
