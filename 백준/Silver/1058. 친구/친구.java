
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import java.util.*;

class Main {
    static boolean connect[][];
    static int max=Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        connect=new boolean[size+1][size+1];

        for(int i=1;i<=size;i++){
            String[] st=br.readLine().split("");
            for(int j=1;j<=size;j++){
                if(st[j-1].equals("Y")){
                 connect[i][j]=true;
                 connect[j][i]=true;
                }

            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=size;i++){
            q.add(i);
            int count=0;
            boolean[] visited=new boolean[size+1];
            visited[i]=true;
            int stop=0;
            while(!q.isEmpty()){
                int qsize=q.size();
                stop++;
                if(stop>2){break;}
                for(int z=0;z<qsize;z++){
                int temp=q.poll();
                for(int j=1;j<=size;j++){
                    if(connect[temp][j]&&!visited[j]){
                        visited[j]=true;
                        q.add(j);
                        count++;
                    }
                }
                }
            }
            q.clear();
            max=Math.max(count,max);
        }
        System.out.println(max);




    }
}

