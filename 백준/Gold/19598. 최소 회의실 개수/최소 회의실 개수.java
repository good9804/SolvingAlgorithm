
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.List;


class Main{

    static int N;
    static int K;
    static int[] students;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> pq=new PriorityQueue<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            pq.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        PriorityQueue<Integer> endPQ=new PriorityQueue<>();
        int answer=1;
        endPQ.add(pq.poll().end);
        while(!pq.isEmpty()){
            Node n=pq.poll();
            if(endPQ.peek()<=n.start){
                endPQ.poll();
            }
            endPQ.add(n.end);
        }
        System.out.println(endPQ.size());




}}
class Node implements Comparable<Node>{
    int start;
    int end;
    public Node(int start,int end){
        this.start=start;
        this.end=end;
    }
    @Override
    public int compareTo(Node n){
        if(this.start==n.start){
            return this.end-n.end;
        }else return this.start-n.start;

    }

}




