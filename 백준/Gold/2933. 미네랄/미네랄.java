
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import java.util.*;

class Main {
    static int row;
    static int col;
    static int[][] pan;
    static int[] dx={-1,0,0,1};
    static  int[] dy={0,-1,1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        pan=new int[row+1][col+1];
        for(int i=1;i<=row;i++){
            String[] str=br.readLine().split("");
            for(int j=1;j<=col;j++){
                if(str[j-1].equals(".")){
                    pan[i][j]=0;
                }else pan[i][j]=1;
            }
        }

        int count=Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        boolean left=true;
        for(int i=0;i<count;i++){
            int height = row-Integer.parseInt(st.nextToken())+1;
            if(left){
                attack(height,left);
                left=false;
            }else{
                attack(height,left);
                left=true;
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                if(pan[i][j]==0){
                    sb.append(".");
                }else sb.append("x");
            }
            if(i!=row){
            sb.append("\n");}
        }
        System.out.print(sb);

    }
    static void attack(int height,boolean left){
        boolean[][] Visited=new boolean[row+1][col+1];
        Queue<Point> q=new LinkedList<>();
        int[] term= new int[col+1];
        if(left){
            for(int i=1;i<=col;i++){
                if(pan[height][i]==1){
                    Visited[height][i]=true;
                    pan[height][i]=0;
                    int[] prev=new int[4];
                    for(int j=0;j<4;j++){
                        int tempx=height+dx[j];
                        int tempy=i+dy[j];
                        if(isRange(tempx,tempy)&&!Visited[tempx][tempy]&&pan[tempx][tempy]==1){
                            prev[j]=1;
                        }
                    }
                    for(int j=0;j<4;j++){
                        int tempx=height+dx[j];
                        int tempy=i+dy[j];

                        HashSet<Point> downq = new HashSet<>();
                        if(isRange(tempx,tempy)&&!Visited[tempx][tempy]&&pan[tempx][tempy]==1&&prev[j]==1){
                            q.add(new Point(tempx,tempy));downq.add(new Point(tempx,tempy));
                        }else{continue;}
                        boolean air=false;

                        while(!q.isEmpty()){
                            Point p = q.poll();
                            for(int k=0;k<4;k++){
                                int tempxx=p.x+dx[k];
                                int tempyy=p.y+dy[k];
                                if(isRange(tempxx,tempyy)&&!Visited[tempxx][tempyy]&&pan[tempxx][tempyy]==1){

                                    if(tempxx==row){air=true;}
                                    Visited[tempxx][tempyy]=true;
                                    q.add(new Point(tempxx, tempyy));
                                    downq.add(new Point(tempxx,tempyy));
                                }
                            }
                        }
                        if(!air){

                            Iterator<Point> iter= downq.iterator();
                            int min=101;
                            while(iter.hasNext()){
                                Point p=iter.next();
                                pan[p.x][p.y]=0;

                                for(int k=p.x+1;k<=row;k++){
                                    if(pan[k][p.y]==1&&!downq.contains(new Point(k,p.y))){
                                        min=Math.min(min,k-p.x-1);
                                        break;
                                    }
                                }
                                min=Math.min(min,row-p.x);
                            }
                            Iterator<Point> iter2= downq.iterator();
                            while(iter2.hasNext()){
                                Point p=iter2.next();
                                pan[p.x+min][p.y]=1;
                            }
                            downq.clear();
                            }
                        downq.clear();

                    }
                    return;
                }
            }}
        else{
            for(int i=col;i>=1;i--){
                if(pan[height][i]==1){
                    Visited[height][i]=true;
                    pan[height][i]=0;
                    int[] prev=new int[4];
                    for(int j=0;j<4;j++){
                        int tempx=height+dx[j];
                        int tempy=i+dy[j];
                        if(isRange(tempx,tempy)&&!Visited[tempx][tempy]&&pan[tempx][tempy]==1){
                            prev[j]=1;
                        }
                    }
                    for(int j=0;j<4;j++){
                        int tempx=height+dx[j];
                        int tempy=i+dy[j];

                        HashSet<Point> downq = new HashSet<>();
                        if(isRange(tempx,tempy)&&!Visited[tempx][tempy]&&pan[tempx][tempy]==1&&prev[j]==1){
                            q.add(new Point(tempx,tempy));downq.add(new Point(tempx,tempy));
                        }else{continue;}
                        boolean air=false;

                        while(!q.isEmpty()){
                            Point p = q.poll();
                            for(int k=0;k<4;k++){
                                int tempxx=p.x+dx[k];
                                int tempyy=p.y+dy[k];
                                if(isRange(tempxx,tempyy)&&!Visited[tempxx][tempyy]&&pan[tempxx][tempyy]==1){

                                    if(tempxx==row){air=true;}
                                    Visited[tempxx][tempyy]=true;
                                    q.add(new Point(tempxx, tempyy));
                                    downq.add(new Point(tempxx,tempyy));
                                }
                            }
                        }
                        if(!air){

                            Iterator<Point> iter= downq.iterator();
                            int min=101;
                            while(iter.hasNext()){
                                Point p=iter.next();
                                pan[p.x][p.y]=0;

                                for(int k=p.x+1;k<=row;k++){
                                    if(pan[k][p.y]==1&&!downq.contains(new Point(k,p.y))){
                                        min=Math.min(min,k-p.x-1);
                                        break;
                                    }
                                }
                                min=Math.min(min,row-p.x);
                            }
                            Iterator<Point> iter2= downq.iterator();
                            while(iter2.hasNext()){
                                Point p=iter2.next();
                                pan[p.x+min][p.y]=1;
                            }
                            downq.clear();
                        }
                        downq.clear();



                    }
                    return;
                }
            }
        }
    }
    static boolean isRange(int x,int y){
        return x>=1&&x<=row&&y>=1&&y<=col;
    }

    }








