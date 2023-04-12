import java.util.*;
class Solution {
    
    static ArrayList<Integer> arr;
    static int[][] dp;
    public int solution(int[][] triangle) {
        int answer = 0;
        int lastrow=triangle.length-1;
        int lastcol=triangle.length;
        dp=new int[triangle.length][triangle[triangle.length-1].length];
        dp[0][0]=triangle[0][0];
        for(int i=1;i<=lastrow;i++){
            for(int j=0;j<triangle[i].length;j++){
                if(j==0){dp[i][j]=dp[i-1][j]+triangle[i][j]; continue;}
                if(j==triangle[i].length-1){dp[i][j]=dp[i-1][j-1]+triangle[i][j];continue;}
                dp[i][j]=Math.max(dp[i-1][j-1],dp[i-1][j])+triangle[i][j];
            }
        }
        int temp=0;
        for(int i=0;i<lastcol;i++){
            System.out.println(dp[lastrow][i]);
            temp=Math.max(temp,dp[lastrow][i]);
        }
        
        
        return temp;
    }
}