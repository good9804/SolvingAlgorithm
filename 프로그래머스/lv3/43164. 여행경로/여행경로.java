import java.util.*;
import java.lang.*;
class Solution {
    static ArrayList<String> answer;
    static int size;
    static boolean[] isVisited;
        
    public String[] solution(String[][] tickets) {
        answer=new ArrayList<>();
        size=tickets.length+1;
        isVisited=new boolean[tickets.length];
        dfs(1,"ICN","ICN",tickets);
        Collections.sort(answer);
        
        return answer.get(0).split(" ");
    }
     static void dfs(int count,String start,String path,String[][] tickets){
         if(count==size){
             answer.add(path);
             return;
         }
         for(int i=0;i<size-1;i++){
             if(start.equals(tickets[i][0])&&!isVisited[i]){
                 isVisited[i]=true;
                 dfs(count+1,tickets[i][1],path+" "+tickets[i][1],tickets);
                 isVisited[i]=false;
             }
         }
     }
}
