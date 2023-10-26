import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q=new PriorityQueue<>();
        for(int i=0;i<scoville.length;i++){
            q.add(scoville[i]);
        }
        while(true){
            boolean flag=false;
            int qsize=q.size();
            if(qsize==1){
                if(q.peek()<K){
                    return -1;
                }
            }
            if(q.peek()>=K){
                break;
            }
            answer++;
            int min=q.poll();
            int secondmin=q.poll();
            q.add(min+secondmin*2);
            
            
            
            
            
        }
        return answer;
    }
    
}