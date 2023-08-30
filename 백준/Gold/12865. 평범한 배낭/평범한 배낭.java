
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

class Main {
    static int N;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] dp=new int[N+1][K+1];
        int[][] arr=new int[2][N+1];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            arr[0][i]=W;
            arr[1][i]=V;
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=K;j++){
                if(j-arr[0][i]>=0){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-arr[0][i]]+arr[1][i]);

                }else dp[i][j]=dp[i-1][j];

            }
        }


        System.out.println(dp[N][K]);




    }


}


