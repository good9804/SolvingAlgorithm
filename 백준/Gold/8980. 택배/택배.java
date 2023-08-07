

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;


class Main {

    static int N;
    static int C;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int MCount = Integer.parseInt(br.readLine());
        PriorityQueue<Node> currentQ = new PriorityQueue<>();
        for(int i=0;i<MCount;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            currentQ.add(new Node(start, end, cost));
        }
        int current=0;
        int answer=0;
        int index=1;
        int[] arr=new int[N+1];
        for(int i=1;i<=N;i++){
            arr[i]=C;
        }
        index++;
        while(!currentQ.isEmpty()){
            Node n = currentQ.poll();
            int max=Integer.MAX_VALUE;
            for(int i=n.start;i<n.end;i++){
                max=Math.min(arr[i],max);
            }

            for(int i=n.start;i<n.end;i++){
                arr[i]-=Math.min(n.cost,max);
            }
            answer+=Math.min(n.cost,max);
        }
        System.out.println(answer);




    }
}
class Node implements Comparable<Node>{
    int start;
    int end;
    int cost;
    public Node(int start,int end,int cost){
        this.start=start;
        this.end=end;
        this.cost=cost;
    }
    @Override
    public int compareTo(Node n){
        if(this.end==n.end){
            return this.start- n.start;
        }else return this.end-n.end;
    }
}










