
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

class Main {
    static int D;
    static int P;
    static  int[][] pipes;

    public static void main(String[] args) throws IOException{
    //1~m 까지 n개의숫 , 각숫자는 이전에 고른숫자의 최소2개
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        pipes=new int[P][2];
        int[] dp=new int[D+1];
        for(int i=0;i<P;i++){
            st = new StringTokenizer(br.readLine());
            pipes[i][0] = Integer.parseInt(st.nextToken());
            pipes[i][1] = Integer.parseInt(st.nextToken());
        }
        dp[0]=987654321;
        for(int i=0;i<P;i++){
            for(int j=D;j>=pipes[i][0];j--){
                dp[j]=Math.max(dp[j],Math.min(dp[j-pipes[i][0]],pipes[i][1]));
            }

        }
        System.out.println(dp[D]);












    }








}






