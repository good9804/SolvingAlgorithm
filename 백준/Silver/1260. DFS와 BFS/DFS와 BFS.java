import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
    static boolean[][] graph;
    static boolean[] isChecked;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();
        int size=Integer.parseInt(st.nextToken());
        graph=new boolean[size+1][size+1];
        isChecked=new boolean[size+1];
        int side=Integer.parseInt(st.nextToken());
        int start=Integer.parseInt(st.nextToken());
        for(int i=0;i<side;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            graph[x][y]=true;
            graph[y][x]=true;

        }
        isChecked[start]=true;
        Stack<Integer> s=new Stack<>();
        s.push(start);
        sb.append(start).append(" ");
        while(!s.isEmpty()){
            int ssize=s.size();
            int current=s.pop();
            if(!isChecked[current]){
            sb.append(current).append(" ");}

            isChecked[current]=true;

                for(int index=size;index>=1;index--){
                    if(graph[current][index]&&!isChecked[index]){

                        s.push(index);
                    }
                }
            }


        System.out.println(sb.substring(0,sb.length()-1));
        sb.setLength(0);
        Arrays.fill(isChecked,false);
        isChecked[start]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        sb.append(start).append(" ");
        while(!q.isEmpty()){
            int qsize=q.size();
            int current=q.poll();


            for(int k=0;k<qsize;k++){
                for(int index=1;index<=size;index++){
                    if(graph[current][index]&&!isChecked[index]){
                        isChecked[index]=true;
                        q.add(index);
                        sb.append(index).append(" ");
                    }
                }
            }

        }
        System.out.println(sb.substring(0,sb.length()-1));

    }
    
}