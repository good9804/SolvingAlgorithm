
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
class Main {
    static int N;
    static int M;
    static int K;
    static ArrayList<Node>[] list;
    static ArrayList<Integer> answers;
    static boolean[] isVisited;
    static int[] costs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        list=new ArrayList[N+1];

        for(int i=1;i<=N;i++){
            list[i]=new ArrayList<>();
        }
        for(int i=0;i<K;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end,cost));

        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        if(start==end){
            System.out.println(0);
            System.out.println(1);
            System.out.println(start);
            return;
        }
        PriorityQueue<Node> q=new PriorityQueue<>();
        q.add(new Node(start,0));
        isVisited=new boolean[N+1];
        costs=new int[N+1];
        isVisited[start]=true;
        Arrays.fill(costs, 100000000);
        costs[start]=0;
        int[] arr=new int[N+1];
        while(!q.isEmpty()){
            Node current=q.poll();
            if(current.cost>costs[current.end]){continue;}
            for(Node next:list[current.end]){
                if(costs[next.end]>costs[current.end]+next.cost){
                    costs[next.end]=costs[current.end]+next.cost;
                    arr[next.end]= current.end;
                    q.add(new Node(next.end,costs[next.end]));
                }
            }
        }
        Stack<Integer> stack=new Stack<>();
        stack.push(end);
        int index=end;
        while(true){
            if(arr[index]==start){break;}
            stack.push(arr[index]);
            index=arr[index];

        }
        stack.push(start);
        StringBuilder sb=new StringBuilder();
        sb.append(stack.size()+"\n");
        while (!stack.isEmpty()){

         sb.append(stack.pop()+" ");
        }




        System.out.println(costs[end]);
        System.out.println(sb);









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
