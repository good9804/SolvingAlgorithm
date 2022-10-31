import java.io.*;

import java.util.Arrays;
import java.lang.String;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;


public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());

        int b = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        int index[]=new int[a];
        for(int i=1;i<=a;i++){
            queue.add(i);
        }
        for(int i=0;i<a;i++){
            for(int j=0;j<b-1;j++){
                int k=queue.element();
            queue.poll();
                queue.add(k);
            }
            index[i]= queue.element();
            queue.poll();
        }
        StringBuilder sb=new StringBuilder();
        sb.append("<");
        for(int i=0;i<a;i++){
            if(i==a-1){sb.append(index[i]).append(">");}
            else sb.append(index[i]).append(",").append(" ");
        }
        System.out.print(sb);






    }}