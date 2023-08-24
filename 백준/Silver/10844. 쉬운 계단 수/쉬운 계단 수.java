
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
class Main {
    static int N;
    static int M;
    static int K;
    static int Mod=1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        //인접한 자릿수끼리 차이가 1나야함
        // 7 -> 6 8이 올수있음
        int[][] dp=new int[N+1][10];
        for(int i=1;i<10;i++){
        dp[1][i]=1;
        }
        for(int j=2;j<=N;j++){
        for(int i=0;i<10;i++){
            if(i==0){
                dp[j][i]=dp[j-1][i+1]%Mod;
                continue;
            }
            if(i==9){
                dp[j][i]=dp[j-1][i-1]%Mod;
                continue;
            }
            dp[j][i]=(dp[j-1][i-1]%Mod+dp[j-1][i+1]%Mod)%Mod;
        }
        }
        long sum=0;
        for(int i=0;i<10;i++){
            sum+=dp[N][i];
        }
        System.out.println(sum%Mod);









}


}