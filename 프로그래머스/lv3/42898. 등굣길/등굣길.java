class Solution {
    static int row;
    static int col;
    public int solution(int m, int n, int[][] puddles) {
        int[][] pan=new int[n][m];
        int mod=1000000007;
        pan[0][1]=1;
        pan[1][0]=1;
        for(int i=0;i<puddles.length;i++){
            pan[puddles[i][1]-1][puddles[i][0]-1]=-1;
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pan[i][j]==-1){continue;}
                if(i-1>=0&&pan[i-1][j]>0){pan[i][j]+=pan[i-1][j]%mod;}
                if(j-1>=0&&pan[i][j-1]>0){pan[i][j]+=pan[i][j-1]%mod;}
            }
        }
        return pan[n-1][m-1]%mod;
    }
}