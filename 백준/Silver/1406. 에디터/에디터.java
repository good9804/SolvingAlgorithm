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
        StringBuilder sb = new StringBuilder();

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        String str= br.readLine();
        for(int k=0;k<str.length();k++){
            leftStack.push(str.charAt(k));
        }
        int size = Integer.parseInt(br.readLine());
        for(int i=0;i<size;i++){
            String[] arr=br.readLine().split(" ");
            if(arr[0].equals("P")){
                leftStack.push(arr[1].charAt(0));

            }else if(arr[0].equals("L")){
                if(!leftStack.isEmpty()){
                    rightStack.push(leftStack.pop());
                }
            }else if(arr[0].equals("D")){

                if(!rightStack.empty()){
                    leftStack.push(rightStack.pop());
                }
            }else{
                if(!leftStack.empty()){
                    leftStack.pop();
                }
        }
}while(!leftStack.isEmpty()){
                rightStack.push(leftStack.pop());
            }
            while(!rightStack.isEmpty()){
                sb.append(rightStack.pop());
            }
        System.out.println(sb);
    }}