
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import java.util.*;
import java.util.List;

class Main {
    static int mod=1000000;
    static int pisano=15*mod/10;
    //피사노주기 나누는 나머지가 10^x 일때 주기는 15*10^(x-1)
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine())%pisano;//피사노만큼 주기를 가지니 n 입력받고 나눠주기
        if(num==0){
            System.out.println(0);//예외처리
            return;
        }else if(num==1||num==2){
            System.out.println(1);//예외처리
            return;
        }
        long[] dp = new long[pisano+1];//dp 선언
        dp[0]=0;//초기값 선언
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<=num;i++){
            dp[i]=(dp[i-1]%mod+dp[i-2]%mod)%mod;
        }
        System.out.println(dp[(int)num]);

    }}












