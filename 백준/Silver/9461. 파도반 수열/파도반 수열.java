import java.lang.*;
import java.util.*;
import java.io.*;
import java.math.*;

class Main{
    static BigInteger[] pado=new BigInteger[101];
    static BigInteger zero=new BigInteger("0");
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        pado[1]=BigInteger.valueOf(1);
        pado[2]=BigInteger.valueOf(1);
        pado[3]=BigInteger.valueOf(1);
        int testSize=Integer.parseInt(br.readLine());
        for(int i=0;i<testSize;i++){
            int N=Integer.parseInt(br.readLine());
            for(int k=4;k<=N;k++){
                    pado[k]=pado[k-3].add(pado[k-2]);
                
            }
            System.out.println(pado[N]);
        }

    }

}