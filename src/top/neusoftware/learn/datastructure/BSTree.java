package top.neusoftware.learn.datastructure;
//二叉查找树
public class BSTree extends BinaryTree<Integer> {
	public BSTree(int[] str) {
		for(int i=0;i<str.length;i++) {
			insert(str[i]);
		}
	}
	public boolean insert(int data) {
		BiTNode<Integer> node=root;
		while(node!=null) {
			if(data==node.getData()) {	//树中存在相同关键字的结点
				return false;	//返回插入失败
			}
			else if(data<node.getData()) {
				node=node.getLchild();
			}
			else {
				node=node.getRchild();
			}
		}
		node=new BiTNode<Integer>(data);
		return true;	//插入成功
	}
	public BiTNode<Integer> search(int data) {
		BiTNode<Integer> node=root;
		while(node!=null&&data!=node.getData()) {
			if(data<node.getData())
				node=node.getLchild();
			else
				node=node.getRchild();
		}
		return node;
	}
}
