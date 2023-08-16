

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;


class Main {
    static int N;
    static int M;
    static BigInteger[][] dp;
    // 1
    //1 2 1
    //1 3 3 1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp=new BigInteger[N+1][N+1];
        dp[1][0]=BigInteger.ONE;
        dp[1][1]=BigInteger.ONE;
        for(int i=2;i<=N;i++){
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    dp[i][j]=BigInteger.ONE;
                    continue;
                }
                dp[i][j]=dp[i-1][j-1].add(dp[i-1][j]);
            }
        }
        System.out.println(dp[N][M]);

    }}












