
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

class Main {
    static int N;
    static int M;
    static int K;
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.add(new Node(a,b));
        }

        int start=pq.peek().a;
        int end=pq.poll().b;
        int answer=end-start;
        while(!pq.isEmpty()){
            Node n=pq.poll();
            if(n.a<=end&&n.b>end) {

                answer += n.b - end;
                end = n.b;
                continue;
            }
            if(n.a>end){
                answer+=n.b-n.a;
                end=n.b;
                continue;
            }


        }
        System.out.println(answer);



    }
}
class Node implements Comparable<Node>{
    int a;
    int b;
    public Node(int a,int b){
        this.a=a;
        this.b=b;
    }
    @Override
    public int compareTo(Node n){
        return this.a-n.a;
    }
}




