import java.util.*;
class Solution {
    static boolean[] Checked;
    static ArrayList<Integer> list=new ArrayList<>();
    static int[] boxes;
    public int solution(int[] cards) {
        boxes=new int[cards.length+1];
        for(int i=1;i<=cards.length;i++){
            boxes[i]=cards[i-1];
        }
        int firstCount=0;
        int secondCount=0;
        Checked=new boolean[cards.length+1];
        for(int i=1;i<=cards.length;i++){
            if(!Checked[i]){
            dfs(i,0);}
        }
        Collections.sort(list,Collections.reverseOrder());
        if(list.size()==1){
            return 0;
        }else return list.get(0)*list.get(1);
        
    }
    static void dfs(int num,int current){
        if(Checked[num]){
            list.add(current);
            return;
        }else {
            Checked[num]=true;
            dfs(boxes[num],current+1);
              }
    }
}