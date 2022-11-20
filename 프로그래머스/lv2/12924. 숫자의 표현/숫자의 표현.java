class Solution {
    public int solution(int n) {
        int answer = 0;
        int count=0;
        for(int i=1;i<=n;i++){
            for(int k=i;k<=n;k++){
            count+=k;
            if(count==n){
                answer++;
                break;
            }
            if(count>n){
                count=0;
                break;
            }
            if(k>n/2){
                break;
            }
                 }
            if(i>n/2){break;}
        }
        if(n==1||n==2){
            return 1;
        }
        return answer+1;
    }
}