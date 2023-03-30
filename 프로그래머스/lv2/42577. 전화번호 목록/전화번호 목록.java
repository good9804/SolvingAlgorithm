import java.io.*;
import java.lang.*;
import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set=new HashSet<>();
        for(int i=0;i<phone_book.length;i++){
            set.add(phone_book[i]);
        }
        for(String p:phone_book)
            for(int i=1;i<p.length();i++){
                if(set.contains(p.substring(0,i))){
                    return false;
                }
            }
        
        return true;
    }
}