
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[] dp=new long[K+1];
        int[]  arr=new int[N];
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }// 1 2 3 4 5 6 7 8 9 10
        // dp[1],
        for(int i=0;i<arr.length;i++){
            //동전봅기
            for(int j=1;j<=K;j++){
                if(arr[i]==j){dp[j]++;}
                if(j-arr[i]>0){//2원짜리로 6원갈때 dp[2]+=1 dp[4]= dp[2] +1 dp[6]= dp[2] 2 dp[4] +1 [dp[6]
                dp[j]=dp[j-arr[i]]+dp[j];
            }
        }}
        System.out.println(dp[K]);




}}