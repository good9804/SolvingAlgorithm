
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import java.util.*;

class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int connect = Integer.parseInt(st.nextToken());
        int question = Integer.parseInt(st.nextToken());
        boolean[][] fw=new boolean[connect+1][connect+1];
        for(int i=0;i<question;i++){
            st = new StringTokenizer(br.readLine());
            int first=Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            fw[first][end]=true;
        }
        for(int i=1;i<=connect;i++){
            for(int j=1;j<=connect;j++){
                for(int k=1;k<=connect;k++){
                    if(fw[j][i]&&fw[i][k]){
                        fw[j][k]=true;
                    }
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        int question2 = Integer.parseInt(br.readLine());
        for(int i=0;i<question2;i++){
            st = new StringTokenizer(br.readLine());
            int first=Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(fw[first][end]){
                sb.append(-1).append("\n");
            }else if(fw[end][first]){
                sb.append(1).append("\n");
            }else sb.append(0).append("\n");
        }
        System.out.print(sb);
    }}


