package top.neusoftware.learn;

public class BiTNode<T> {
	private T data;
	private BiTNode<T> lchild,rchild;
	public BiTNode(T data, BiTNode<T> lchild, BiTNode<T> rchild) {
		super();
		this.data = data;
		this.lchild = lchild;
		this.rchild = rchild;
	}
	public BiTNode(T data) {
		this.data=data;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public BiTNode<T> getLchild() {
		return lchild;
	}
	public void setLchild(BiTNode<T> lchild) {
		this.lchild = lchild;
	}
	public BiTNode<T> getRchild() {
		return rchild;
	}
	public void setRchild(BiTNode<T> rchild) {
		this.rchild = rchild;
	}
	
}
