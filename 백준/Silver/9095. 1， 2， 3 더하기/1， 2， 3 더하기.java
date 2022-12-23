import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
class Main {
    static int[] pan=new int[12];
    public static void main(String[] args) throws IOException{
        pan[1]=1;
        pan[2]=2;
        pan[3]=4;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test=Integer.parseInt(br.readLine());
        int num=4;
        while(num!=11){
        pan[num]=pan[num-3]+pan[num-2]+pan[num-1];
            num++;
        }
        
        for(int i=0;i<test;i++){
            num=Integer.parseInt(br.readLine());
            System.out.println(pan[num]);
        }
        
    }
}