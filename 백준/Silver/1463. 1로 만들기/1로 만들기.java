

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
    //1 0
    //2 1
    //3 1
    //4 2
    //5 3
    //6 2
    //7 3
    //8 3
    //9 2
    //10 3
    //11
    static int N;
    static int C;
    static int answer=Integer.MAX_VALUE;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp=new int[N+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        dp[1]=0;

        for(int i=2;i<=N;i++){
            dp[i]=dp[i-1]+1;
            if(i%3==0){
                dp[i]=Math.min(dp[i],dp[i/3]+1);
            }
            if(i%2==0){
                dp[i]=Math.min(dp[i],dp[i/2]+1);
            }

        }
        System.out.println(dp[N]);

    }

}










