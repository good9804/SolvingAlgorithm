import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<works.length;i++){
            pq.add(works[i]);
        }
        for(int i=0;i<n;i++){
            if(pq.isEmpty()){break;}
            if(pq.peek()-1<=0){
                pq.poll();
                continue;
            }
            pq.add(pq.poll()-1);
        }
        while(!pq.isEmpty()){
            long num=pq.poll();
            
            answer+=num*num;
        }
        return answer;
    }
}