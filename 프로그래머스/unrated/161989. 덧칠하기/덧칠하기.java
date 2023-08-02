import java.util.*;
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<section.length;i++){
            q.add(section[i]);
        }
        answer++;
        int k=q.poll();
        while(!q.isEmpty()){
            if(q.peek()-k+1<=m){
                q.poll();
            }else {
                k=q.poll();
                answer++;}
            
        }
        return answer;
    }
}