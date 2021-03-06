package top.neusoftware.learn.datastructure;

public class Stack {
	private String[] list;
	private int top;
	private final int SIZE;
	public Stack(int size) {
		list=new String[size];
		SIZE=size;
		top=-1;
	}
	public boolean isEmpty() {
		if(top==-1) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean push(String elem) {
		if(top+1>=SIZE) {
			return false;
		}
		else {
			list[++top]=elem;
			return true;
		}
	}
	public String pop() {
		if(top==-1) {
			return null;
		}
		else {
			return list[top--];
		}
	}
	public String getTop() {
		if(top==-1) {
			return null;
		}
		else {
			return list[top];
		}
	}
}
