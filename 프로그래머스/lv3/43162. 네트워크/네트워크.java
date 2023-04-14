class Solution {
    static int[] parent;
    public int solution(int n, int[][] computers) {
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if((i!=j)&&computers[i][j]==1){
                if(find(parent[i])!=find(parent[j])){
                    union(i,j);
                }
                }
            }
        }
        int answer=0;
        for(int i=0;i<n;i++){
            System.out.println(parent[i]);
            if(parent[i]==i){answer++;}
        }
        return answer;
    }
    static void union(int a,int b){
        a=find(a);
        b=find(b);
        parent[a]=b;
    }
    static int find(int a){
        if(a==parent[a]){return a;}
        else return a=find(parent[a]);
    }
}