package top.neusoftware.learn;

public class TestStack {
	/*public static void main(String[] args) {
		String[] postfix= {"6","5","2","3","+","8","*","+","3","+","*"};
		String[] infix= {"1","+","2","*","3","+","(","4","*","5","+","6",")","*","7"};
		//calculatePostfix(postfix);
		String[] newPostfix=infixToPostfix(infix);
		System.out.println();
		for(String ch:newPostfix) {
			if(ch!=null) {
				System.out.print(ch);
			}
		}
		System.out.println();
		calculatePostfix(newPostfix);
	}*/

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
	public static String[] infixToPostfix(String[] infix) {	//中缀表达式转后缀表达式
		Stack transform=new Stack(infix.length);
		String[] postfix=new String[infix.length];	//此时不知道infix去除括号后的元素数量，暂时用全部元素的数量代替
		int p=0;
		transform.push("#");
		for(int i=0;i<infix.length;i++) {
			String str=infix[i];
			int icp=icp(str);
			if(icp==-1) {	//读到的是数字
				System.out.print(str+" ");
				postfix[p++]=str;
			}
			else {	//读到的是运算符
				if(icp>isp(transform.getTop()))	{	//当前符号优先级大于栈顶元素优先级或者栈为空（栈为空时isp(transform.getTop())==-1）
					transform.push(str);	//当前符号入栈
				}
				else if(icp==1) {	//当前符号为）
					while(!transform.getTop().equals("(")) {	//栈顶元素不是（就弹栈输出
						postfix[p++]=transform.getTop();
						System.out.print(transform.pop()+" ");						
					}
					transform.pop();	//把（弹栈但不输出
				}
				else {
					while(icp<isp(transform.getTop())) {	//当前符号优先级小于栈顶元素优先级
						postfix[p++]=transform.getTop();
						System.out.print(transform.pop()+" ");	//弹栈并输出直到当前符号优先级大于栈顶元素优先级
					}
					transform.push(str);	//当前符号入栈
				}
			}
		}
		while(transform.getTop()!="#") {	//将输入的字符序列扫描完毕后，如果栈内还有元素，就弹栈输出直到栈空为止
			postfix[p++]=transform.getTop();
			System.out.print(transform.pop()+" ");
		}
		String[] postfixStrings=new String[p];	//p经过前面的递增，现在是原有字符序列去掉括号剩下的字符数量
		for(int i=0;i<p;i++) {	//去除postfix队尾的因为省略括号而产生的null元素
			postfixStrings[i]=postfix[i];
		}
		return postfixStrings;
	}
	public static int isp(String str) {	//栈内优先数
		switch (str) {
			case "+":
			case "-":
				return 3;
			case "*":
			case "/":
				return 5;
			case "(":
				return 1;
			case ")":
				return 6;
			case "#":
				return 0;
			default:
				return -1;
		}
	}
	public static int icp(String str) {	//栈外优先数
		switch (str) {
			case "+":
			case "-":
				return 2;
			case "*":
			case "/":
				return 4;
			case "(":
				return 6;
			case ")":
				return 1;
			case "#":
				return 0;
			default:
				return -1;
		}
	}
}
