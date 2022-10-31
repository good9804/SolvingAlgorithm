

import java.io.*;

import java.util.Arrays;
import java.lang.String;
import java.util.Comparator;
import java.util.StringTokenizer;



public class Main {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(br.readLine());
        StringTokenizer sz=new StringTokenizer(br.readLine()," ");
        int index[]=new int[a];
        for(int i=0;i<a;i++){

            index[i]=Integer.parseInt(sz.nextToken());
        }
        Arrays.sort(index);
        int b = Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        
        for(int i=0;i<b;i++) {

            if(Arrays.binarySearch(index, Integer.parseInt(st.nextToken())) >= 0) {
                sb.append(1).append('\n');
            }
            else {
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
        }}