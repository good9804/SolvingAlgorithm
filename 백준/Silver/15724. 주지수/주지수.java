
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

class Main {
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] pan=new int[N+1][M+1];
        int[][] dp=new int[N+1][M+1];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());

            for(int j=1;j<=M;j++){
                pan[i][j] = Integer.parseInt(st.nextToken());

                    dp[i][j]=dp[i][j-1]+pan[i][j];

            }
        }

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(q-->0){
            st = new StringTokenizer(br.readLine());
            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());
            int answer=0;
            for(int i=x1;i<=x2;i++){
                answer+=dp[i][y2]-dp[i][y1-1];
            }
            sb.append(answer+"\n");
        }
        System.out.print(sb.substring(0,sb.length()-1));




    }


}


