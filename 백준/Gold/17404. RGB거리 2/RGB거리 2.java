
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
   static boolean[][] isConnect;



    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] costs=new int[N+1][3];
        int[][] dp=new int[N+1][3];
        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer=Integer.MAX_VALUE;
        for(int start=0;start<3;start++){
            for(int j=0;j<3;j++){
                if(start==j){
                    dp[1][start]=costs[1][start];
                }else dp[1][j]=98765432;
            }
        for(int i=2;i<=N;i++) {
            dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+costs[i][0];
            dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+costs[i][1];
            dp[i][2]=Math.min(dp[i-1][1],dp[i-1][0])+costs[i][2];

            }

        if(start==0){
            answer=Math.min(Math.min(dp[N][1],dp[N][2]),answer);
        }else if(start==1){
            answer=Math.min(Math.min(dp[N][0],dp[N][2]),answer);
        }
        else{
            answer=Math.min(Math.min(dp[N][0],dp[N][1]),answer);
        }





        }
        System.out.println(answer);





    }




}





