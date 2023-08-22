
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    static int N;
    static int score;
    static int M;
    static int P;
    static int answer;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer=Integer.MAX_VALUE;
        for(int i=0;i<M;i++){
            dfs(0,0,i,0);
        }
        System.out.println(answer);

    }
    static boolean isRange(int index){
        return index>=0&&index<M;
    }
    static void dfs(int current,int hei,int wid,int prev){
        if(hei>=N){
            answer=Math.min(current,answer);
            return;
        }
        if(hei==0){
            if(isRange(wid-1)){
                dfs(current+arr[hei][wid],hei+1,wid-1,0);
            }
                if(isRange(wid)){
                    dfs(current+arr[hei][wid],hei+1,wid,1);
                }
                    if(isRange(wid+1)){
                        dfs(current+arr[hei][wid],hei+1,wid+1,2);
                    }
        }
        else{
            if(prev==2){
            if(isRange(wid-1)){
            dfs(current+arr[hei][wid],hei+1,wid-1,0);}
            if(isRange(wid)){
                dfs(current+arr[hei][wid],hei+1,wid,1);
            }
        }
        else if(prev==1){
            if(isRange(wid-1)){
                dfs(current+arr[hei][wid],hei+1,wid-1,0);}
            if(isRange(wid+1)){
                dfs(current+arr[hei][wid],hei+1,wid+1,2);
            }
        }
        else{
                dfs(current+arr[hei][wid],hei+1,wid,1);
            if(isRange(wid+1)){
                dfs(current+arr[hei][wid],hei+1,wid+1,2);
            }
        }
        }
    }




    }
