package top.neusoftware.learn.datastructure;

public class ListGraph {
    private VNode[] mVexs;  // 顶点数组,即邻接表
    private int vexNum;	//当前顶点的数量
    public ListGraph(int max){
        this.mVexs=new VNode[max];
        this.vexNum=0;
    }
    public boolean insertVertex(String data) {
        if (vexNum == mVexs.length) {   //容量已满
            return false;
        }
        for (int i = 0; i < mVexs.length; i++) {
            if (mVexs[i] == null) {
                mVexs[i] = new VNode(data);
                vexNum++;
                return true;
            }
        }
        return false;
    }
    private class VNode {   //顶点结点内部类
        private String data;          // 顶点信息
        private ENode firstEdge;    // 指向第一条依附该顶点的弧
        public VNode(String data){
            this.data=data;
        }
        public String getData() {
            return data;
        }
        public void setData(String data) {
            this.data = data;
        }
        public ENode getFirstEdge() {
            return firstEdge;
        }
        public void setFirstEdge(ENode firstEdge) {
            this.firstEdge = firstEdge;
        }
    }
    private class ENode {   //边结点内部类
        private int ivex;       // 该边所指向的顶点的位置
        private int degree;		//该边的度
        private ENode nextEdge; // 指向下一条弧的指针
        public ENode() {	//空的构造方法，主要用于头结点的构造
            super();
        }
        public ENode(int ivex, int degree) {	//因为常常在构造时并不知道下一条弧，所以不把它作为构造方法的参数
            this.ivex=ivex;
            this.degree=degree;
        }
        public int getIvex() {
            return ivex;
        }
        public int getDegree() {
            return degree;
        }
        public ENode getNextEdge() {
            return nextEdge;
        }
        public void setNextEdge(ENode nextEdge) {
            this.nextEdge = nextEdge;
        }
        public void setIvex(int ivex) {
            this.ivex = ivex;
        }
        public void setDegree(int degree) {
            this.degree = degree;
        }
    }
}
