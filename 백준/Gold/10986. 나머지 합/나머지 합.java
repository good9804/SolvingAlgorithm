
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

class Main {
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] arr=new long[N+1];
        long[] dp=new long[N+1];
        HashMap<Long,Long> map=new HashMap<>();
        st = new StringTokenizer(br.readLine());
        long count=0;
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken())%M;

            dp[i]=(dp[i-1]+arr[i])%M;
            if(dp[i]==0){count++;}
            map.put(dp[i],map.getOrDefault(dp[i],0L)+1);
        }

        for(long val:map.values()){

            count+=val*(val-1)/2;
        }


        System.out.println(count);







    }

}


