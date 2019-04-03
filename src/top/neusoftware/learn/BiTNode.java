package top.neusoftware.learn;

public class BiTNode {
	private String data;
	private BiTNode lchild,rchild;
	public BiTNode(String data, BiTNode lchild, BiTNode rchild) {
		super();
		this.data = data;
		this.lchild = lchild;
		this.rchild = rchild;
	}
	public BiTNode(String data) {
		this.data=data;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public BiTNode getLchild() {
		return lchild;
	}
	public void setLchild(BiTNode lchild) {
		this.lchild = lchild;
	}
	public BiTNode getRchild() {
		return rchild;
	}
	public void setRchild(BiTNode rchild) {
		this.rchild = rchild;
	}
	
}
