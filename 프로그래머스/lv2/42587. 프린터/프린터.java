import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
class Solution {
    public int solution(int[] priorities, int location) {
            Queue<Print> q= new LinkedList<>();
        
        int max=Integer.MIN_VALUE;
        for(int i=0;i<priorities.length;i++){
            q.add(new Print(i,priorities[i]));
            max=Math.max(max,priorities[i]);
        }
        int answer=1;
        Arrays.sort(priorities);
        int temp=priorities.length-1;
        while(true){
            Print p=q.poll();
            if(p.pro>=priorities[temp]){
                temp--;
                if(p.index==location){
                    return answer;
                }
                else answer++;
            }else {q.add(p);
                  }
            
        }
        
        
        
    }
}
class Print{
    int index;
    int pro;
    public Print(int index,int pro){
        this.index=index;
        this.pro=pro;
    }
}