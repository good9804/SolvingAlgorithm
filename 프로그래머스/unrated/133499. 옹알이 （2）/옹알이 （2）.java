class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(int i=0;i<babbling.length;i++){
            String str=babbling[i];
            if(str.contains("ayaaya")||str.contains("yeye")||str.contains("mama")||str.contains("woowoo")){continue;}
            String[] arr=str.split("aya|ye|ma|woo");
                if(arr.length==0){
                    answer++;
                }
        }
        return answer;
    }
}