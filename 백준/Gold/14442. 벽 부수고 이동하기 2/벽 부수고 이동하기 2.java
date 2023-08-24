
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
class Main {
    static int N;
    static int M;
    static int K;
    static int[][] pan;
    static boolean[][][] PanChecked;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int answer=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        pan=new int[N][M];
        PanChecked=new boolean[N][M][K+1];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                pan[i][j]=str.charAt(j)-'0';
            }
        }
        bfs();
        if(answer==Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(answer);

}
static void bfs(){
        Queue<Point> q=new LinkedList<>();
        q.add(new Point(0,0,1,0));
        PanChecked[0][0][0]=true;
        while(!q.isEmpty()){
                Point cur=q.poll();
                if(cur.x==N-1&&cur.y==M-1){
                    answer= cur.count;
                    return;
                }
            for(int i=0;i<4;i++){
                int tempx=cur.x+dx[i];
                int tempy=cur.y+dy[i];
                if(isRange(tempx,tempy)&&!PanChecked[tempx][tempy][cur.boom]&&pan[tempx][tempy]==0){
                    PanChecked[tempx][tempy][cur.boom]=true;
                    q.add(new Point(tempx,tempy, cur.count+1, cur.boom));
                }else {
                    if(cur.boom<K&&isRange(tempx,tempy)&&!PanChecked[tempx][tempy][cur.boom+1]&&pan[tempx][tempy]==1){

                        PanChecked[tempx][tempy][cur.boom+1]=true;
                        q.add(new Point(tempx,tempy, cur.count+1, cur.boom+1));
                    }

                }

            }
        }



}
static boolean isRange(int x,int y){
        return x>=0&&y>=0&&x<N&&y<M;
}

}
class Point{
    int x;
    int y;
    int count;
    int boom;
    public Point(int x,int y,int count,int boom){
        this.x=x;
        this.y=y;
        this.count=count;
        this.boom=boom;
    }
}