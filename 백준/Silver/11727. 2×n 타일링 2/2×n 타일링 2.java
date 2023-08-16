
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;


class Main {
    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp=new int[N+1];
        //2 X n (1 x 2, 2 x 1, 2 x 2)
        //n=1  1
        //n=2  3
        //n=3 1+2+2=5
        //n=4  1+ 1+ 1+6(긴 작대기두개)+2=11
        //n= 8 171
        dp[1]=1;
        if(N==1){
            System.out.println(1);
            return;
        }
        dp[2]=3;

        if(N==2){
            System.out.println(3);
            return;
        }
        for(int i=3;i<=N;i++){
            dp[i]=((dp[i-2]*2)%10007+(dp[i-1]%10007))%10007;
        }
        System.out.println(dp[N]);

    }}












