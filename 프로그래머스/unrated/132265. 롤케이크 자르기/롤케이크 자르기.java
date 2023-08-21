import java.util.*;

class Solution {
    public int solution(int[] topping) {
        HashMap<Integer,Integer> old=new HashMap<>();
        HashMap<Integer,Integer> young=new HashMap<>();
        for(int i=0;i<topping.length;i++){
            young.put(topping[i],young.getOrDefault(topping[i],0)+1);
        }
        int answer=0;
        for(int i=0;i<topping.length;i++){
            old.put(topping[i],young.getOrDefault(topping[i],0)+1);
            if(young.get(topping[i])==1){
                young.remove(topping[i]);
            } else young.put(topping[i],young.get(topping[i])-1);
            if(old.size()==young.size()){
                answer++;
            }
        }
        return answer;
    }
}