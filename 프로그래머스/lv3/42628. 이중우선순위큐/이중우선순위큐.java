import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minpq=new PriorityQueue<>();
        PriorityQueue<Integer> maxpq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<operations.length;i++){
            String[] s=operations[i].split(" ");
            if(s[0].equals("I")){
                minpq.add(Integer.parseInt(s[1]));
                maxpq.add(Integer.parseInt(s[1]));
            }
            else{
                if(minpq.size()==0||maxpq.size()==0){continue;}
                if(s[1].equals("1")){
                    minpq.remove(maxpq.poll());
                }
                else{
                    maxpq.remove(minpq.poll());
                }
            }
            
            
            
        }
        int[] answer=new int[2];
        if(minpq.size()==0){
            answer[0]=0;
            answer[1]=0;
        }
        else{
            answer[0]=maxpq.poll();
            answer[1]=minpq.poll();
        }
        
        return answer;
    }
}