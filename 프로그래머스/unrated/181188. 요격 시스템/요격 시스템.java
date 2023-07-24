import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        PriorityQueue<Node> pq=new PriorityQueue<>();
        for(int i=0;i<targets.length;i++){
            pq.add(new Node(targets[i][0],targets[i][1]));
        }
        int last=pq.poll().right;
        while(!pq.isEmpty()){
            Node n=pq.poll();
            
            if(last<=n.left){
                answer++;
                last=n.right;
            }
        }
        return answer+1;
    }
}
class Node implements Comparable<Node>{
    int left;
    int right;
    public Node(int left,int right){
        this.left=left;
        this.right=right;
    }
    
    @Override
    public int compareTo(Node n){
        if(this.right==n.right){
            return this.left-n.left;
        }
        else{ return this.right-n.right;}
    }
}