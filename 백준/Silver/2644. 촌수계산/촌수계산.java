import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {
    static boolean[][] pan;
    static boolean[][] isChecked;
    static int max;
    static int size;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        pan = new boolean[size+1][size+1];
        isChecked= new boolean[size+1][size+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int temp1 = Integer.parseInt(st.nextToken());
        int temp2 = Integer.parseInt(st.nextToken());
        int test = Integer.parseInt(br.readLine());
        max=-1;
        for(int i=0;i<test;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pan[a][b]=true;
            pan[b][a]=true;
        }
        find(temp1,temp2,0);
        System.out.println(max);

    }
public static void find(int temp1,int temp2,int current){
        if(temp1==temp2){
            max=current;
            return;
        }
       for(int i=1;i<=size;i++){
           if(pan[temp1][i]&&!isChecked[temp1][i]){
               isChecked[temp1][i]=true;
               isChecked[i][temp1]=true;
               find(i,temp2,current+1);

           }
       }

}}