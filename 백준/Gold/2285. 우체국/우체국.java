import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;


class Main{

    static int N;
    static int T;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Node> pq=new PriorityQueue<>();
        long total=0;
        for(int i=0;i<N;i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());
            pq.add(new Node(index,people));
            total+=people;
        }
        long sum=0;
        while (!pq.isEmpty()) {
            Node n = pq.poll();
            sum+=n.people;
            if(sum>=(total+1)/2){
                System.out.println(n.index);
                return;
            }
        }








    }
}
class Node implements Comparable<Node>{
    int index;
    int people;
    public Node(int index,int people){
        this.index=index;
        this.people=people;
    }
    @Override
    public int compareTo(Node n){
            return this.index-n.index;
    }


}










