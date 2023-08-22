
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr=new int[N+1];
        long[] dp=new long[N+1];
        for(int i=1;i<=N;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        if(N==1){
            System.out.println(arr[1]);
            return;
        }
        if(N==2){
            System.out.println(arr[1]+arr[2]);
            return;
        }
        
        dp[1]=arr[1];
        dp[2]=arr[1]+arr[2];
        // 6 10 13 9 8 1
        // 6 16 16 25 33 33
        long answer=dp[2];
        for(int i=3;i<=N;i++){
            dp[i]=Math.max(dp[i-3]+arr[i-1]+arr[i],Math.max(dp[i-2]+arr[i],dp[i-1]));
            answer=Math.max(answer,dp[i]);
            //100 100 1 1 100 100
            //1     2  3 4 5   6
            //2-3-5
            //1-2-5
            //1-2-4-5
        }
        //굳이!!!!! 맨마지막으로가는게목표가아님!!


        System.out.println(answer);

    }
}



