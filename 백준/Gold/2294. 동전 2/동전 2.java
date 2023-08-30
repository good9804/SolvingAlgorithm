
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

class Main {
    static int N;
    static int K;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int answer=Integer.MAX_VALUE;
    static ArrayList<Integer>[] lists;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        HashSet<Integer> Map = new HashSet<>();
        int[] dp=new int[K+1];
        while(N-->0){
            Map.add(Integer.parseInt(br.readLine()));
        }
        Arrays.fill(dp,987654321);
        for(int value:Map){
            if(value<=K){
            dp[value]=1;}
         for(int i=1;i<=K;i++){
             if(i-value>0){
                 dp[i]=Math.min(dp[i-value]+1,dp[i]);
             }

         }
        }
        if(dp[K]==987654321){
            System.out.println(-1);
            return;
        }
        System.out.println(dp[K]);



    }


}


