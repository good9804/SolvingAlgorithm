import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {
    static long[] sumarr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] len = new int[Integer.parseInt(st.nextToken())];
        int l=len.length;
        int[] h = new int[Integer.parseInt(st.nextToken())+1];
        int[] low=new int[h.length];
        int high=h.length;
        for(int i=1;i<=l;i++){
            int temp = Integer.parseInt(br.readLine());
            if(i%2==1){
                    low[temp]++;

            }else {
                    h[temp]++;
                }
            }

        int[] lowsum=new int[high];
        int[] highsum=new int[high];
        int obs=Integer.MAX_VALUE;
        int count=0;

        for(int k=high-2;k>0;k--){
            low[k]+=low[k+1];
            h[k]+=h[k+1];

        }

        for(int i=1;i<high;i++){
            int num=0;
            num+=low[i]+h[high-i];
            if(obs>num){
                obs=num;
                count=1;
            }else if(obs==num){count++;}
            else continue;
        }
        System.out.println(obs+" "+count);
    }
}