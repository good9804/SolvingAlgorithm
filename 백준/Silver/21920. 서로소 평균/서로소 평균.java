
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;


class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] arr=new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<size;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        double x = Integer.parseInt(br.readLine());
        double sum=0;
        double count=0;
        for(int i=0;i<size;i++) {
            if(GCD(x,arr[i])==1){
                sum+=arr[i];
                count++;
            }
        }
        if(count==0){
            System.out.printf("0");
        }else{
            System.out.printf("%.6f",sum/count);
        }




    }
    static double GCD(double a,double b){
        if(b==0){return a;}
        return GCD(b,a%b);
    }



}