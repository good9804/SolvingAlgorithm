import java.util.*;
import java.lang.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize==0){return cities.length*5;}
        ArrayList<String> strings=new ArrayList<>();
        strings.add(cities[0].toLowerCase());
        answer+=5;
        for(int i=1;i<cities.length;i++){
            boolean flag=false;
           String tempstring= cities[i].toLowerCase();
            for(int k=0;k<strings.size();k++){
                if(strings.get(k).equals(tempstring)){
                    strings.remove(k);
                    strings.add(tempstring);
                    answer+=1;
                    flag=true;
                    break;
                } }
            
            if(!flag){
                if(strings.size()==cacheSize){
                        strings.remove(0);
                        strings.add(tempstring);
                        answer+=5;
                    }
                else{strings.add(tempstring);
                        answer+=5;}}
                
            }    
                
            
        
        
        return answer;
    }
}