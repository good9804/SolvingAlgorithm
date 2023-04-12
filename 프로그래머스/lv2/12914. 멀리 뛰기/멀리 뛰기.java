class Solution {
    public long solution(int n) {
        int k=3;
        int[] dp=new int[n+1];
        if(n==1||n==2){
            return n;
        }
        
        dp[1]=1;
        dp[2]=2;
        while(true){
            if(k>n){break;}
            dp[k]=(dp[k-1]+dp[k-2])%1234567;
            k++;
            
        }
        return dp[n];
    }
}