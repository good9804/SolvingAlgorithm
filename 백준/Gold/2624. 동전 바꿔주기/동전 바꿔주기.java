import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

class Main {
    static int N;
    static int M;
    static int K;
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        int K=Integer.parseInt(br.readLine());
        int[][] coins=new int[2][K];
        int[] dp=new int[T+1];
        for(int i=0;i<K;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int cost=Integer.parseInt(st.nextToken());
            int count=Integer.parseInt(st.nextToken());
            coins[0][i]=cost;
            coins[1][i]=count;
            
        }
        dp[0]=1;
            for(int j=0;j<K;j++) {

                    for (int i = T; i >=coins[0][j] ; i--) {
                        for (int temp = 1; temp <= coins[1][j]; temp++) {
                        if (i - coins[0][j] * temp >=0) {
                            dp[i] += dp[i - coins[0][j] * temp];
                        }else {break;}


                    }

                }
            }

        System.out.println(dp[T]);



    }
}



