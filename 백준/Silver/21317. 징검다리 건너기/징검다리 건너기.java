
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] arr=new int[N][2];
        int[] dp=new int[N];
        if(N==1){
            System.out.println(0);
            return;
        }
        for(int i=0;i<N-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());//N개의돌 마지막 돌틈까지가는게 목표
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int K = Integer.parseInt(br.readLine());
        if(N==2){
            System.out.println(arr[0][0]);
            return;
        }

        dp[0]=0;
        dp[1]=arr[0][0];
        if(N==3){
            dp[2]=Math.min(dp[1]+arr[1][0],dp[0]+arr[0][1]);
            System.out.println(dp[2]);
            return;
        }
        int answer=Integer.MAX_VALUE;
        for(int i=3;i<N;i++){
            Arrays.fill(dp,0);
            dp[0]=0;
            dp[1]=arr[0][0];
        for(int j=2;j<N;j++){
            if(i==j){
            dp[j]=Math.min(dp[j-1]+arr[j-1][0],Math.min(dp[j-2]+arr[j-2][1],dp[j-3]+K));}
            else{
                dp[j]=Math.min(dp[j-1]+arr[j-1][0],dp[j-2]+arr[j-2][1]);
            }
        }
        answer=Math.min(answer,dp[N-1]);
        }

        System.out.println(answer);

        }
        //1단점프 ,2단점,3단점프
        //1단점프 2단점프는 점프하는돌의번호에따라다름 3단점프는 단한번 K만큼소비 ,에너지최솟값
        // 1 2 3 4 5 돌번호
        // 1 2 4 6  1단점프 에너지소비량
        // 2 3 5 7 2단점프소비량
        //4를 기준으로보면 올수있는경우의수
        // 3-> 4
        // 2->4
        //1->4



    }
