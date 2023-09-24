
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());//전체사이즈-가장 긴 증가 수열 길이?
        int[] arr=new int[N];
        int[] dp=new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int maxLength=0;
        for(int i=0;i<N;i++){
            dp[i]=1;
           for(int j=0;j<i;j++){
               if(arr[j]<arr[i]&&dp[j]>=dp[i]){
                   dp[i]=dp[j]+1;
                   maxLength=Math.max(dp[i],maxLength);
               }
           }
        }
        System.out.println(N-maxLength);


        }


    }






