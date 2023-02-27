import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int[][] table;
    static int[][] dp;
    static int row;
    static int col;
    static int[] dx={-1,1,0,0,-1,-1,1,1};
    static int[] dy={0,0,-1,1,1,-1,1,-1};
    static boolean[] arr;
    static int max;
    public static void main(String args[]) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        row=Integer.parseInt(st.nextToken());
        col=Integer.parseInt(st.nextToken());


        table=new int[row+1][col+1];
        dp=new int[row+1][col+1];
        arr=new boolean[28];
        for(int i=1;i<=row;i++){
            String[] str=br.readLine().split("");
            for(int j=1;j<=col;j++){
                table[i][j]=str[j-1].charAt(0)-65;
            }
        }
        arr[table[1][1]]=true;
        max=0;
        dfs(1,1,1);
        System.out.println(max);



    }
    static void dfs(int x,int y,int count){
        if(max<count){
            max=count;
        }
        if(dp[x][y]<count){
            dp[x][y]=count;
        }
        for(int i=0;i<4;i++){
            int tempx=x+dx[i];
            int tempy=y+dy[i];
            if(isRange(tempx,tempy)&&!arr[table[tempx][tempy]]){
                arr[table[tempx][tempy]]=true;
                dfs(tempx,tempy,count+1);
                arr[table[tempx][tempy]]=false;

            }
        }


    }
    static boolean isRange(int x,int y){
        return x>=1&&x<=row&&y>=1&&y<=col;
    }

    }

