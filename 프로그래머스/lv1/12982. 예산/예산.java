import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<d.length;i++){
            pq.add(d[i]);
        }
        while(!pq.isEmpty()){
            if(answer+pq.peek()<=budget){
                answer+=pq.poll();
            }else break;
        }
        return d.length-pq.size();
    }
}