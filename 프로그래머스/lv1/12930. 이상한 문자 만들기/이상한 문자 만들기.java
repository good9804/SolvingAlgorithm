import java.util.*;
class Solution {
    public String solution(String s) {
        
        StringBuilder sb=new StringBuilder();
        int j=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                sb.append(" ");
                j=0;
                 continue;
                              }
            if(j%2==0){
                sb.append(Character.toUpperCase(s.charAt(i)));
                      j++;}
            else{
                sb.append(Character.toLowerCase(s.charAt(i)));
                j++;}
            }
        return sb.toString();
            
        }
       
    }
