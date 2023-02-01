import java.util.Scanner; ;
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;
class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int line = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<line;i++){
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                if(q.isEmpty()){sb.append(0).append("\n");}
                else sb.append(q.poll()).append("\n");
            }else q.add(num);
        }
        System.out.println(sb);

    }
}