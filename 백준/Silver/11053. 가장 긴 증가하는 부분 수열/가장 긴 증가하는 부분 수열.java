

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
    static int[] dp;

    static int[] arr;
    // 1
    //1 2 1
    //1 3 3 1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr=new int[N+1];
        dp=new int[N+1];
        for(int i=1;i<=N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }
        int answer=Integer.MIN_VALUE;
        for(int i=1;i<=N;i++){
            dp[i]=1;
            for(int j=1;j<=i;j++){
                if(arr[j]<arr[i]&&dp[j]>=dp[i]){
                    dp[i]=dp[j]+1;

                }
            }
            answer=Math.max(dp[i],answer);
        }
        System.out.println(answer);

    }
}












