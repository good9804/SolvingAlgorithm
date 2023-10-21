import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
    //야근 피로도는 야근 시작한 시점에서 남은 일의 작업량 제곱하여 더한값
        //N시간동안 최소화
        //1시간동안 작업량 1
        //야근피로도최소화
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int work:works){
            pq.add(work);
        }
        long answer=0;
        int time=n;
        while(!pq.isEmpty()&&time!=0){
            int work=pq.poll();
            time--;
            if(work-1==0){continue;}
            pq.add(work-1);
            
            
        }
        while(!pq.isEmpty()){
            int work=pq.poll();
            answer+=work*work;
            
            
        }
        return answer;
        
        
        
        
    
    }
}