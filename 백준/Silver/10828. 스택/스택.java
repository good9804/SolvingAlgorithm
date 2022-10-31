import java.io.*;
import java.util.*;
import java.lang.String;
public class Main {
    public static void main(String args[]) throws  java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k=Integer.parseInt(br.readLine());
        int stack[] = new int[k];

        int tmp=0;
        for(int i=0; i<k;i++){
            String str=br.readLine();
            String order[]=str.split(" ");
            if(order[0].equals("push"))
            {
                stack[tmp]=Integer.parseInt(order[1]);

                tmp++;

            }
            else if(order[0].equals("top")){
                if(tmp==0){
                    System.out.println("-1");}
                else {
                    System.out.println(stack[tmp-1]);

            }}
            else if(order[0].equals("pop")){
                if(tmp==0){
                    System.out.println("-1");

                }else
                {System.out.println(stack[tmp-1]);
                    stack[tmp-1]=0;
                    tmp--;}}
            else if(order[0].equals("empty")){
                if(tmp==0){
                    System.out.println("1");
                }else System.out.println("0");
            }
            else if(order[0].equals("size")){
                System.out.println(tmp);
            }
        }
    }}