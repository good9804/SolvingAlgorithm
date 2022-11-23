class Solution {
    public int solution(int n) {
        int[] fibo=new int[3];
        fibo[0]=0;
        fibo[1]=1;
        for(int i=2;i<=n;i++){
            fibo[2]=(fibo[0]+fibo[1])%1234567;
            fibo[0]=fibo[1];
            fibo[1]=fibo[2];
            
        }
        return fibo[2];
    }
}