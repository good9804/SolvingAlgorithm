
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import java.util.*;

class Main {
    static int[] arr;
    static int answer;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end=Integer.parseInt(st.nextToken());
        arr=new int[200001];
        visited=new boolean[200001];
        arr[start]=0;
        visited[start]=true;

        if(start>=end){
            System.out.println(start-end);
            return;
        }
        Queue<Num> q=new LinkedList<>();
        q.add(new Num(start,0));
        while (!q.isEmpty()){
            int qsize=q.size();
            for(int i=0;i<qsize;i++){
                Num n=q.poll();
                if(n.loc==end){
                    System.out.println(arr[end]);
                    return;
                }
                if(n.loc*2<=end*2&&!visited[n.loc*2]){
                q.add(new Num(n.loc*2,0));
                arr[n.loc*2]=arr[n.loc];
                visited[n.loc*2]=true;
                }

                if(n.loc-1>=0&&!visited[n.loc-1]){
                q.add(new Num(n.loc-1,1));
                arr[n.loc-1]=arr[n.loc]+1;
                    visited[n.loc-1]=true;}
                if(n.loc+1<=end*2&&!visited[n.loc+1]){
                q.add(new Num(n.loc+1,1));
                    arr[n.loc+1]=arr[n.loc]+1;
                    visited[n.loc+1]=true;}
            }
        }
    }
    }
class Num{
    int loc;
    int hapgop;
    public Num(int loc,int hapgop){
        this.loc=loc;
        this.hapgop=hapgop;
    }
}

