package top.neusoftware.learn;
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

	public void BFS(int v){
		LinkQueue<String> queue=new LinkQueue<String>();
		System.out.print(vertexes[v]);
		queue.enQueue(vertexes[v]);
		while (!queue.isEmpty()) {
			queue.deQueue();
			for()
		}
	}
}
