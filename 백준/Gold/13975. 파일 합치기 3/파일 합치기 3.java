
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
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            int[] arr=new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> q=new PriorityQueue<>();
            long answer=0;
            for(int i=0;i<N;i++){
                q.add(Long.parseLong(st.nextToken()));
            }
            while(true){
                long first=q.poll();
                long second=q.poll();
                answer+=first+second;
                q.add(first+second);


                if(q.size()==1){
                    break;
                }
            }
            sb.append(answer+"\n");

        }
        System.out.print(sb.substring(0,sb.length()-1));






    }
}










