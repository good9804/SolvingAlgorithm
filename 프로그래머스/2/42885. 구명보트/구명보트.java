import java.util.*;
class Solution {
    
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        for(int p: people){
            dq.add(p);
        }
        int answer=0;
        while(!dq.isEmpty()){
            int first=dq.getFirst();
            int last=dq.getLast();
            if(dq.size()==1){
                answer++;
                break;
            }
            if(first+last<=limit){
                answer++;
                dq.pollLast();
                dq.pollFirst();
                continue;
            }
            if(last+first>limit){
                answer++;
                dq.pollLast();
                continue;
            }
            
            
            
        }
        
        return answer;
    }
}