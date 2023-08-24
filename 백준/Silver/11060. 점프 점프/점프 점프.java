
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
        int[] arr=new int[N];
        int[] dp=new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //i번째 써있는 수를 Ai라할때
        //Ai이하만큼 오른쪽으로 점프가능
        //제일왼쪽에서 제일오른쪽갈려할때 최소몇번점
        Arrays.fill(dp,10000);
        dp[0]=0;
        for(int i=0;i<N;i++){
            int k=arr[i];
            for(int j=i+1;j<=i+k;j++){
                if(j<N){
                dp[j]=Math.min(dp[i]+1,dp[j]);}
                else break;
            }
        }
        if(dp[N-1]==10000){
            System.out.println(-1);
            return;
        }
        System.out.println(dp[N-1]);







}

}
