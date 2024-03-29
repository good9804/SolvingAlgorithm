
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    static int V;
    static int E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int[][] arr=new int[V+1][V+1];
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a][b]=c;
        }
        for(int i=1;i<=V;i++){
            for(int j=1;j<=V;j++){
                if(i!=j&&arr[i][j]==0){
                    arr[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        for(int k=1;k<=V;k++){
            for(int i=1;i<=V;i++){
                for(int j=1;j<=V;j++){
                    if(arr[i][k]!=Integer.MAX_VALUE&&arr[k][j]!=Integer.MAX_VALUE){
                    arr[i][j]=Math.min(arr[i][j],arr[i][k]+arr[k][j]);}
                }
            }

        }
        int answer=Integer.MAX_VALUE;
        for(int i=1;i<=V;i++){
            for(int j=1;j<=V;j++){
                if(i!=j&&arr[i][j]!=Integer.MAX_VALUE&&arr[j][i]!=Integer.MAX_VALUE){
                    answer=Math.min(arr[i][j]+arr[j][i],answer);
                }
            }
        }
        if(answer==Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(answer);

        }
    }
