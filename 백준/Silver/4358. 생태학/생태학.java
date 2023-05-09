
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import java.util.*;

class Main {
    static int size;
    static int[][] values;
    static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<String> pq = new PriorityQueue<>();

        while(true){
            String tree = br.readLine();

            if(tree==null || tree.equals("")) break;
            pq.add(tree);
        }
        if(pq.size()==0){return;}
        double size= (double) pq.size();
        String first=pq.poll();
        double count=1.0;
        StringBuilder stringBuilder=new StringBuilder();
            while(!pq.isEmpty()){
                String temp=pq.poll();
                if(first.equals(temp)){
                count++;}else{
                    stringBuilder.append(first+" ").append(String.format("%.4f",(count/size)*100.0)).append("\n");
                    first=temp;
                    count=1;
                }
            }
        stringBuilder.append(first+" ").append(String.format("%.4f",(count/size)*100.0)).append("\n");
        System.out.print(stringBuilder);
        }
    }





