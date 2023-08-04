import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String,Integer> wantMap=new HashMap<>();
        HashMap<String,Integer> currentMap=new HashMap<>();
        HashSet<String> enough=new HashSet<>();
        for(int i=0;i<want.length;i++){
            wantMap.put(want[i],number[i]);
        }
        for(int i=0;i<10;i++){
            currentMap.put(discount[i],currentMap.getOrDefault(discount[i],0)+1);
            
            if(currentMap.get(discount[i])==wantMap.get(discount[i])){
                enough.add(discount[i]);
            }
        }
        boolean isOk=true;
        int answer = 0;
        if(enough.size()==want.length){answer++;}
        for(int i=1;i+9<discount.length;i++){
            isOk=true;
            currentMap.put(discount[i-1],currentMap.get(discount[i-1])-1);
            currentMap.put(discount[i+9],currentMap.getOrDefault(discount[i+9],0)+1);
            
            if(currentMap.get(discount[i-1])==wantMap.get(discount[i-1])){
                enough.add(discount[i-1]);
            }else{
                if(enough.contains(discount[i-1])){
                enough.remove((discount[i-1]));}
            }
            
            if(currentMap.get(discount[i+9])==wantMap.get(discount[i+9])){
                enough.add((discount[i+9]));
            }else{
                if(enough.contains(discount[i+9])){
                enough.remove((discount[i+9]));}
            }
            
            if(enough.size()==want.length){answer++;}
            
        }
        
        
        
        
        return answer;
    }
}