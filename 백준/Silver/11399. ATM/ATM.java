import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int size;
    static int max=Integer.MIN_VALUE;
    static ArrayList<Integer> AarrayList;
    static ArrayList<Integer> BarrayList;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        StringTokenizer st=new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            pq.add(Integer.parseInt(st.nextToken()));
        }
        int answer=0;
        int sum=0;
        while(!pq.isEmpty()){
            answer+=pq.poll();
            sum+=answer;
        }
        System.out.println(sum);

    }   }



