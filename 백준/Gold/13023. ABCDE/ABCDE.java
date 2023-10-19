
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

class Main {
    static int max;
    static boolean[] isVisited;
    static boolean flag=false;
    static ArrayList<Integer>[] friends;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
         friends=new ArrayList[N];
        isVisited=new boolean[N];
        for(int i=0;i<N;i++){
            friends[i]=new ArrayList<>();
        }

        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a].add(b);
            friends[b].add(a);
        }
        for(int i=0;i<N;i++){
            if(flag){
                System.out.println(1);
            return;}
            isVisited[i]=true;
            dfs(i,0);
            isVisited[i]=false;
        }
        if(flag){
            System.out.println(1);
            return;
        }
        System.out.println(0);
        return;












    }
    static void dfs(int current,int depth){
        if(flag){return;}
        if(depth>=4){
            flag=true;
            return;
        }
        for(int next:friends[current]){
            if(!isVisited[next]&&!flag){
                isVisited[next]=true;
                dfs(next,depth+1);
                isVisited[next]=false;
            }
        }
    }

}


