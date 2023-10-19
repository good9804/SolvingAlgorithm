
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

class Main {
    static int N;
    static boolean[][] isConnect;
    static int[][] arr;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int L;
    static int R;
    static int hap=0;
    static ArrayList<HashSet<Point>> points=new ArrayList<>();
    static ArrayList<Integer> haps=new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
         L = Integer.parseInt(st.nextToken());
         R = Integer.parseInt(st.nextToken());
        arr=new int[N][N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }


        int day=0;
        while(true){
            isConnect=new boolean[N][N];
            points.clear();
            hap=0;
            haps.clear();
            bfs();

            if(points.size()==0){
                System.out.println(day);
                return;
            }
            day++;
            for(int i=0;i<points.size();i++){
                HashSet<Point> temps=points.get(i);
                int hap=haps.get(i);
                int people= hap/temps.size();
                for(Point cur:temps){
                    arr[cur.x][cur.y]=people;
                }
            }




        }

    }
    static void bfs(){
        Queue<Point> q=new LinkedList<>();
        boolean[][] isVisited=new boolean[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!isVisited[i][j]){
                    isVisited[i][j]=true;

                    hap=arr[i][j];
                    HashSet<Point> temps=new HashSet<>();
                    temps.add(new Point(i,j));
                    q.add(new Point(i,j));

                    while(!q.isEmpty()){
                        Point cur=q.poll();
                        for(int dir=0;dir<4;dir++){
                            int tempx=cur.x+dx[dir];
                            int tempy=cur.y+dy[dir];
                            int chai=0;
                            if(isRange(tempx,tempy)){
                            chai=Math.abs(arr[tempx][tempy]-arr[cur.x][cur.y]);}else continue;
                            if(!isVisited[tempx][tempy]&&chai>=L&&chai<=R){

                                isVisited[tempx][tempy]=true;
                                temps.add(new Point(tempx,tempy));
                                q.add(new Point(tempx,tempy));
                                hap+=arr[tempx][tempy];
                            }
                        }




                    }
                    if(temps.size()>1){
                        points.add(temps);
                        haps.add(hap);
                    }

                }

            }
        }



    }
    static boolean isRange(int x,int y){
        return x>=0&&x<N&&y>=0&&y<N;
    }
}




