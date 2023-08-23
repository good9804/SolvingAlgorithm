
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    static int V;
    static int E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N==0){
            System.out.println(0);return;}
        long answer=0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] isChecked=new boolean[10001];
        while(N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cost=Integer.parseInt(st.nextToken());
            int index=Integer.parseInt(st.nextToken());
            pq.add(new Node(index,cost));

        }
        while(!pq.isEmpty()){
            Node n = pq.poll();
            for(int i=n.index;i>=1;i--){
                if(!isChecked[i]){
                    isChecked[i]=true;
                    answer+=n.cost;
                    break;
                }
            }
        }
        System.out.println(answer);

    }
}
class Node implements Comparable<Node>{
    int index;
    int cost;
    public Node(int index,int cost){
        this.index=index;
        this.cost=cost;
    }
    @Override
    public int compareTo(Node n){
        return n.cost-this.cost;
    }
    }
