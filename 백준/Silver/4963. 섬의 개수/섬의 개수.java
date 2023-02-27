import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int[][] table;
    static boolean[][] isVisted;
    static int row;
    static int col;
    static int[] dx={-1,1,0,0,-1,-1,1,1};
    static int[] dy={0,0,-1,1,1,-1,1,-1};
    public static void main(String args[]) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        while(true){
            StringTokenizer st=new StringTokenizer(br.readLine());
            col=Integer.parseInt(st.nextToken());
            row=Integer.parseInt(st.nextToken());
            isVisted=new boolean[row+1][col+1];
            if(col+row==0){
                System.out.println(sb);
                return;
            }
            table=new int[row+1][col+1];
            Queue<Point> q=new LinkedList<>();
            Queue<Point> q2=new LinkedList<>();
            for(int i=1;i<=row;i++){
                st=new StringTokenizer(br.readLine());
                for(int j=1;j<=col;j++){
                    int temp=Integer.parseInt(st.nextToken());
                    table[i][j]=temp;
                    if(temp==1){
                        q.add(new Point(i,j));
                    }
                }
            }
            int count=0;
            while(!q.isEmpty()){

                Point p=q.poll();
                q2.add(p);
                int x=p.x;
                int y=p.y;
                if(isVisted[x][y]){
                    continue;
                }
                count++;
                int q2size=q2.size();
                while(!q2.isEmpty()){
                   Point p2= q2.poll();
                    int x2=p2.x;
                    int y2=p2.y;
                for(int i=0;i<8;i++){
                    int tempx=x2+dx[i];
                    int tempy=y2+dy[i];
                    if(isRange(tempx,tempy)&&!isVisted[tempx][tempy]&&table[tempx][tempy]>0){
                        q2.add(new Point(tempx,tempy));
                        isVisted[tempx][tempy]=true;
                    }
                }
                }






            }
            sb.append(count).append("\n");









        }



    }
    static boolean isRange(int x,int y){
        return x>=1&&x<=row&&y>=1&&y<=col;
    }

    }

