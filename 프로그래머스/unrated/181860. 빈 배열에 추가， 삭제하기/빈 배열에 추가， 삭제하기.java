import java.util.*;
class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        Deque<Integer> q=new ArrayDeque<>();
        
        for(int i=0;i<arr.length;i++){
            if(flag[i]){
                for(int j=0;j<arr[i]*2;j++){
                q.add(arr[i]);}
                
            }else{
                for(int j=0;j<arr[i];j++){
                    q.pollLast();
                }
                
            }
        }
        int[] answer=new int[q.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=q.pollFirst();
        }
        
        return answer;
    }
}