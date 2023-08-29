
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

class Main {
    static int max;
    static boolean[] isVisited;
    static boolean flag=false;
    static ArrayList<Integer>[] friends;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int K = Integer.parseInt(br.readLine());
            int[] dp=new int[K+1];
            for(int i=0;i<N;i++){
                if(arr[i]<=K){
                dp[arr[i]]++;}
            for(int j=1;j<=K;j++){
                if(j-arr[i]>0){
                dp[j]+=dp[j-arr[i]];}
            }
            }
            System.out.println(dp[K]);

        }














    }

}


