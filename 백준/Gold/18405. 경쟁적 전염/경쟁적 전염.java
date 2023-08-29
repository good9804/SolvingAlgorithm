
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

class Main {
    static int N;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int[][] pan=new int[N+1][N+1];
        int K = Integer.parseInt(st.nextToken());
        Queue<Point>[] virus=new LinkedList[K+1];
        for(int i=1;i<=K;i++){
            virus[i]=new LinkedList<>();
        }
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                int temp = Integer.parseInt(st.nextToken());
                pan[i][j]=temp;
                if(temp>0){
                    virus[temp].add(new Point(i,j));
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());


        int count=0;
        while(count<S){
            count++;
            for(int i=1;i< virus.length;i++){
                Queue<Point> tempQ = new LinkedList<>();

                int vsize=virus[i].size();
                for(int j=0;j<vsize;j++){
                    Point p=virus[i].poll();
                    int isnot=0;
                        for(int k=0;k<4;k++){
                            int tempx=p.x+dx[k];
                            int tempy=p.y+dy[k];
                            if(isRange(tempx,tempy)&&pan[tempx][tempy]==0){
                                pan[tempx][tempy]=i;
                                virus[i].add(new Point(tempx,tempy));
                            }

                        }

                    }

                tempQ.clear();

                }

        }
        System.out.println(pan[X][Y]);

        }
    static boolean isRange(int x,int y){
        return x>0&&x<=N&&y>0&&y<=N;
    }

}
class Point{
    int x;
    int y;
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }
}


