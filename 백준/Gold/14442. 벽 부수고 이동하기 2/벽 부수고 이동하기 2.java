
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

class Main {
    static int N;
    static int M;
    static int K;
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
        M  = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        boolean[][] pan=new boolean[N][M];
        for(int i=0;i<N;i++){
            String[] str=br.readLine().split("");
            for(int j=0;j<M;j++){
                if(Integer.parseInt(str[j])>0){
                    pan[i][j]=true;
                }
            }
        }
        if(N==1&&M==1){
            System.out.println(1);
            return;
        }
        Queue<Point> q=new LinkedList<>();
        q.add(new Point(0,0,0));
        boolean[][][] isVisited=new boolean[K+1][N][M];
        isVisited[0][0][0]=true;
        int count=0;
        while (!q.isEmpty()){
            count++;
            int qsize = q.size();
            for(int i=0;i<qsize;i++){
                Point cur=q.poll();
                for(int j=0;j<4;j++){
                int tempx=cur.x+dx[j];
                    int tempy=cur.y+dy[j];
                    if(isRange(tempx,tempy)&&pan[tempx][tempy]&&cur.broke+1<=K){
                if(!isVisited[cur.broke+1][tempx][tempy]){
                        if(tempx==N-1&&tempy==M-1){
                            System.out.println(count+1);
                            return;
                        }
                        isVisited[cur.broke+1][tempx][tempy]=true;
                        q.add(new Point(tempx,tempy,cur.broke+1));
                        continue;
                    }
                    }
                    else if(isRange(tempx,tempy)&&!pan[tempx][tempy]&&!isVisited[cur.broke][tempx][tempy]){
                        if(tempx==N-1&&tempy==M-1){
                            System.out.println(count+1);
                            return;
                        }
                        isVisited[cur.broke][tempx][tempy]=true;
                        q.add(new Point(tempx,tempy,cur.broke));
                    }
                }
                }
            }


        System.out.println(-1);



    }static boolean isRange(int x,int y){
        return x>=0&&x<N&&y>=0&&y<M;
    }



}
class Point{
    int x;
    int y;
    int broke;
    public Point(int x,int y,int broke){
        this.x=x;
        this.y=y;
        this.broke=broke;
    }
}




