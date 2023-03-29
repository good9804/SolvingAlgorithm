import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<participant.length;i++){
            if(map.containsKey(participant[i])){
                int temp=map.get(participant[i])+1;
                map.put(participant[i],temp);
            }else map.put(participant[i],1);
        }
         for(int i=0;i<completion.length;i++){
            if(!map.containsKey(completion[i])){
                return completion[i];
            }else {
                int temp=map.get(completion[i])-1;
                if(temp==0){map.remove(completion[i]);}
                else {map.put(completion[i],temp);}
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet())
            return entry.getKey();
        return answer;
    }
}