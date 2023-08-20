
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;


class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr=new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());

        }
        int[] dp=new int[N];
        int[] dp2=new int[N];
        int answer=Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            dp[i]=1;
            int max=0;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]&&dp[j]>=dp[i]&&dp2[j]>dp2[i]){
                    dp[i]=dp[j]+1;
                 dp2[i]=dp2[j];

                }
            }
            dp2[i]+=arr[i];
            answer=Math.max(answer,dp2[i]);
        }
        System.out.println(answer);

    }




}