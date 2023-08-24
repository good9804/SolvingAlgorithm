
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    static int N;
    static int M;
    static boolean[] isChecked;
    static int count;
    static boolean flag;
    static ArrayList<Integer>[] connectedList;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int caseCount=0;
        while(true){
            caseCount++;
            StringTokenizer st=new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N==0&&M==0){
                System.out.print(sb.substring(0,sb.length()-1));
                return;
            }
            connectedList=new ArrayList[N+1];
            for(int i=1;i<=N;i++){
                connectedList[i]=new ArrayList<>();
            }
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                connectedList[a].add(b);
                connectedList[b].add(a);
            }
            isChecked=new boolean[N+1];
            count=0;
            for(int i=1;i<=N;i++){
                if(!isChecked[i]){
                    flag=true;
                    isChecked[i]=true;
                    if(connectedList[i].size()==0){count++;continue;}
                    dfs(i,0);
                    if(flag){count++;}
                }
            }
            if(count>1){
                sb.append("Case "+caseCount+": A forest of "+count+" trees."+"\n");
            }
            else if(count==1){
                sb.append("Case "+caseCount+": There is one tree."+"\n");
            }
            else{
                sb.append("Case "+caseCount+": No trees."+"\n");
            }



        }


}
static void dfs(int current,int prev){
        for(int next:connectedList[current]){
            if(!flag){return;}
            if(!isChecked[next]){
                isChecked[next]=true;
                dfs(next,current);
            }else if(isChecked[next]&&next!=prev){
                flag=false;
                return ;
            }
        }
    }
}
