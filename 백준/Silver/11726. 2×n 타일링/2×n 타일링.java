

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
    static int T;
    static int answer=Integer.MAX_VALUE;
    static int[] dp;
    static int mod=10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //2 * n
        //1  -> 1
        //2 -> 2
        //3 ->3
        //4 ->5
        //5->8
        //6->13
        //7->21
        //8->34
        //9 ->55
        N = Integer.parseInt(br.readLine());
        if(N==1){
            System.out.println(1);
            return;
        }
        if(N==2){
            System.out.println(2);
            return;
        }
        dp=new int[N+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=N;i++){
            dp[i]=(dp[i-1]%mod+dp[i-2]%mod)%mod;
        }
        System.out.println(dp[N]);
    }

}










