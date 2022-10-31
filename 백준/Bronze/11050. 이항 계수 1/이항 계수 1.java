import java.io.BufferedReader;
import  java.util.Scanner;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.lang.String;
import java.lang.Integer;

public class Main {
    public static void main(String args[]) throws IOException{

        Scanner sc=new Scanner(System.in);
       int a= sc.nextInt();
        int b=sc.nextInt();
        int c= 1;
        int q=1;
        int p=1;
        for(int l=1;l<=a-b;l++){
            c=c*l;
        }
        for(int i=1;i<=a;i++){
            q=q*i;
        }
        for(int i=1;i<=b;i++){
            p=p*i;
        }
        System.out.println(q/(p*c));
       }

            }