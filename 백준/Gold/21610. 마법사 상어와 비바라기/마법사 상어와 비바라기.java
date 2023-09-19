
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;
import java.util.regex.Pattern;

class Main {
    static int size;
    static int order;
    static int[][] pan;
    static int[] dx={-1,-1,1,1};
    static int[] dy={-1,1,-1,1};
    static boolean[][] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        order = Integer.parseInt(st.nextToken());
        pan=new int[size+1][size+1];
        int sum=0;
        for(int i=1;i<=size;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=size;j++){
                int temp=Integer.parseInt(st.nextToken());
                pan[i][j]=temp;
                sum+=temp;
            }
        }
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(size,1));
        q.add(new Point(size,2));
        q.add(new Point(size-1,1));
        q.add(new Point(size-1,2));
        Queue<Point> q2 = new LinkedList<>();
        for(int i=0;i<order;i++){
            st=new StringTokenizer(br.readLine());
            checked=new boolean[size+1][size+1];
            int direction = Integer.parseInt(st.nextToken());
            int count=Integer.parseInt(st.nextToken())%size;

            if(direction==1){
                while(!q.isEmpty()){
                    sum++;
                    Point p=q.poll();
                    int x=p.x;
                    int y=p.y;
                    if(y-count>=1){
                        pan[x][y-count]+=1;
                        q2.add(new Point(x,y-count));
                        checked[x][y-count]=true;
                    }else {pan[x][y-count+size]+=1;
                        q2.add(new Point(x,y-count+size));
                        checked[x][y-count+size]=true;}
                } }
            else if(direction==2){
                while(!q.isEmpty()){
                    sum++;
                    Point p=q.poll();
                    int x=p.x;
                    int y=p.y;
                    if(x-count>=1&&y-count>=1){
                        pan[x-count][y-count]+=1;
                        q2.add(new Point(x-count,y-count));
                        checked[x-count][y-count]=true;
                    }else if(x-count<1&&y-count>=1){
                        pan[x-count+size][y-count]+=1;
                        q2.add(new Point(x-count+size,y-count));
                        checked[x-count+size][y-count]=true;
                    }
                    else if(x-count>=1&&y-count<1){
                        pan[x-count][y-count+size]+=1;
                        q2.add(new Point(x-count,y-count+size));
                        checked[x-count][y-count+size]=true;
                    }
                    else{
                        pan[x-count+size][y-count+size]+=1;
                        q2.add(new Point(x-count+size,y-count+size));
                        checked[x-count+size][y-count+size]=true;
                    }
                }
            }
            else if(direction==3){
                while(!q.isEmpty()){
                    sum++;
                    Point p=q.poll();
                    int x=p.x;
                    int y=p.y;
                    if(x-count>=1){
                        pan[x-count][y]+=1;
                        q2.add(new Point(x-count,y));
                        checked[x-count][y]=true;
                    }else {pan[x-count+size][y]+=1;
                        q2.add(new Point(x-count+size,y));
                    checked[x-count+size][y]=true;}
                }
            }
            else if(direction==4){
                while(!q.isEmpty()){
                    sum++;
                    Point p=q.poll();
                    int x=p.x;
                    int y=p.y;
                    if(x-count>=1&&y+count<=size){
                        pan[x-count][y+count]+=1;
                        q2.add(new Point(x-count,y+count));
                        checked[x-count][y+count]=true;
                    }
                    else if(x-count<1&&y+count<=size){
                        pan[x-count+size][y+count]+=1;
                        q2.add(new Point(x-count+size,y+count));
                        checked[x-count+size][y+count]=true;
                    }
                    else if(x-count>=1&&y+count>size){
                        pan[x-count][y+count-size]+=1;
                        q2.add(new Point(x-count,y+count-size));
                        checked[x-count][y+count-size]=true;
                    }
                    else {
                        pan[x-count+size][y+count-size]+=1;
                        q2.add(new Point(x-count+size,y+count-size));
                        checked[x-count+size][y+count-size]=true;
                    }
                }
            }
            else if(direction==5){
                while(!q.isEmpty()){
                    sum++;
                    Point p=q.poll();
                    int x=p.x;
                    int y=p.y;
                    if(y+count<=size){
                        pan[x][y+count]+=1;
                        q2.add(new Point(x,y+count));
                        checked[x][y+count]=true;
                    }else {pan[x][y+count-size]+=1;
                    q2.add(new Point(x,y+count-size));
                        checked[x][y+count-size]=true;}
                }
            }
            else if(direction==6){
                while(!q.isEmpty()){
                    sum++;
                    Point p=q.poll();
                    int x=p.x;
                    int y=p.y;
                    if(x+count<=size&&y+count<=size){
                        pan[x+count][y+count]+=1;
                        q2.add(new Point(x+count,y+count));
                        checked[x+count][y+count]=true;
                    }
                    else if(x+count>size&&y+count<=size){
                        pan[x+count-size][y+count]+=1;
                        q2.add(new Point(x+count-size,y+count));
                        checked[x+count-size][y+count]=true;
                    }
                    else if(x+count<=size&&y+count>size){
                        pan[x+count][y+count-size]+=1;
                        q2.add(new Point(x+count,y+count-size));
                        checked[x+count][y+count-size]=true;
                    }
                    else{
                        pan[x+count-size][y+count-size]+=1;
                        q2.add(new Point(x+count-size,y+count-size));
                        checked[x+count-size][y+count-size]=true;
                    }
                }
            }
            else if(direction==7){
                while(!q.isEmpty()){
                    sum++;
                    Point p=q.poll();
                    int x=p.x;
                    int y=p.y;
                    if(x+count<=size){
                        pan[x+count][y]+=1;
                        q2.add(new Point(x+count,y));
                        checked[x+count][y]=true;
                    }else {pan[x+count-size][y]+=1;
                    q2.add(new Point(x+count-size,y));
                        checked[x+count-size][y]=true;}
                }
            }
            else{
                while(!q.isEmpty()){
                    sum++;
                Point p=q.poll();
                int x=p.x;
                int y=p.y;
                if(x+count<=size&&y-count>=1){
                    pan[x+count][y-count]+=1;
                    q2.add(new Point(x+count,y-count));
                    checked[x+count][y-count]=true;
                }
                else if(x+count>size&&y-count>=1){
                    pan[x+count-size][y-count]+=1;
                    q2.add(new Point(x+count-size,y-count));
                    checked[x+count-size][y-count]=true;
                }
                else if(x+count<=size&&y-count<1){
                    pan[x+count][y-count+size]+=1;
                    q2.add(new Point(x+count,y-count+size));
                    checked[x+count][y-count+size]=true;
                }
                else{
                    pan[x+count-size][y-count+size]+=1;
                    q2.add(new Point(x+count-size,y-count+size));
                    checked[x+count-size][y-count+size]=true;
                }
            }}


            while(!q2.isEmpty()){
                Point p=q2.poll();
                int x=p.x;
                int y=p.y;
                for(int k=0;k<4;k++){

                    int xtemp=x+dx[k];
                    int ytemp=y+dy[k];
                    if(xtemp>=1&&xtemp<=size&&ytemp>=1&&ytemp<=size&&pan[xtemp][ytemp]>0){
                        sum++;
                        pan[x][y]+=1;
                    }
                }
            }
            for(int a=1;a<=size;a++){
                for(int b=1;b<=size;b++){
                    if(pan[a][b]>=2&&!checked[a][b]){
                        pan[a][b]-=2;
                        q.add(new Point(a,b));
                        sum-=2;
                    }
                }
            }

        }
        System.out.println(sum);

    }
}






