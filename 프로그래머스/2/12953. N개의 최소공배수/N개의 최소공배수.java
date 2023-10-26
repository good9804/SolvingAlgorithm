class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int start=0;
        for(int num:arr){
            start=Math.max(num,start);
        }
        
        while(true){
            boolean flag=false;
            for(int num:arr){
                if(start%num!=0){
                    flag=true;
                    break;}
            }
            if(!flag){
                return start;
            }
            start++;
            
            
            
        }
    }
}