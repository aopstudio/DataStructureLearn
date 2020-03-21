package top.neusoftware.learn.datastructure;

public class TestGraph {
    public static void main(String[] args){
        int[][] m=new int[5][5];
        m[0][1]=1;
        m[1][3]=1;
        m[2][3]=1;
        m[2][4]=1;
        m[3][2]=1;
        m[3][4]=1;
        String[] v={"0","1","2","3","4"};
        MatrixGraph mg=new MatrixGraph(m,v);
        mg.broadFirstSearch();
    }
}
