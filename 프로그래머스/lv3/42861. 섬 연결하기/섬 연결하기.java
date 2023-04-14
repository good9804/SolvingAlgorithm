import java.util.*;
class Solution { 
    static PriorityQueue<Dari> pq;
    static int[] parent;
    public int solution(int n, int[][] costs) {
        pq=new PriorityQueue<>();
        parent=new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
        }
        for(int i=0;i<costs.length;i++){
            int x=costs[i][0];
            int y=costs[i][1];
            int cost=costs[i][2];
            pq.add(new Dari(x,y,cost));
        }
        int answer=0;
        while(!pq.isEmpty()){
            Dari d=pq.poll();
            if(find(d.x)==find(d.y)){continue;}
            else{
                answer+=d.cost;
                union(d.x,d.y);
            }
        }
        
        
        return answer;
    }
    static void union(int x,int y){
        x=find(x);
        y=find(y);
        parent[x]=y;
        
    }
    static int find(int index){
        if(index==parent[index]){return index;}
        else{ return index=find(parent[index]);}
    }
}
class Dari implements Comparable{
    int x;
    int y;
    int cost;
    public Dari(int x,int y,int cost){
        this.x=x;
        this.y=y;
        this.cost=cost;
    }
    @Override
    public int compareTo(Object o){
        Dari d=(Dari) o;
        return this.cost-d.cost;
    }
    
}