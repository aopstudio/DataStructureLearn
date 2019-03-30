package top.neusoftware.learn;

public class TestStack {
	public static void main(String[] args) {
		String[] postfix= {"6","5","2","3","+","8","*","+","3","+","*"};
		calculatePostfix(postfix);
	}
	public static void calculatePostfix(String[] postfix) {	//计算后缀表达式
		Stack transform=new Stack(postfix.length);
		for(int i=0;i<postfix.length;i++) {
			String str=postfix[i];
			if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
				int n = Integer.parseInt(transform.pop());
				int m = Integer.parseInt(transform.pop());
				int num = 0;
				if(str.equals("+")) num = m+n;
				if(str.equals("-")) num = m-n;
				if(str.equals("*")) num = m*n;
				if(str.equals("/")) num = m/n;
				transform.push(String.valueOf(num));
			}
			else {
				transform.push(str);
			}
		}
		System.out.println(transform.getTop());
	}
}
