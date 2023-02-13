
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {
    static int R;
    static int C;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,-1,0,1};
    static int[][] pan;
    static boolean[][] isVisted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
         C = Integer.parseInt(st.nextToken());
        Queue<Point> q=new LinkedList<>();
        Queue<Point> water=new LinkedList<>();
        pan=new int[R][C];
        isVisted=new boolean[R][C];
        for(int i=0;i<R;i++){
            String[] str=br.readLine().split("");
            for(int j=0;j<C;j++){

                if(str[j].equals("D")){
               pan[i][j]=0;}
                else if(str[j].equals("S")){
                        pan[i][j]=1;
                        isVisted[i][j]=true;
                        q.add(new Point(i,j));
                }else if(str[j].equals(".")){
                    pan[i][j]=2;
                }
                else if(str[j].equals("X")){
                    pan[i][j]=3;
                }
                else{
                    pan[i][j]=4;
                    water.add(new Point(i,j));
                }
            }
        }
        int count=0;
        while(true){
        int watersize= water.size();
        for(int k=0;k<watersize;k++){
            Point p=water.poll();
            for(int i=0;i<4;i++){
                int x=p.x+dx[i];
                int y=p.y+dy[i];
                if(isRange(x,y)&&pan[x][y]!=3&&pan[x][y]!=0&&pan[x][y]!=4){
                    pan[x][y]=4;
                    water.add(new Point(x,y));
                }
            }
        }
        count++;
        int qsize= q.size();
        for(int k=0;k<qsize;k++){
            Point p=q.poll();

            if(pan[p.x][p.y]==0){
                System.out.println(count-1);
            return;}
            for(int i=0;i<4;i++){

                int x=p.x+dx[i];
                int y=p.y+dy[i];
                if(isRange(x,y)&&pan[x][y]!=4&&pan[x][y]!=3&&!isVisted[x][y]){
                    isVisted[x][y]=true;
                    q.add(new Point(x,y));
                }
            }
        }
        if(q.size()==0){
            System.out.println("KAKTUS"); return;
        }

        }





    }

static boolean isRange(int x,int y){
    return x>=0&&x<=R-1&&y>=0&&y<=C-1;

}
}




