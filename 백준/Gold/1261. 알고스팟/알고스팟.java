
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

class Main {
    static int row;
    static int col;

    static boolean[][] isVisisted;
    static boolean[][] pan;
    static int[][][] dp;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int answer=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row  = Integer.parseInt(st.nextToken());
        pan=new boolean[row][col];

        int count=0;
        for(int i=0;i<row;i++){
            String[] strarr=br.readLine().split("");
            for(int j=0;j<col;j++){
                if(Integer.parseInt(strarr[j])==1){
                    count++;
                    pan[i][j]=true;
                }
            }
        }
        isVisisted=new boolean[row][col];
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0,0,0));
        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            if(cur.x==row-1&&cur.y==col-1){
                answer=Math.min(answer,cur.broke);
                System.out.println(answer);
                return;
            }
            for(int i=0;i<4;i++){
                int tempx=cur.x+dx[i];
                int tempy=cur.y+dy[i];
                if(isRange(tempx,tempy)&&!isVisisted[tempx][tempy]){
                    isVisisted[tempx][tempy]=true;
                    if(pan[tempx][tempy]){
                        pq.add(new Point(tempx,tempy,cur.broke+1));
                    }else pq.add(new Point(tempx,tempy,cur.broke));
                }
            }
        }



        System.out.println(answer);



}


static boolean isRange(int x,int y){
        return x>=0&&x<row&&y>=0&&y<col;
}
}
class Point implements Comparable<Point>{
    int x;
    int y;
    int broke;
    public Point(int x,int y,int broke){
        this.x=x;
        this.y=y;
        this.broke=broke;
    }
    @Override
    public int compareTo(Point p){
        return this.broke-p.broke;
    }


}



