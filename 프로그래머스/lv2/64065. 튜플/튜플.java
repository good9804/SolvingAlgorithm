import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(String s) {
        StringBuilder sb=new StringBuilder();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char temp=s.charAt(i);
            if(temp>='0'&&temp<='9'){
                sb.append(temp);
            }else{
                if(sb.length()>0){
                    int k=Integer.parseInt(sb.toString());
                    map.put(k,map.getOrDefault(k,0)+1);
                    sb.setLength(0);
                }
                else{continue;}
                
            }
        }
        int[] answer=new int[map.size()];
        ArrayList<tuple> tuples=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            tuples.add(new tuple(entry.getKey(),entry.getValue()));
        }
        Collections.sort(tuples);
        int index=0;
        for(tuple t:tuples){
            answer[index++]=t.a;
        }
        
        return answer;
    }
}
class tuple implements Comparable{
    int a;
    int b;
    public tuple(int a,int b){
        this.a=a;
        this.b=b;
    }
    
    @Override
    public int compareTo(Object o){
        tuple t=(tuple) o;
        return t.b-this.b;
    }
    
}