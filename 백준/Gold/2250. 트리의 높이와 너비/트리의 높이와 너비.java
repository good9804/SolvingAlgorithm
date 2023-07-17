
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.List;


class Main{
    static int size;
    static List<Node> nodes = new ArrayList<>();
    static int[][] nodePan;
    static int rootIndex;
    static boolean findFirst=false;
    static int wideMax=0;
    static int heightMax=0;
    static int nodeOrderCount=1;
    static int heightAnswer=0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        for(int i=0;i<=size;i++){
            nodes.add(new Node(i,0,0));
        }

        for(int i=1;i<=size;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int mid = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right= Integer.parseInt(st.nextToken());
            nodes.get(mid).left=left;
            nodes.get(mid).right=right;
            if(left>0){
            nodes.get(left).parent=mid;}
            if(right>0){
            nodes.get(right).parent=mid;}


        }

        rootIndex=findRoot();
        findHeight(1,rootIndex);
        makeNodePan();
        inOrder(1,rootIndex);
        findMax();
        System.out.println(heightMax+" "+wideMax);




}
static void findHeight(int height,int nodeNumber){
        heightMax=Math.max(heightMax,height);
        if(nodes.get(nodeNumber).left>0){
            findHeight(height+1,nodes.get(nodeNumber).left);
        }
    if(nodes.get(nodeNumber).right>0){
        findHeight(height+1,nodes.get(nodeNumber).right);
    }
}
static void findMax(){

        for(int i=1;i<nodePan.length;i++){
            int left=0;
            for(int j=1;j<nodePan[i].length;j++){
                if(nodePan[i][j]>0){
                    left=j;
                    break;
                }
            }
            for(int j=nodePan[i].length-1;j>0;j--){
                if(nodePan[i][j]>0){
                    if(j-left+1>wideMax){
                        wideMax=j-left+1;
                        heightMax=i;
                    }


                    break;
                }
            }
        }
    }
    static void inOrder(int height,int nodeNumber){
        if(nodes.get(nodeNumber).left>0){
            inOrder(height+1,nodes.get(nodeNumber).left);
        }
        nodePan[height][nodeOrderCount++]=nodeNumber;
        if(nodes.get(nodeNumber).right>0){
            inOrder(height+1,nodes.get(nodeNumber).right);
        }


    }
static int findRoot(){
        for(int i=1;i<=nodes.size();i++){
            if(nodes.get(i).parent==-1){
                return i;
            }
        }
        return 1;
    }
    static void makeNodePan(){
        int col=1;
        for(int i=1;i<=size;i++){
            if(col*2<=size){
            col*=2;}else{break;}
        }
        nodePan=new int[heightMax+1][col*2+1];


    }

}
class Node{
    int mid;
    int left;
    int right;
    int parent;
    public Node(int mid,int left,int right){
        this.parent=-1;
        this.mid = mid;
        this.left = left;
        this.right = right;
    }
}
