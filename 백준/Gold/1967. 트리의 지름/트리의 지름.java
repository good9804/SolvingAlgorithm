
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;


class Main {
    static int nodeSize;
    static boolean[] isVisited;
    static ArrayList<Bridge>[] Bridges;
    static int firstNode;
    static int maxCost=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        nodeSize = Integer.parseInt(br.readLine());
        if(nodeSize==1){
            System.out.println(0);
            return;
        }
        isVisited=new boolean[nodeSize+1];
        Bridges=new ArrayList[nodeSize+1];
        for(int i=1;i<=nodeSize;i++){
            Bridges[i] = new ArrayList<>();
        }
        for(int i=1;i<nodeSize;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            Bridges[parent].add(new Bridge(child,cost));
            Bridges[child].add(new Bridge(parent,cost));
        }
        isVisited[1]=true;
        dfs(1,0);
        Arrays.fill(isVisited,false);
        isVisited[firstNode]=true;
        maxCost=0;
        dfs(firstNode,0);
        System.out.println(maxCost);


    }
    static void dfs(int currentNode,int currentCost){
        if(maxCost<currentCost){
            firstNode=currentNode;
            maxCost=currentCost;
        }
        for(Bridge bridge:Bridges[currentNode]){
            if(!isVisited[bridge.num]){
                isVisited[bridge.num]=true;
                dfs(bridge.num, currentCost+ bridge.cost);
            }
        }
    }



}
class Bridge{
    int num;
    int cost;
    public Bridge(int num,int cost){
        this.num=num;
        this.cost=cost;
    }
}












