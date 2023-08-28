
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
        int[][] arr=new int[2][N+2];
        int[] dp=new int[N+2];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            arr[0][i]=Integer.parseInt(st.nextToken());//소요일
            arr[1][i]=Integer.parseInt(st.nextToken());//수익
        }
        int answer=0;
        for(int i=1;i<=N+1;i++){
            answer=Math.max(dp[i],answer);//answer i날까지 최대값
            if(i+arr[0][i]<=N+1){
                dp[i+arr[0][i]]=Math.max(answer+arr[1][i],dp[i+arr[0][i]]);


            }
            }

        System.out.println(dp[N+1]);





    }
    }