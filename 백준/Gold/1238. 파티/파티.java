
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.List;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int X=Integer.parseInt(st.nextToken());
        int[][] costs=new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            Arrays.fill(costs[i],987654321);
        }
        while(M-->0){
            st=new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            costs[start][end]=cost;
        }
        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(i==j||i==k||j==k){continue;}
                    costs[i][j]=Math.min(costs[i][j],costs[i][k]+costs[k][j]);
                }
            }
        }
        int answer=Integer.MIN_VALUE;
        for(int i=1;i<=N;i++){
            if(i==X){continue;}
            if(costs[i][X]!=987654321&&costs[X][i]!=987654321){
                    answer=Math.max(answer,costs[i][X]+costs[X][i]);}


            }

        System.out.println(answer);








    }
}
class Node{
    int x;
}




