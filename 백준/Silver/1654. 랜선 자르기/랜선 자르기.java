
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
    static int size;
    static int[] arr;
    static long max=Integer.MIN_VALUE;
    static int arrmax = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        arr=new int[size];
        int answer = Integer.parseInt(st.nextToken());
        for(int i=0;i<size;i++){
            arr[i] = Integer.parseInt(br.readLine());
            arrmax=Math.max(arr[i],arrmax);
        }
        if(size==1){
            System.out.println(arr[0]/answer);
            return;
        }

        binarysearch(answer);
        System.out.println(max);
    }

    static void binarysearch(int answer){
        long start=1;
        long end=arrmax;

        while(start<=end){
            long mid=(start+end)/2;
            int temp=0;
            for(int i=0;i<size;i++){
                temp+=arr[i]/mid;
            }
            if(temp>=answer){
                start=mid+1;
                max=Math.max(max,(mid));
            }
            else if(temp<answer){
                end=mid-1;
            }
                /*while(true){
                    mid++;
                    temp=0;
                    for(int i=0;i<size;i++){
                        temp+=arr[i]/mid;
                    }
                    if(temp!=answer){
                        max=Math.max(max,mid-1);
                        return;
                    }
                }*/







        }

    }
}








