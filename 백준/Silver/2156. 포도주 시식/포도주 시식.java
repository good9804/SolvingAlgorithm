
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.List;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //연속으로 놓여있는 3잔못마심
        //가장 많은양의 포도주
        //1 2 3 4 5
        // 4로 올수잇는 경우의수 1 2 4,34 1 3 4

        int[] arr=new int[N+1];
        long[] dp=new long[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        long answer=0;
        dp[1]=arr[1];
        answer=arr[1];
        if(N>=2){
        dp[2]=arr[1]+arr[2];
        answer=(int)dp[2];}

        for(int i=3;i<=N;i++){
            dp[i]=Math.max(Math.max(dp[i-2]+arr[i],dp[i-1]),dp[i-3]+arr[i-1]+arr[i]);
            answer=Math.max(answer,dp[i]);


        }
        System.out.println(answer);



    }
}




