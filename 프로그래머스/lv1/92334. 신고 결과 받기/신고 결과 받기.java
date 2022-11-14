import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer=new int[id_list.length];
        HashMap<String,Integer> reportCount=new HashMap<>();
        HashMap<String,List<String>> reportWho=new HashMap<>();
        HashMap<String,Integer> mailCount=new HashMap<>();
        for(int i=0;i<id_list.length;i++){
            reportCount.put(id_list[i],0);
            mailCount.put(id_list[i],0);
        }
        for(int i=0;i<report.length;i++){
            String[] str=report[i].split(" ");
                if(reportWho.containsKey(str[1])){
                    if(!iscontains(reportWho,str[1],str[0])){
                        List<String> list=reportWho.get(str[1]);
                        list.add(str[0]);
                        reportCount.put(str[1],reportCount.get(str[1])+1);}
                }
                else {
                    List<String> list=new ArrayList<>();
                    list.add(str[0]);
                    reportWho.put(str[1],list);
                        reportCount.put(str[1],reportCount.get(str[1])+1);
                }
                }
            
Iterator<Map.Entry<String, List<String>>> itr = reportWho.entrySet().iterator();
while(itr.hasNext())
{
    Map.Entry<String, List<String>> entry = itr.next();
	String key = entry.getKey();
	int value = reportCount.get(key);
	if(value>=k){
        List<String> resultanswer=reportWho.get(key);
        for(int i=0;i<resultanswer.size();i++){
            mailCount.put(resultanswer.get(i),mailCount.get(resultanswer.get(i))+1);
        }
        
    }
}
    for(int i=0;i<id_list.length;i++){
            answer[i]=mailCount.get(id_list[i]);
        }
        return answer;
        }
        
    
    public boolean iscontains(Map<String,List<String>> reportWho,String badboy,String reporter){
        List<String> list=new ArrayList<>();
        list=reportWho.get(badboy);
        return list.contains(reporter);
    }
    
}