import java.util.*;
import java.math.*;
class Solution {
    
    public int[] solution(int[] sequence, int k) {
        int sum=sequence[0];
            int left=0;
            int right=0;
        int answerstart=0;
        int answerend=0;
        int answerlength=sequence.length+1;
        while(left<=sequence.length-1){
            if(right==sequence.length-1){
                
                if(sum<k){
                    break;
                }else if(sum>k){
                sum-=sequence[left];
                left+=1;
                }else{
                if(right-left+1==1){
                    answerstart=left;
                    answerend=right;
                    break;
                }
                if(right-left+1<answerlength){
                    answerstart=left;
                    answerend=right;
                    answerlength=right-left+1;
                }
                          sum-=sequence[left];
                    left++;
                    
                }
            }
            else{if(sum<k)
            {
                right+=1;
                sum+=sequence[right];
                
            }
            else if(sum>k){
                sum-=sequence[left];
                left+=1;
            }
            else{
                if(right-left+1==1){
                    answerstart=left;
                    answerend=right;
                    break;
                }
                if(right-left+1<answerlength){
                    answerstart=left;
                    answerend=right;
                    answerlength=right-left+1;
                }
                right++;
                          sum+=sequence[right];
            }
        }}
        int[] answer=new int[2];
        answer[0]=answerstart;
        answer[1]=answerend;
        return answer;
    }
}

          