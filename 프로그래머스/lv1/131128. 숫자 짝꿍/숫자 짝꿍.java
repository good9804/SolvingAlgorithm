import java.lang.Math;
import java.lang.StringBuilder;
import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        Map<String,Integer> mapx=new HashMap<>();
        Map<String,Integer> mapy=new HashMap<>();
        Set<String> temp=new HashSet<>();
        StringBuilder result = new StringBuilder("");
        String dup="";
        for(String key:X.split("")){
            mapx.put(key,mapx.getOrDefault(key,0)+1);
        }
        for(String key:Y.split("")){
            mapy.put(key,mapy.getOrDefault(key,0)+1);
        }
        temp=mapx.keySet();
        Iterator<String> itr=temp.iterator();
        while(itr.hasNext()){
            dup=itr.next();
            if(mapy.containsKey(dup)){
                int roop=Math.min(mapx.get(dup),mapy.get(dup));
                for(int k=0;k<roop;k++ ){
                    result.append(dup);

                }
            }}
        answer=result.reverse().toString();
        if(answer.equals("")){
            return "-1";
        }else if(answer.startsWith("0")){return "0";}
        else {return answer;}
    
        
        
            
    
        
    }
}