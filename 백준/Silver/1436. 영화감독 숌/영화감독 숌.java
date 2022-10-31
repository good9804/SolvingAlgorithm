import java.io.*;
import java.util.*;
import java.lang.String;
public class Main {
    public static void main(String args[]) throws  java.lang.Exception {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int num=0;
        while(N>0){
            num++;
            String s=Integer.toString(num);
            if(s.contains("666")){
                N--;
            }
        }
        System.out.println(num);



        }
    }