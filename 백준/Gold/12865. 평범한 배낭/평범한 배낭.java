
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import java.util.*;

class Main {
    static int N;
    static int K;
    static int[][] items;
    static int[][] dp;
    static int answer=Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        items=new int[N][K+1];
        dp=new int[N+1][K+1];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            items[i][0]=Integer.parseInt(st.nextToken());
            items[i][1]=Integer.parseInt(st.nextToken());
        }
       for(int i=1;i<=N;i++){
           findAnswer(i);
       }
        System.out.println(dp[N][K]);

    }

    static void findAnswer(int n){
        for(int k=1;k<=K;k++){
        if(k-items[n-1][0]>=0){
        dp[n][k]=Math.max(dp[n-1][k],dp[n-1][k-items[n-1][0]]+items[n-1][1]);}
        else dp[n][k]=dp[n-1][k];}
    }


    }










