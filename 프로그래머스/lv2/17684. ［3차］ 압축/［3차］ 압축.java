import java.util.*;
class Solution {
    public int[] solution(String msg) {
       HashMap<String,Integer> newWord=new HashMap<>();
        ArrayList<Integer> answer= new ArrayList<>();

        int newIndex=27;
        boolean flag=true;
        for(int i=0;i<msg.length();i++){
            StringBuilder sb=new StringBuilder();
            int temp=i;
            int last=0;
            while(true){
                char first=msg.charAt(temp);

                sb.append(first);
                if(sb.length()==1){
                    temp++; last=first-'A'+1;
                    if(temp>=msg.length()){
                        answer.add(last);
                        flag=false;
                        break;
                    } continue; }
                if(newWord.containsKey(sb.toString())){


                    temp++;
                    last=newWord.get(sb.toString());
                    if(temp>=msg.length()){
                        answer.add(last);
                        flag=false;
                        break;
                    }

                }else{
                    newWord.put(sb.toString(),newIndex);
                    answer.add(last);
                    newIndex++;
                    break;
                }
            }
            if(!flag){
                break;
            }
            i+=temp-i-1;

        }

        int[] result=new int[answer.size()];
        for(int i=0;i<answer.size();i++){
            result[i]=answer.get(i);
        }
        return result;
    }
}