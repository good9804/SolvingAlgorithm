import java.lang.*;
import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<line;i++){
            int num = Integer.parseInt(br.readLine());
            if(maxq.size()== minq.size()){
                maxq.add(num);
            }else minq.add(num);

            if(!minq.isEmpty() && !maxq.isEmpty() && minq.peek() < maxq.peek()) {
                int temp = minq.poll();
                minq.add(maxq.poll());
                maxq.add(temp);
            }
            sb.append(maxq.peek() + "\n");
        }
        System.out.println(sb);
        }

    }
