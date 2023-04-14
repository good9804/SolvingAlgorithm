import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer=new int[commands.length];
        int index=0;
        for(int i=0;i<commands.length;i++){
            int start=commands[i][0]-1;
            int end=commands[i][1]-1;
            int order=commands[i][2];
            PriorityQueue<Integer> pq=new PriorityQueue<>();
            for(int j=start;j<=end;j++){
                pq.add(array[j]);
            }
            int k=0;
            while(true){
                k++;
                if(k==order){
                    answer[index]=pq.poll();
                    break;
                }else pq.poll();
            }
            
            index++;
        }
        return answer;
    }
}