class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        //n명참가
        //1 2 , 3 4, 이렇게진행
        //몇번째라운드에서만나는지
        // 1 2 3 4 5 6 7 8
        while(true){
            answer++;
            if(a>b){
                if(a-1==b&&a%2==0){
                return answer;}
            }
            else{
                if(b-1==a&&b%2==0){
                    return answer;
                }
            }
            if(a%2==0){
                a=a/2;
            }
            else{
                a=(a+1)/2;
            }
            
            if(b%2==0){
                b=b/2;
            }
            else{
                b=(b+1)/2;
            }
            
            
            
            
        }
    }
}