import java.io.*;
import java.util.*;
import java.lang.String;
public class Main {
    public static void main(String args[]) throws  java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k=Integer.parseInt(br.readLine());
        int stack[] = new int[k];
        int front=0;
        int size=0;
        for(int i=0; i<k;i++){
            String str=br.readLine();
            String order[]=str.split(" ");
            if(order[0].equals("push_front"))
            {
                if (size == 0) {
                    stack[0]=Integer.parseInt(order[1]);
                    size++;
                }
                else
                {int x=size;
                    for(int j=0;j<size;j++) {

                    stack[x] = stack[x - 1];
                    x--;}
                    stack[0] = Integer.parseInt(order[1]);
                    size++;

                }
                }


            else if(order[0].equals("push_back")){
                stack[size]=Integer.parseInt(order[1]);
                size++;
            }

            else if(order[0].equals("pop_front")){
                if(size==0){
                    System.out.println("-1");

                }else
                {System.out.println(stack[0]);
                    for(int index=0;index<size;index++){
                        stack[index]=stack[index+1];
                    }
                    size--;}}
            else if(order[0].equals("pop_back")){
                if(size==0){
                    System.out.println("-1");

                }else
                {System.out.println(stack[size-1]);
                    stack[size-1]=0;
                    size--;}}
            else if(order[0].equals("empty")){
                if(size==0){
                    System.out.println("1");
                }else System.out.println("0");
            }
            else if(order[0].equals("size")){
                System.out.println(size);
            }
            else if(order[0].equals("front")){
                if(size==0){
                    System.out.println("-1");

                }else System.out.println(stack[0]);
            }
            else if(order[0].equals("back")){
                if(size==0){
                    System.out.println("-1");

                }else System.out.println(stack[size-1]);
            }
        }
    }}