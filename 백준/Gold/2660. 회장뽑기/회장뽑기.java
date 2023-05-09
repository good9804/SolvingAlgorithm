
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
    static ArrayList<Integer>[] friends;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        friends=new ArrayList[size+1];
        for(int i=1;i<=size;i++){
            friends[i] = new ArrayList<>();
        }
        while(true){
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(stringTokenizer.nextToken());
            if(p1==-1){break;}
            int p2 = Integer.parseInt(stringTokenizer.nextToken());
            friends[p1].add(p2);
            friends[p2].add(p1);
        }
        Queue<Integer> q = new LinkedList<>();
        PriorityQueue<Integer> answer = new PriorityQueue<>();
        for(int i=1;i<=size;i++){
            q.clear();
            q.add(i);
            int score=0;
            boolean[] Visited=new boolean[size+1];
            Visited[i]=true;
            int count=1;

            while(!q.isEmpty()){
                if(count==size){
                    if(score<min){
                        answer.clear();
                        answer.add(i);
                        min=score;
                        break;
                    }else if(score==min){
                        answer.add(i);
                        break;
                    }
                }
                score++;
                int qsize=q.size();
                for(int j=0;j<qsize;j++){
                int current=q.poll();
                for(int people:friends[current]){
                    if(!Visited[people]){
                        Visited[people]=true;
                        count++;
                        q.add(people);
                    }
                }

            }}
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(answer.size()).append("\n");
        while(!answer.isEmpty()){
            sb.append(answer.poll()).append(" ");
        }
        System.out.println(sb);
        }
    }





