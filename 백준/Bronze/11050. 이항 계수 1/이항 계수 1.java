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
        
        int temp=1;
        int k=1;
        int j=1;
        for(int i=1;i<=a;i++){
            temp*=i;
        }
        for(int i=1;i<=a-b;i++){
            k*=i;
        }
        for(int i=1;i<=b;i++){
            j*=i;
        }
        System.out.println(temp/(k*j));

}}


