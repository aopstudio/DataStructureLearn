package top.neusoftware.learn;

public class Queue<T> {	//链式队列实现
	private QueueNode<T> front,rear;
	public Queue() {
		front=rear=new QueueNode<T>();
		front.setNext(null);
	}
	public boolean isEmpty() {	//判空
		if(front==rear)
			return true;
		else
			return false;
	}

	public void enQueue(T data) {	//入队
		QueueNode<T> node=new QueueNode<T>(data);
		rear.setNext(node);
		rear=rear.getNext();
	}
	public T deQueue() {	//出队
		if(isEmpty())
			return null;
		QueueNode<T> node=front.getNext();
		T data=node.getData();
		front.setNext(node.getNext());
		if(rear==node)	//原队列中只有一个结点
			rear=front;	//置空
		return data;
	}
}
