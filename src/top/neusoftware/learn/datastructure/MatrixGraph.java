package top.neusoftware.learn.datastructure;

import java.util.LinkedList;
import java.util.List;
//用邻接矩阵表示的图
public class MatrixGraph {	//不带权的简单无向图的邻接矩阵表示
	private int[][] edges;	//存放边的信息
	private String[] vertexes;	//存放结点的信息
	private int vexNum;	//当前顶点的数量
	public MatrixGraph(int[][] edges, String[] vertexes) {
		super();
		this.edges = edges;
		this.vertexes = vertexes;
		this.vexNum=vertexes.length;
	}

	public MatrixGraph(int max) {
		this.edges=new int[max][max];
		this.vertexes=new String[max];
		this.vexNum=0;
	}
	public boolean insertVertex(String vertex){
		if(vexNum==vertexes.length){
			return false;
		}
		for (int i=0;i<vertexes.length;i++) {
			if(vertexes[i]==null){
				vertexes[i]=vertex;
				vexNum++;
				return true;
			}
		}
		return false;
	}
	public boolean deleteVertex(String vertex){
		if(vexNum==0){
			return false;	//空图
		}
		for (int i=0;i<vertexes.length;i++){
			if(vertexes[i].equals(vertex)){
				vertexes[i]=null;
				vexNum--;
				for(int j=0;j<vertexes.length;j++){
					edges[i][j]=0;	//与顶点相关的所有边都删除
					edges[j][i]=0;
				}
				return true;
			}
		}
		return false;	//没找到
	}
	public boolean addEdge(int x,int y){	//根据两点的标号插入边
		if(vertexes[x]==null || vertexes[y]==null) {    //两者之一没有顶点
			return false;
		}
		edges[x][y]=1;
		edges[y][x]=1;
		return true;
	}
	public boolean deleteEdge(int x,int y){	//根据两点的标号删除边
		if(vertexes[x]==null || vertexes[y]==null ) {    //两者之一没有顶点
			return false;
		}
		if(edges[x][y]==0 || edges[y][x]==0){	//顶点之间没有边
			return false;
		}
		edges[x][y]=0;
		edges[y][x]=0;
		return true;
	}

	// 越界判断应该是和最大容量也就是vertexes.length比较，而不是和顶点数vexNum比较。因为如果大于vexNum，
	// 不一定代表越界。比如容量为5，一开始存满，从0到4，然后把2和3删除，之后要找4，此时vexNum为3，而4比3大，但依然可以找到4.

	public int firstNeighbor(int x) {    //给定顶点编号x，找出第一个相邻的顶点
		if(x>vertexes.length-1 || vertexes[x]==null) {    //给定编号越界或没有顶点
			return -1;	//不存在
		}
		for (int i=0;i<vertexes.length;i++){
			if(edges[x][i]!=0){	//存在边
				return i;	//返回i
			}
		}
		return -1;	//没有相邻的顶点
	}
	public int nextNeighbor(int x, int y) {    //给定顶点编号x，和它的邻接点y的编号，找出y之后的下一个邻接点
		if(x>vertexes.length-1 || y>vertexes.length-1){	//越界
			return -1;
		}
		for (int i=y+1;i<vertexes.length;i++){
			if(edges[x][i]!=0){	//存在边
				return i;	//返回i
			}
		}
		return -1;	//没有相邻的顶点
	}

	private void depthFirstSearch(boolean[] isVisited,int  i) {
		//首先访问该结点，在控制台打印出来
		System.out.print(vertexes[i]+"  ");
		//置该结点为已访问
		isVisited[i]=true;

		int w=firstNeighbor(i);//
		while (w!=-1) {
			if (!isVisited[w]) {
				depthFirstSearch(isVisited,w);
			}
			w=nextNeighbor(i, w);
		}
	}

	//对外公开函数，深度优先遍历，与其同名私有函数属于方法重载
	public void depthFirstSearch() {
		boolean[] isVisited=new boolean[vexNum];
		for(int i=0;i<vexNum;i++) {
			//因为对于非连通图来说，并不是通过一个结点就一定可以遍历所有结点的。
			if (!isVisited[i]) {
				depthFirstSearch(isVisited,i);
			}
		}
	}

	public void broadFirstSearch(){
		boolean[] isVisited=new boolean[vexNum];
		for(int i=0;i<vexNum;i++){
			if(!isVisited[i]){
				broadFirstSearch(isVisited,i);
			}
		}
	}

	private void broadFirstSearch(boolean[] isVisited,int i){
		LinkedList<Integer> queue=new LinkedList<Integer>();
		queue.offer(i);
		while(!queue.isEmpty()){
			int j=queue.poll();
			isVisited[j]=true;
			System.out.print(vertexes[j]+" ");
			int u=firstNeighbor(j);
			while(u!=-1){
				if(!isVisited[u]){
					queue.offer(u);
				}
				u=nextNeighbor(j,u);
			}
		}
	}
}
