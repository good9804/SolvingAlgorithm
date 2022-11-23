class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sumlength=brown-4;
        for(int a=1;a<=sumlength;a++){
            for (int b=1;b<=sumlength;b++){
                if((a*b==yellow)&&((a+b)*2==sumlength)){
                answer[0]=b+2;
                answer[1]=a+2;
                    return answer;
            }
            }
        }
        return answer;
    }
}