import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
        
            int count=0;
            while(count<index){
                if(c+1>'z'){
                    c='a';
                    c--;
                }
                if(!skip.contains(Character.toString(++c))){
                    count++;
                }
                
                
            }
            answer.append(c);
            
        }
        
        
        
        return answer.toString();
    }
}