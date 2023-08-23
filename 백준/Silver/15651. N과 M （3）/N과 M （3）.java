
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    static int N;
    static int M;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dfs(new StringBuilder(),0);
        System.out.print(stringBuilder.substring(0,stringBuilder.length()-1));
    }
    static void dfs(StringBuilder sb,int current){
        if(current>=M){
            stringBuilder.append(sb+"\n");
            return;
        }
        for(int i=1;i<=N;i++){
            dfs(new StringBuilder(sb).append(i+" "),current+1);
        }
    }
}
