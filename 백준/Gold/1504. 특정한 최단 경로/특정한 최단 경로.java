import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

class Main {
    static int N;
    static int E;
    static  ArrayList<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
       //무방향 그래프 1->N번 정점으로 최단거리이동
         list=new ArrayList[N+1];
        int[] costs=new int[N+1];
        boolean[] visited=new boolean[N+1];
        for(int i=1;i<=N;i++){
            list[i] = new ArrayList<>();
            costs[i]=9876543;
        }
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,cost));
            list[b].add(new Node(a,cost));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        //1  v1 v2     N
        //1  v2 v1   N
        PriorityQueue<Node> pq=new PriorityQueue<>();
        costs[1]=0;
        //1~ N구한다음에 분할 해서 구하기?
        pq.add(new Node(1,0));
        while(!pq.isEmpty()){
            Node cur=pq.poll();
            if(cur.cost>costs[cur.end]){
                continue;
            }

            for(Node next: list[cur.end]){
                if(costs[cur.end]+next.cost<costs[next.end]){
                    costs[next.end]=costs[cur.end]+next.cost;
                    pq.add(new Node(next.end,costs[next.end]));
                }

            }
        }
        if(costs[v1]==9876543||costs[v2]==9876543||costs[N]==9876543){
            System.out.println(-1);
            return;
        }
        
            System.out.println(Math.min(costs[v1]+find(v1,v2)+find(v2,N),costs[v2]+find(v2,v1)+find(v1,N)));
        








    }
    static int find(int start,int end){
        int[] costs=new int[N+1];
        Arrays.fill(costs,98765432);
        PriorityQueue<Node> pq=new PriorityQueue<>();
        costs[start]=0;
        //1~ N구한다음에 분할 해서 구하기?
        pq.add(new Node(start,0));
        while(!pq.isEmpty()){
            Node cur=pq.poll();
            if(cur.cost>costs[cur.end]){
                continue;
            }

            for(Node next: list[cur.end]){
                if(costs[cur.end]+next.cost<costs[next.end]){
                    costs[next.end]=costs[cur.end]+next.cost;
                    pq.add(new Node(next.end,costs[next.end]));
                }

            }
        }
        return costs[end];
    }


}
class Node implements Comparable<Node>{
    int end;
    int cost;

    public Node(int end,int cost){
        this.end=end;
        this.cost=cost;
    }
    @Override
    public int compareTo(Node n){
        return this.cost-n.cost;
    }


}


