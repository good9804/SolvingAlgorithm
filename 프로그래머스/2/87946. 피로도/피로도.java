class Solution {
    static int max=0;
    static boolean[] Visited;
    public int solution(int k, int[][] dungeons) {
        Visited=new boolean[dungeons.length];
        dfs(k,0,dungeons);
        
        return max;
    }
    
    static void dfs(int currentpiro,int count,int[][] dungeons){
        for(int i=0;i<Visited.length;i++){
            if(!Visited[i]&&currentpiro>=dungeons[i][0]){
                Visited[i]=true;
                dfs(currentpiro-dungeons[i][1],count+1,dungeons);
                Visited[i]=false;
            }
            
            
            
        }
        max=Math.max(count,max);
        
    }
}