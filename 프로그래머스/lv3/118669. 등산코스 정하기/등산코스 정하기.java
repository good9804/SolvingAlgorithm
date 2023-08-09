import java.util.*;
class Solution {
    static int N;
    static  boolean[] cantgo;
    static int intesity=0;
    static boolean[] isChecked;
    static ArrayList<Path>[] arr;
    static HashMap<Integer,Integer> summitsMin=new HashMap<>();
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        N=n;
        cantgo=new boolean[N+1];
        isChecked=new boolean[N+1];
        Arrays.sort(summits);
        for(int i=0;i<gates.length;i++){
            cantgo[gates[i]]=true;
        }
        for(int i=0;i<summits.length;i++){
            cantgo[summits[i]]=true;
        }
        arr=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=new ArrayList<Path>();
        }
        int skip=0;
        for(int i=0;i<paths.length;i++){
            int start=paths[i][0];
            int end=paths[i][1];
            int cost=paths[i][2];
            arr[start].add(new Path(start,end,cost));
            arr[end].add(new Path(end,start,cost));
            
                   
               
            
        }
        
        int[] answer = new int[2];
        int minCost=Integer.MAX_VALUE;
        boolean flag=false;
        for(int i=0;i<gates.length;i++){
            int gate=gates[i];
            
                cantgo[gate]=false;
            for(int j=0;j<summits.length;j++){
                int summit=summits[j];
                cantgo[summit]=false;
                intesity=Integer.MAX_VALUE;
                isChecked[gate]=true;
                summitDfs(gate,gate,summit,Integer.MIN_VALUE);
                /*Arrays.fill(isChecked,false);
                isChecked[summit]=true;
                gateDfs(summit,gate,summit,Integer.MIN_VALUE);*/
                
                Arrays.fill(isChecked,false);
                if(intesity<minCost){
                    answer[0]=summit;
                    answer[1]=intesity;
                    minCost=intesity;
                }
                
                cantgo[summit]=true;
            }
                cantgo[gate]=true;
        }
        return answer;
    }
    static void summitDfs(int current,int gate,int summit,int cost){
        if(current== summit){
            intesity=Math.min(intesity,cost);
            return;
        }
        for(Path p :arr[current]){
            if(!isChecked[p.end]&&!cantgo[p.end]){
                isChecked[p.end]=true;
                summitDfs(p.end,gate,summit,Math.max(cost,p.cost));
                isChecked[p.end]=false;
            }
        }     
    }
    static void gateDfs(int current,int gate,int summit,int cost){
        if(current== gate){
            
            intesity=Math.min(intesity,cost);
            return;
        }
        for(Path p :arr[current]){
            if(!isChecked[p.end]&&!cantgo[p.end]){
                isChecked[p.end]=true;
                gateDfs(p.end,gate,summit,Math.max(cost,p.cost));
                isChecked[p.end]=false;
            }
        }     
    }
    
    
}
class Path {
    int start;
    int end;
    int cost;
    public Path(int start,int end,int cost){
        this.start=start;
        this.end=end;
        this.cost=cost;
    }
    
}