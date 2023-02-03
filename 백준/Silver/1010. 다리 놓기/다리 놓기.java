import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        long[][] arr=new long[30+1][31];

        arr[0][0]=1;
        for(int i=1;i<=30;i++){
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                   arr[i][j]=1;
                }
              else arr[i][j]+=(arr[i-1][j-1]+arr[i-1][j]);
            }
        }
        for(int i=0;i<test;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(arr[b][a]);
        }
}}


