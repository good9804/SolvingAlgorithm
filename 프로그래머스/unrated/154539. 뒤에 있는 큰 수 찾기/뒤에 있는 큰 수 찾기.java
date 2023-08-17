import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        PriorityQueue<Node> pq=new PriorityQueue<>();
        for(int i=0;i<numbers.length;i++){
            pq.add(new Node(i,numbers[i]));
        }
        Arrays.fill(answer,-1);
        while(!pq.isEmpty()){
            Node n=pq.poll();
            for(int i=n.index-1;i>=0;i--){
                if(numbers[i]>=n.cost){break;}
                answer[i]=n.cost;
            }
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
        if(this.cost==n.cost){
            return n.index-this.index;
        }else return n.cost-this.cost;
    }
}