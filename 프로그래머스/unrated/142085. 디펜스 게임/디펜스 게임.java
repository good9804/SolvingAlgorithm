import java.util.*;
class Solution {
    static int max=Integer.MIN_VALUE;
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Node> pq=new PriorityQueue<>();
        if(k>=enemy.length){
            return enemy.length;
        }
        int current=0;
        int answer=0;
        for(int i=0;i<enemy.length;i++){
                current+=enemy[i];
                pq.add(new Node(i,enemy[i]));
            if(current>n){
                if(k>0){
                Node cur=pq.poll();
                current-=cur.cost;
                    k--;
                    answer++;
                    }else { break;}
            }else{answer++;}
            
        }
        return answer;
    }

    
}
class Node implements Comparable<Node>{
    int index;
    int cost;
    public Node(int index,int cost){
        this.index=index;
        this.cost=cost;
    }
    
    @Override
    public int compareTo(Node n){
        return n.cost-this.cost;
    }
}