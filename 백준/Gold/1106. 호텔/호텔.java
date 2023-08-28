
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int   C = Integer.parseInt(st.nextToken());
        int   N = Integer.parseInt(st.nextToken());
        int[] dp=new int[1102];
        int[][] arr=new int[2][N+1];
        Arrays.fill(dp,1_000_000_000);
        dp[0]=0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            arr[0][i]=Integer.parseInt(st.nextToken());//비용
            arr[1][i]=Integer.parseInt(st.nextToken());//단위
            pq.add(new Node(arr[0][i],arr[1][i]));
            dp[arr[1][i]]=arr[0][i];
        }


        for(int i=1;i<=N;i++){
            Node n=pq.poll();
            int p= n.people;
            int c= n.cost;
            // 3 5 면
            // 5 / 10 check
            for(int j=1;j<=1101;j++){
                if(j-p>=0){
                dp[j]=Math.min(dp[j],dp[j-p]+c);}
            }
            }
        int answer=Integer.MAX_VALUE;
        for(int i=C;i<=1101;i++){

        answer=Math.min(dp[i],answer);
        }
        //10을 넘기기위한 최소 dp[i] i를 넘거기위한 최소비용
        System.out.println(answer);




    }
}
class Node implements Comparable<Node>{
    int cost;
    int people;
    public Node(int cost,int people){
        this.cost=cost;
        this.people=people;
    }
    @Override
    public int compareTo(Node n){
        return n.people-this.people;
    }

}