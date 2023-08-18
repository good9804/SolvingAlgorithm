import java.util.*;
class Solution {
    static boolean[][] connected;
    static ArrayList<Integer>[] arr;
    static int[] dp;
    static HashMap<Integer,Integer> map=new HashMap<>();
    static int[] answer;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        arr=new ArrayList[n+1];
        answer=new int[sources.length];
        for(int i=1;i<=n;i++){
            arr[i]=new ArrayList<>();
            
        }
        for(int i=0;i<roads.length;i++){
            arr[roads[i][0]].add(roads[i][1]);
            arr[roads[i][1]].add(roads[i][0]);
            
        }
        
        
        
        
        Arrays.fill(answer,-1);
        for(int i=0;i<sources.length;i++){
            map.put(sources[i],i);
            if(sources[i]==destination){
                answer[i]=0;
            }
        }
        bfs(destination,n);
        for(int i=0;i<answer.length;i++){
            
        }
        return answer;
    }
    static void bfs(int current,int n){
        Queue<Integer> q=new LinkedList<>();
        boolean[] isVisited=new boolean[n+1];
        q.add(current);
        isVisited[current]=true;
        int count=0;
        while(!q.isEmpty()){
            int qsize=q.size();
            count++;
            for(int i=0;i<qsize;i++){
            
            int temp=q.poll();
                if(map.containsKey(temp)){
                    answer[map.get(temp)]=count-1;
                }
            for(int next:arr[temp]){
                if(!isVisited[next]){
                    isVisited[next]=true;
                    q.add(next);
                }
            }
            }
        }
        
        
    }
}