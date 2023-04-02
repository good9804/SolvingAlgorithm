import java.io.*;
import java.lang.*;
import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        
        ArrayList<Integer> list=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<prices.length-1;i++){
            int temp=0;
            int k=prices[i];
            for(int j=i+1;j<prices.length;j++){
                temp++;
                if(k>prices[j]){
                    break;
                }
            }
            list.add(temp);
        }
        list.add(0);
            
            
        
        
        int[] answer=new int[list.size()];
        
        for(int i=0;i<answer.length;i++){
            answer[i]=list.get(i);
        }
        return answer;
    }}
