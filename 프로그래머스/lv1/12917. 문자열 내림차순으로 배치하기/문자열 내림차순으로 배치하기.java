import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        String[] str=s.split("");
        Arrays.sort(str);
        for(int i=0;i<str.length;i++){
            if(str[i].charAt(0)<='z'){
                sb1.append(str[i].charAt(0));
                continue;
            }
            sb2.append(str[i].charAt(0));
        }
        sb1.append(sb2).reverse();
        
        return sb1.toString();
    }
}