class Solution {
    static int[][] allland;
    static int answer=0;
    int solution(int[][] land) {
        allland=land;
        int[][] dp=new int[land.length][4];
        dp[0][0]=land[0][0];
        dp[0][1]=land[0][1];
        dp[0][2]=land[0][2];
        dp[0][3]=land[0][3];
        for(int i=1;i<land.length;i++){
            for(int j=0;j<4;j++){
                for(int k=0;k<4;k++){
                    if(k==j){continue;}
                dp[i][j]=Math.max(dp[i][j],dp[i-1][k]+land[i][j]);}
            }
        }
        for(int i=0;i<4;i++){
            answer=Math.max(dp[land.length-1][i],answer);
        }
        return answer;
    }
   
        
    }
