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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size=Integer.parseInt(st.nextToken());
        long[] arr=new long[size];
        long answer = Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        long max=0;
        for(int i=0;i<size;i++){
            arr[i] = Long.parseLong(st.nextToken());
            if(max<arr[i]){
                max=arr[i];
            }
        }
        long cent=0;
        int result=0;
        long index1=0;
        long index2=max;
        long sum=0;

        while(index1<=index2){
            cent=(index1+index2)/2;


            for(int i=0;i<arr.length;i++){
                if(arr[i]>cent){
                    sum+=arr[i]-cent;
                }
            }
            if(sum>=answer){
                index1=cent+1;
            }
            else if(sum<answer){
                index2=cent-1;
            }
            sum=0; }
        System.out.println(index2);
}}