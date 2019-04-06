package top.neusoftware.learn;

public class TestQueue {
	/*public static void main(String[] args) {
		String[] queueStr= {"1","+","2","*","3","+","(","4","*","5","+","6",")","*","7"};
		Queue<String> queue=new Queue<String>();
		for(int i=0;i<queueStr.length;i++) {
			queue.enQueue(queueStr[i]);
		}
		String data;
		while((data=queue.deQueue())!=null) {
			System.out.print(data+"\t");
		}
	}*/
	public static void main(String[] args) {
		String[] queueStr= {"1","+","2","*","3","+","(","4","*","5","+","6",")","*","7"};
		Queue queue=new Queue(queueStr.length+1);	//因为牺牲了一个单元，所以要在初始化的时候设置多一个的size
		for(int i=0;i<queueStr.length;i++) {
			queue.enQueue(queueStr[i]);
		}
		String data;
		while((data=queue.deQueue())!=null) {
			System.out.print(data+"\t");
		}
	}
}
