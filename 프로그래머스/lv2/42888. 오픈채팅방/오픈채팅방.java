import java.util.*;
import java.lang.*;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String,String> map=new HashMap<>();
        ArrayList<seq> s=new ArrayList<>();
        for(int i=0;i<record.length;i++){
            String[] r=record[i].split(" ");
            if(r[0].equals("Enter")){
                map.put(r[1],r[2]);
                s.add(new seq(r[1],1));
            }
            else if(r[0].equals("Leave")){
                s.add(new seq(r[1],-1));
            }
            else{
                map.put(r[1],r[2]);
            }
            
            
            
            
        }
        String[] answer=new String[s.size()];
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<answer.length;i++){
            sb.setLength(0);
            if(s.get(i).enterOrExit==1){
             answer[i]=sb.append(map.get(s.get(i).id)+"님이 들어왔습니다.").toString();
            }
            
        else{
            answer[i]=sb.append(map.get(s.get(i).id)+"님이 나갔습니다.").toString();
            
        }
        }
        
        return answer;
    }
    
}
class seq{
    String id;
    int enterOrExit;
    public seq(String id,int enterOrExit){
        this.id=id;
        this.enterOrExit=enterOrExit;
    }
}