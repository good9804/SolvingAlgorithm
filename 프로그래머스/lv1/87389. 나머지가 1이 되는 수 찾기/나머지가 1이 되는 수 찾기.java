class Solution {
    public int solution(int n) {
        int answer=findAnswer(n);
        return answer;
    }
    public int findAnswer(int n){
        int answer=1;
        while(true){
            if(n%answer==1){
                break;
            }
            answer++;
        }
        return answer;
    }
}