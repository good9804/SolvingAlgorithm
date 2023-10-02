
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

class Main {




    public static void main(String[] args) throws IOException{
    //1~m 까지 n개의숫 , 각숫자는 이전에 고른숫자의 최소2개
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] pan=new int[N+1][M+1];
        int[][] up=new int[N+1][M+1];
        int[][] down=new int[N+1][M+1];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++){
                pan[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        up[N][1]=pan[N][1];//start
        down[N][M]=pan[N][M];//end
        for(int i=N;i>=1;i--){
            if(i!=N){
                up[i][1]=up[i+1][1]+pan[i][1];
            }


            for(int j=2;j<=M;j++){
                if(i==N){
                    up[i][j]=up[i][j-1]+pan[i][j];
                }
                else{up[i][j]=Math.max(up[i+1][j],up[i][j-1])+pan[i][j];}
            }
        }
        for(int i=N;i>=1;i--){
            if(i!=N){down[i][M]=down[i+1][M]+pan[i][M];}

            for(int j=M-1;j>=1;j--){
                if(j==M){
                    if(i==N){continue;}
                    down[i][j]=down[i+1][j]+pan[i][j];
                }
                else if(i==N){
                    down[i][j]=down[i][j+1]+pan[i][j];

                }else{
                    down[i][j]=Math.max(down[i+1][j],down[i][j+1])+pan[i][j];
                }



            }
        }

        int max=Integer.MIN_VALUE;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                max=Math.max(max,up[i][j]+down[i][j]);
            }
        }
        System.out.println(max);

    }













}





