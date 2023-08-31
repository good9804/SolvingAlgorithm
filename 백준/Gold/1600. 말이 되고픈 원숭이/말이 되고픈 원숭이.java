
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

class Main {
    static int row;
    static int col;

    static boolean[][][] isVisisted;
    static boolean[][] pan;
    static int[][][] dp;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int[] horsedx={-1,-2,1,2,-1,-2,1,2};
    static int[] horsedy={-2,-1,-2,-1,2,1,2,1};
    static int answer=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        isVisisted=new boolean[K+1][row+1][col+1];
        pan=new boolean[row+1][col+1];
        for(int i=1;i<=row;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=col;j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp==1){
                    pan[i][j]=true;//장애물
                }
            }
        }
        isVisisted[K][1][1]=true;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1,1,K));
        int count=0;
        while (!q.isEmpty()){
            count++;
            int qsize = q.size();
            for(int s=0;s<qsize;s++){
                Node cur=q.poll();
                if(cur.x==row&&cur.y==col){
                    System.out.println(count-1);
                    return;
                }
                if(cur.K>0){
                    for(int i=0;i<8;i++){
                        int tempx=cur.x+horsedx[i];
                        int tempy=cur.y+horsedy[i];
                        if(isRange(tempx,tempy)&&!isVisisted[cur.K-1][tempx][tempy]&&!pan[tempx][tempy]){
                            isVisisted[cur.K-1][tempx][tempy]=true;
                            q.add(new Node(tempx,tempy,cur.K-1));
                        }
                    }
                }

                for(int i=0;i<4;i++){
                    int tempx=cur.x+dx[i];
                    int tempy=cur.y+dy[i];
                    if(isRange(tempx,tempy)&&!isVisisted[cur.K][tempx][tempy]&&!pan[tempx][tempy]){
                        isVisisted[cur.K][tempx][tempy]=true;
                        q.add(new Node(tempx,tempy,cur.K));
                    }
                }

            }
        }
        System.out.println(-1);




    }
    static boolean isRange(int x,int y){
        return x>=1&&x<=row&&y>=1&&y<=col;
    }


}
class Node{
    int x;
    int y;
    int K;
    public Node(int x,int y,int K){
        this.x=x;
        this.y=y;
        this.K=K;
    }
}






