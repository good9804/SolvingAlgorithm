import java.lang.*;
import java.io.*;
import java.util.*;
import java.math.*;
class Solution {
    public int solution(String[][] clothes) {
        
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<clothes.length;i++){
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0)+1);
        }
        if(map.size()==1){
            return clothes.length;
        }
        int sum=map.size();
        int answer=1;
         for (Map.Entry<String, Integer> entry : map.entrySet()){

             answer*=entry.getValue()+1;
         }
        
        
        
        
        
        return answer-1;
    }
}