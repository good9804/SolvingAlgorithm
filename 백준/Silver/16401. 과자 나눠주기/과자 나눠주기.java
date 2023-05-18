
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import java.util.*;

class Main {
    static int people;
    static int[] arr;
    static long max=Integer.MIN_VALUE;
    static int arrmax=Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        people = Integer.parseInt(st.nextToken());
        int arrsize=Integer.parseInt(st.nextToken());
        arr=new int[arrsize];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<arrsize;i++){
                arr[i]=Integer.parseInt(st.nextToken());
                arrmax=Math.max(arrmax,arr[i]);
        }

        if(binarysearch(people)){
        System.out.println(max);}else System.out.println(0);
    }

    static boolean binarysearch(int answer){
        long start=1;
        long end=arrmax;
        while(start<=end){
            long mid=(start+end)/2;
            int temp=0;
            for(int i=0;i<arr.length;i++){
                temp+=arr[i]/mid;
            }
            if(temp>=answer){
                max=Math.max(mid,max);
                start=mid+1;
            }else{end=mid-1;}

        }
        if(max==Integer.MIN_VALUE){
        return false;}
        else return true;

    }
}








