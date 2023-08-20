import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb =new StringBuilder();
        while(T-->0){

            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][N+1];
        for (int i = 0; i < 2; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp1=new int[2][N+1];
        dp1[0][1]=arr[0][1];
        dp1[1][1]=arr[1][1];
        if(N>1){
            dp1[0][2]=dp1[1][1]+arr[0][2];
            dp1[1][2]=dp1[0][1]+arr[1][2];
        }


        for(int i=2;i<=N;i++){
            dp1[0][i]=Math.max(dp1[1][i-1],dp1[1][i-2])+arr[0][i];
            dp1[1][i]=Math.max(dp1[0][i-1],dp1[0][i-2])+arr[1][i];

        }

        sb.append(Math.max(dp1[0][N],dp1[1][N])+"\n");
        }
        System.out.println(sb);

    }
}



