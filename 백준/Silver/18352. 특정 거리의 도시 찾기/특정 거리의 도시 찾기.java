import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import java.util.*;

class Main {
    static ArrayList<Integer>[] patharray;
    static boolean[] Visted;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        Visted=new boolean[node+1];
        int path = Integer.parseInt(st.nextToken());
        int counter = Integer.parseInt(st.nextToken());
        int start=Integer.parseInt(st.nextToken());
        patharray=new ArrayList[node+1];
        for(int i=1;i<=node;i++){
            patharray[i]=new ArrayList<>();
        }
        for(int i=0;i<path;i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            patharray[first].add(end);
        }

        int count=0;
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        Visted[start]=true;
        StringBuilder sb=new StringBuilder();
        ArrayList<Integer> answer=new ArrayList<>();
        while(!queue.isEmpty()){
            count++;
            if(count>counter){
                if(answer.size()==0){
                    System.out.println(-1);
                    return;
                }
                else{
                    Collections.sort(answer);
                    for(int i=0;i<answer.size();i++){
                 
                 sb.append(answer.get(i)).append("\n");
                }
                    System.out.println(sb);
                    return;
                }}
            int qsize=queue.size();
            for(int i=0;i<qsize;i++){
                int currentnode=queue.poll();
                for(int j=0;j<patharray[currentnode].size();j++){
                    if(!Visted[patharray[currentnode].get(j)]){
                        if(count==counter){
                            answer.add(patharray[currentnode].get(j));
                        }
                        queue.add(patharray[currentnode].get(j));
                        Visted[patharray[currentnode].get(j)]=true;
                    }
                }
            }





        }
        if(sb.length()==0){
            System.out.println(-1);
            return;
        }

    }
}

