
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import java.util.*;

class Main {
    static int min;
    static int[] dp;
    static StringBuilder answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        dp=new int[num+1];

        Arrays.fill(dp,Integer.MAX_VALUE);
        min=Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        backtracking(num,sb,0);
        System.out.println(min);
        System.out.println(answer);
    }
    static void backtracking(int num,StringBuilder sb,int count){
        if(count>=dp[num]||count>=min){return;}
        dp[num]=count;
        StringBuilder tempsb=new StringBuilder(sb);
        tempsb.append(num).append(" ");

        if(num==1){
            min=Math.min(count,min);
            answer=tempsb;
            return;}
        if(num%3==0){
            backtracking(num/3,tempsb,count+1);
        }
        if(num%2==0){
            backtracking(num/2,tempsb,count+1);
        }
        backtracking(num-1,tempsb,count+1);
    }

}






