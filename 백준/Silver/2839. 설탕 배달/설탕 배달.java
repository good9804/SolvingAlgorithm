import java.io.*;
import java.util.*;
import java.lang.String;
import  java.util.Comparator;
public class Main {
    public static void main(String args[]) throws  java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int min=5000;
        int cnt;
        int count=0;
         for(int i=0;i<=k/5;i++)
         {
             for(int j=0;j<=k/3;j++){
                 if((i*5)+(j*3)==k){
                     if(count==0){
                         min=i+j;
                     }
                     cnt=i+j;
                     min=Math.min(min,cnt);
                     count++;
                 }

             }
         }
         if(count==0){
             System.out.println("-1");
         }
        else System.out.println(min);

        }
    }