
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;
import java.util.regex.Pattern;

class Main {
    static int row;
    static int col;
    static int order;
    static int[][] pan;
    static boolean[][] checked;
    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};

    public static void main(String[] args) throws IOException {
        //공기청정기는 항상 1번열 크기는 두행 차지
        //1초동안 일어나는 일 들
        //1. 미세먼지 확산(동시에) 인접한 네방향,인접한 방향에 공기청정기있으면 X,확산되는 양은 Arc/5,Arc에 남은 양은 Arc-확산된개수*Arc/5
        //2.공기청정기 작동 위쪽의 바람은 반시계방향, 아래쪽 바람은 시계방향,바람이불면 미세먼지가 바람의방향대로 모두한칸씩이동,공기청정기로들어간 미세먼지는 정화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        order = Integer.parseInt(st.nextToken());
        boolean flag = false;
        Point up=new Point(0,0);
        Point down=new Point(0,0);
        pan = new int[row + 1][col + 1];
        int[][] bonus = new int[row + 1][col + 1];
        checked = new boolean[row + 1][col + 1];
        Queue<dust> q = new LinkedList<>();
        for (int i = 1; i <= row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= col; j++) {
                int temp = Integer.parseInt(st.nextToken());
                pan[i][j] = temp;
                if (temp > 0) {
                    q.add(new dust(i, j,temp));
                    checked[i][j] = true;
                }
                if (temp == -1 && !flag) {
                    up = new Point(i, j);
                    down = new Point(i+1, j );
                    flag = true;
                }

            }
        }

        int count =0;

        while (true) {

            if (count == order) {
                int sum = 0;
                for (int i = 1; i <= row; i++) {
                    for(int j=1;j<=col;j++){
                        sum+=pan[i][j];
                    }
                }
                System.out.println(sum+2);
                return;
            }
            int qsize= q.size();

            for(int i=0;i<qsize;i++){
                dust dust = q.poll();
                int x=dust.x;
                int y=dust.y;
                int hap=dust.hap;
                int cnt=0;
                for(int j=0;j<4;j++){

                    int tempx=x+dx[j];
                    int tempy=y+dy[j];

                    if(tempx>=1&&tempx<=row&&tempy>=1&&tempy<=col&&pan[tempx][tempy]!=-1){
                        cnt++;
                        pan[tempx][tempy]+=hap/5;
                    }

                }
                pan[x][y]=pan[x][y]-hap/5*cnt;
            }

            for(int i=up.x-1;i>=2;i--){
                pan[i][1]=pan[i-1][1];
            }
            for(int i=1;i<=col-1;i++){
                pan[1][i]=pan[1][i+1];
            }
            for(int i=1;i<=up.x-1;i++){
                pan[i][col]=pan[i+1][col];
            }
            for(int i=col;i>=3;i--){
                pan[up.x][i]=pan[up.x][i-1];
            }
            pan[up.x][2]=0;
            for(int i=down.x+1;i<=row-1;i++){
                pan[i][1]=pan[i+1][1];
            }
            for(int i=1;i<=col-1;i++){
                pan[row][i]=pan[row][i+1];
            }
            for(int i=row;i>=down.x+1;i--){
                pan[i][col]=pan[i-1][col];
            }
            for(int i=col;i>=3;i--){
                pan[down.x][i]=pan[down.x][i-1];
            }
            pan[down.x][2]=0;




            for(int i=1;i<=row;i++){
                for(int j=1;j<=col;j++){
                    if(pan[i][j]>=5){
                        q.add(new dust(i,j,pan[i][j]));
                    }
                }
            }




            count++;


        }




    }




    }
    class dust{
    int x;
    int y;
    int hap;
    public dust(int x,int y,int hap){
        this.x=x;
        this.y=y;
        this.hap=hap;
    }

}








