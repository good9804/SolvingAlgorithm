import java.io.*;

import java.util.*;
import java.lang.String;

public class Main {
    public static void main(String args[]) throws IOException {

        Queue<Integer> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int k=sc.nextInt();
        for(int i=1;i<=k;i++){
           queue.add(i);
        }
        while(queue.size()!=1){
            queue.poll();
            int a= queue.peek();
            queue.poll();
            queue.add(a);


        }
        System.out.println(queue.peek());


    }
    }