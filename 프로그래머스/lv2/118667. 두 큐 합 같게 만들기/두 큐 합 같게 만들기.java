import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        //1 3 1 1 1
        long sum=0;
        int[] qCheck=new int[queue1.length];
        for(int i=0;i<queue1.length;i++){
            sum+=queue1[i]+queue2[i];
        }
        if(sum%2==1){return -1;}
        Queue<Integer> q=new LinkedList<>();
        Queue<Integer> q2=new LinkedList<>();
        long qSum=0;
        long q2Sum=0;
        for(int i=0;i<queue1.length;i++){
            
            q.add(queue1[i]);
            qSum+=queue1[i];
            q2.add(queue2[i]);
            q2Sum+=queue2[i];
            if(sum%2==0){
                if(queue1[i]>sum/2||queue2[i]>sum/2){
                    return -1;
                }
            }
        }
        long qFirst=0;
        qFirst=qSum;
        int count=0;
        int max=(q.size()+q2.size())*2;
        while(true){
            
            if(count>max){return -1;}
            if(qSum==q2Sum){
                return count;
            }else{
                if(qSum>q2Sum){
                    qSum-=q.peek();
                    q2Sum+=q.peek();
                    q2.add(q.poll());
                
                }
                else{
                    
                    q2Sum-=q2.peek();
                    qSum+=q2.peek();
                    q.add(q2.poll());
                }
            }
            count++;
        }
    }
}