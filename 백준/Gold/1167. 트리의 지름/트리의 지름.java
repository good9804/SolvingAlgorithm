
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

class Main {
    static boolean[] isVisited;
    static int answer=Integer.MIN_VALUE;
    static ArrayList<Node>[] lists;
    static int root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());//
        isVisited=new boolean[N+1];
        lists=new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            lists[i]=new ArrayList<>();
        }
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            ArrayList<Node> list=lists[Integer.parseInt(st.nextToken())];
            while(true){
                int end = Integer.parseInt(st.nextToken());
                if(end==-1){break;}
                int cost = Integer.parseInt(st.nextToken());

                list.add(new Node(end, cost));
            }
        }


            isVisited[1]=true;
            dfs(1,0);
            Arrays.fill(isVisited,false);
            isVisited[1]=false;
            isVisited[root]=true;
            dfs(root,0);

        System.out.println(answer);






}static void dfs(int current,int cost){
        for(Node next:lists[current]){
            if(!isVisited[next.end]){
                isVisited[next.end]=true;
                dfs(next.end,cost+ next.cost);
                isVisited[next.end]=false;
            }
        }
        if(cost>answer){
        answer=Math.max(cost,answer);
        root=current;
        }
    }
}

class Node{
    int end;
    int cost;
    public Node(int end,int cost){
        this.end=end;
        this.cost=cost;
    }

}