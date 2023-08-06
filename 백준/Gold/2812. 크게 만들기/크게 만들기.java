

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;


class Main {

    static int N;
    static int K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        int count=0;
         arr= Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        StringBuilder sb = new StringBuilder();
         for(int i=0;i< arr.length;i++){
             if(stack.isEmpty()){
                 stack.push(arr[i]);
             }else{
                 boolean flag=false;
                 while(count<K){
                     if(!stack.isEmpty()&&stack.peek()<arr[i]){
                         stack.pop();

                         count++;

                     }else if(!stack.isEmpty()&&stack.peek()>arr[i]) {
                         stack.push(arr[i]);
                         flag=true;
                         break;
                     }
                        else{
                         stack.push(arr[i]);
                            break;

                             }
                 }

                 if(count>=K&&!flag){
                     stack.push(arr[i]);}

             }
         }
         while(count<K){
             stack.pop();
             count++;
         }
         while (!stack.isEmpty()){
             sb.append(stack.pop());
         }
        System.out.println(sb.reverse());




    }
}










