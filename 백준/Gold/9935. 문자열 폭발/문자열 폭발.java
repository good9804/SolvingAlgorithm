import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder(br.readLine());

        String temp=br.readLine();
        int len=temp.length();
        Stack<Character> stack=new Stack<>();
        Stack<Character> stack2=new Stack<>();
        for(int i=0;i<sb.length();i++){

            stack.add(sb.charAt(i));
            if(stack.size()>=len){
                for(int index=0;index<len;index++){
                    char c=stack.pop();
                    stack2.add(c);
                    if(c!=temp.charAt(len-index-1)){
                        int size= stack2.size();
                        for(int k=0;k<size;k++){
                            stack.add(stack2.pop());
                        }
                        stack2.clear();
                        break;
                    }
                }
                stack2.clear();
            }

        }
        StringBuilder answer=new StringBuilder();
        if(stack.isEmpty()){
            System.out.println("FRULA");
            return;
        }
        for(char c:stack){
            answer.append(c);
        }

        System.out.println(answer);
        return;


        }
    }



