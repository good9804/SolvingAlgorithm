import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {
    static int row;
    static int col;
    static int[][] pan;
    static int[][] result;
    static boolean[][] visited;
    static int answer;
    static boolean infi;
    static int dx[]= {0,1,0,-1};
    static int dy[]= {1,0,-1,0};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s=br.readLine().split(" ");
        row = Integer.parseInt(s[0]);
        col = Integer.parseInt(s[1]);
        pan = new int[row][col];
        result=new int[row][col];
        visited=new boolean[row][col];
        infi=false;

        for(int i=0;i<row;i++){
            String[] k=br.readLine().split("");
            for(int j=0;j<col;j++){
                if(k[j].equals("H")){
                    pan[i][j]=0;
                }
                else pan[i][j] = Integer.parseInt(k[j]);
            }
        }

        answer=0;
        visited[0][0] = true;
        dfs(0,0,1);

        if(infi==true){
            System.out.println(-1);
            return;
        }

        System.out.println(answer);



    }
    public static boolean isRange(int x,int y){
        if(x>=0&&x<row&&y>=0&&y<col){
            return true;
        }   else return false;
    }
    public static void dfs(int x,int y,int count){
        if(infi){
            return;
        }
        int num=pan[x][y];
        if(answer<count){
            answer=count;}

        result[x][y]=count;
        for(int i=0;i<4;i++){
            int xx=x+dx[i]*num;
            int yy=y+dy[i]*num;
            if(isRange(xx,yy)&&pan[xx][yy]!=0){
                if(visited[xx][yy]){
                    infi=true;
                    return;
                }
                if(result[xx][yy]>count){
                   continue;
            }
                visited[xx][yy]=true;
                dfs(xx,yy,count+1);
                visited[xx][yy]=false;
        }

    }
}}


