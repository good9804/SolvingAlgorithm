
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

class Main {
    static int N;
    static int[] dx={1,-1,-1,1};
    static int[] dy={1,-1,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr=new int[N+1];
        ArrayList<Integer>[] list=new ArrayList[N+1];
         int[] answer=new int[N+1];
         for(int i=1;i<=N;i++){
             list[i]=new ArrayList<>();
         }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[A].add(B);
            arr[B]++;
        }
        Queue<Integer> q=new LinkedList<>();

        for(int i=1;i<=N;i++){
            if(arr[i]==0){
                q.add(i);
                answer[i]=1;
            }
        }
        int count=1;
        while(!q.isEmpty()){
            count++;
            int qsize=q.size();
            for(int i=0;i<qsize;i++){
            int cur=q.poll();
            for(int next:list[cur]){
                arr[next]--;
                if(arr[next]==0){
                    answer[next]=count;
                    q.add(next);
                }
            }

            }

        }
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=N;i++){
            sb.append(answer[i]+" ");
        }
        System.out.println(sb);














    }
}



