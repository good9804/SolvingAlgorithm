import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        LinkedList<String> ll=new LinkedList<>();
        HashMap<String,Integer> map=new HashMap<>();
        int i=0;
        for(String player: players){
            map.put(player,i++);
        }
        for(String calling: callings){
            int rank=map.get(calling);
            players[rank]=players[rank-1];
            players[rank-1]=calling;
            map.put(calling,rank-1);
            map.put(players[rank],rank);
            
            
        }
        
        return players;
    }
}
