import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int[][] table;
    static boolean[][] isVisited;
    static int row;
    static int col;
    static int[] dx={-2,-2,-1,-1,1,1,2,2};
    static int[] dy={-1,1,-2,2,2,-2,1,-1};
    static boolean[] arr;
    static int max;
    static int size;
    public static void main(String args[]) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int t=0;t<test;t++){
        size=Integer.parseInt(br.readLine());
        table=new int [size][size];
        isVisited=new boolean[size][size];
            StringTokenizer st=new StringTokenizer(br.readLine());
            int startx=Integer.parseInt(st.nextToken());
            int starty=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine());
            int endx=Integer.parseInt(st.nextToken());
            int endy=Integer.parseInt(st.nextToken());
            Queue<Point> q=new LinkedList<>();
            q.add(new Point(startx,starty));
            int count=0;
            while(!q.isEmpty()){
                count++;
                int qsize=q.size();
                for(int k=0;k<qsize;k++){
                    Point p=q.poll();
                    int x=p.x;
                    int y=p.y;
                    if(x==endx&&y==endy){
                        sb.append(count-1).append("\n");
                        break;
                    }
                for(int i=0;i<8;i++){
                    int tempx=x+dx[i];
                    int tempy=y+dy[i];
                   if(isRange(tempx,tempy)&&!isVisited[tempx][tempy]){
                       isVisited[tempx][tempy]=true;
                       q.add(new Point(tempx,tempy));
                   }
                }

            }
            }
        }

        System.out.println(sb);





    }
    static void dfs(int x,int y,int count){



    }
    static boolean isRange(int x,int y){
        return x>=0&&x<size&&y>=0&&y<size;
    }

    }

