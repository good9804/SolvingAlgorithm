import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
      
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int size=Integer.parseInt(br.readLine());
        boolean[][] graph=new boolean[size+1][size+1];
        int connectCount=Integer.parseInt(br.readLine());
        for(int i=0;i<connectCount;i++){
            String[] connect=br.readLine().split(" ");
            graph[Integer.parseInt(connect[0])][Integer.parseInt(connect[1])]=true;
            graph[Integer.parseInt(connect[1])][Integer.parseInt(connect[0])]=true;


        }

        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> list=new ArrayList<>();
        q.add(1);
        list.add(1);
        int count=0;
        while(!q.isEmpty()){
            int current=q.poll();
            for(int k=1;k<=size;k++){
                if(graph[current][k]==true&&!list.contains(k))
                {
                    list.add(k);
                    q.add(k);}
            }

        }
        System.out.println(list.size()-1);
    }
}