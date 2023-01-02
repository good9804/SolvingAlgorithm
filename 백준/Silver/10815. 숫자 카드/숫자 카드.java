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
        StringBuilder sb=new StringBuilder();
        int size = Integer.parseInt(br.readLine());
        int[] sang=new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<size;i++){
            sang[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sang);
        st = new StringTokenizer(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            if(Arrays.binarySearch(sang,Integer.parseInt(st.nextToken()))>=0){
                sb.append(1).append(" ");
            }else sb.append(0).append(" ");
        }
        System.out.println(sb);
}}