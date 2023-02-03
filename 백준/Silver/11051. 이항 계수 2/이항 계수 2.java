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
        StringTokenizer st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        long[][] arr=new long[a+1][a+1];

        arr[0][0]=1;
        for(int i=1;i<=a;i++){
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                   arr[i][j]=1;
                }
              else arr[i][j]+=(arr[i-1][j-1]+arr[i-1][j])%10007;
            }
        }
        System.out.println(arr[a][b]);

}}