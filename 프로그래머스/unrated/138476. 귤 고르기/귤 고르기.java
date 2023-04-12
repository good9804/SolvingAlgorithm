import java.util.*;

class Solution {
    
    public int solution(int k, int[] tangerine) {
        
        ArrayList<Tan> tans=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<tangerine.length;i++){
            map.put(tangerine[i],map.getOrDefault(tangerine[i],0)+1);
        }
        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            
            tans.add(new Tan(entry.getKey(),entry.getValue()));
        }
        Collections.sort(tans);
        int sum=0;
        int answer=0;
        for(int i=0;i<tans.size();i++){
            if(sum>=k){
                break;
            }
            sum+=tans.get(i).count;
            answer++;
        }
        return answer;
    }
}
class Tan implements Comparable{
    int size;
    int count;
    public Tan(int size,int count){
        this.size=size;
        this.count=count;
    }
    
    @Override
    public int compareTo(Object o){
        Tan t=(Tan) o;
        return t.count-this.count;
    }
    
}
