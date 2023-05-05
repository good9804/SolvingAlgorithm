
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import java.util.*;

class Main {
    static int[] arr;
    static int answer;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S=br.readLine();
        StringBuilder T=new StringBuilder(br.readLine());

        Queue<StringBuilder> Q=new LinkedList<>();
        Q.add(T);
        while(!Q.isEmpty()){
            StringBuilder temp=Q.poll();
            if(temp.length()==S.length()){
                if(temp.toString().equals(S)){
                    System.out.println(1);
                    return;
                }
                continue;
            }
            if(temp.charAt(temp.length()-1)=='A'){
                Q.add(new StringBuilder(temp.substring(0,temp.length()-1)));
            }
            if(temp.charAt(0)=='B'){
                StringBuilder temp2=new StringBuilder(temp.substring(1));
                Q.add(new StringBuilder(temp2.reverse()));
            }

        }
        System.out.println(0);

}}

