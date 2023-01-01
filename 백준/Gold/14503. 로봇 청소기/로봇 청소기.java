import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {
    static int N;
    static int M;
    static int answer;
    static int[][] pan;
    static boolean[][] isChecked;
    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        answer = 1;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        pan = new int[N][M];
        isChecked=new boolean[N][M];
        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                pan[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        isChecked[startX][startY]=true;
        bfs(startX, startY, dir,0);
        System.out.println(answer);


    }

    public static void bfs(int x, int y, int dir, int temp) {
        if(temp==4){
            if(dir==0){
                if(pan[x+1][y]==0){
                    if(!isChecked[x+1][y]){
                    isChecked[x+1][y] = true;
                    answer++;

                }
                    bfs(x+1,y,dir,0);
            }else {return;}
            }
            else if(dir==1){
                if(pan[x][y-1]==0){
                        if(!isChecked[x][y-1]){
                            isChecked[x][y-1] = true;
                            answer++;

                        }
                    bfs(x,y-1,dir,0);
                    }else {return;}
            }
            else if(dir==2){

                if(pan[x-1][y]==0){
                    if(!isChecked[x-1][y]){
                        isChecked[x-1][y] = true;
                        answer++;

                    }
                    bfs(x-1,y,dir,0);
                }else {return;}
            }
            else{
                if(pan[x][y+1]==0){
                    if(!isChecked[x][y+1]){
                        isChecked[x][y+1] = true;
                        answer++;

                    }
                    bfs(x,y+1,dir,0);
                }else {return;}

            }
        }
        else{

        if (dir == 0) {
            if (isRange(x,y-1)&&!isChecked[x][y-1] && pan[x][y - 1] == 0) {
                isChecked[x][y-1] = true;
                answer++;
                bfs(x, y - 1, 3, 0);
            } else if (isChecked[x][y-1] || pan[x][y - 1] > 0) {
                bfs(x, y, 3, temp + 1);
            }
        } else if (dir == 1) {

            if (isRange(x-1,y)&&!isChecked[x-1][y] && pan[x-1][y ] == 0) {
                isChecked[x-1][y] = true;
                answer++;
                bfs(x-1, y , 0, 0);
            } else if (isChecked[x-1][y] || pan[x-1][y] > 0) {
                bfs(x, y, 0, temp + 1);
            }

        } else if (dir == 2) {
            if (isRange(x,y+1)&&!isChecked[x][y+1] && pan[x][y + 1] == 0) {
                isChecked[x][y+1] = true;
                answer++;
                bfs(x, y + 1, 1, 0);
            } else if (isChecked[x][y+1] || pan[x][y + 1] > 0) {
                bfs(x, y, 1, temp + 1);
            }
        }else {
            if (isRange(x+1,y)&&!isChecked[x+1][y] && pan[x+1][y] == 0) {
                isChecked[x+1][y] = true;
                answer++;
                bfs(x+1, y , 2, 0);
            } else if (isChecked[x+1][y] || pan[x+1][y] > 0) {
                bfs(x, y, 2, temp + 1);
            }
        }}
    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}