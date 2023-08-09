import java.util.*;
class Solution {
    static int N;
    static  boolean[] cantgo;
    static int intesity=0;
    static boolean[] isChecked;
    static int[] result;
    static ArrayList<Path>[] arr;
    static HashMap<Integer,Integer> summitsMin=new HashMap<>();
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        N=n;
        boolean[] isGate=new boolean[N+1];
        boolean[] isSummit=new boolean[N+1];
        isChecked=new boolean[N+1];
        Arrays.sort(summits);
        for(int i=0;i<gates.length;i++){
            isGate[gates[i]]=true;
        }
        for(int i=0;i<summits.length;i++){
            isSummit[summits[i]]=true;
        }
        arr=new ArrayList[n+1];
        result=new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=new ArrayList<Path>();
        }
        for(int i=0;i<paths.length;i++){
            int start=paths[i][0];
            int end=paths[i][1];
            int cost=paths[i][2];
            if(isGate[start]||isSummit[end]){
                arr[start].add(new Path(start,end,cost));
            }else if(isGate[end]||isSummit[start]){
            arr[end].add(new Path(end,start,cost));
            }else{
            arr[start].add(new Path(start,end,cost));
            arr[end].add(new Path(end,start,cost));}
        }
        
        int[] answer = new int[2];
        int minCost=Integer.MAX_VALUE;
                
               djistra(gates,summits);
            for(int summit:summits){
                if(result[summit]<minCost){
                    answer[0]=summit;
                    answer[1]=result[summit];
                    minCost=result[summit];
                }
            }
        
        return answer;
    }
    static void djistra(int[] gates,int[] summits){
        Arrays.fill(result,Integer.MAX_VALUE);
        Queue<Path> q=new LinkedList<>();
        for(int gate:gates){
        q.add(new Path(0,gate,0));
        result[gate]=0;}
        
        while(!q.isEmpty()){
            Path current=q.poll();
            if(result[current.end]<current.cost){continue;}
            
                for(Path p:arr[current.end]){
                    int c=Math.max(p.cost,result[current.end]);
                    if(result[p.end]>c){
                        result[p.end]=c;
                        q.add(new Path(p.start,p.end,c));
                    }
                }
            
        }
        
        
    }
    
    
    
    
    
}
class Path implements Comparable<Path>{
    int start;
    int end;
    int cost;
    public Path(int start,int end,int cost){
        this.start=start;
        this.end=end;
        this.cost=cost;
    }
    @Override
    public int compareTo(Path p){
        return this.cost-p.cost;
    }
    
}