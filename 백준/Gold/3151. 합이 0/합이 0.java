
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
    static ArrayList<Integer> haparr;
    static StringBuilder sb;
    static boolean iszero=false;
    static long sum=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        arr=new int[size];
        haparr=new ArrayList<>();
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<size;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int k=0;
        /*for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                haparr.add(arr[i]+arr[j]);
            }
        }
        int answer=0;
        Collections.sort(haparr);
        for(int i=0;i<arr.length;i++){
            binarysearch(arr[i]);
        }*/
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            int num=arr[i];
            if(arr[i]>0){break;}
            for(int j=i+1;j<arr.length;j++){
                int num2=arr[j];
                int answer=num+num2;
                if(j+1<arr.length){
                binarysearch(j+1,-answer,num,num2);}
                }
            }

        System.out.println(sum);

    }

    static void binarysearch(int startindex,int answer,int num,int num2){
        int start=startindex;
        int end= arr.length-1;
        int lower=-1;
        while (start<end){
            int mid=(start+end)/2;
            if(answer<=arr[mid]){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }
        lower=end;
        start=startindex;
        end= arr.length-1;
        int upper=-1;
        while (start<end){
            int mid=(start+end)/2;
            if(answer>=arr[mid]){
                start=mid+1;
            }
            else{
                end=mid;
            }
        }
        upper=end;
        if(upper>=0&&lower>=0){
            if(arr[lower]==answer){
                if(arr[lower]==arr[upper]){
                    sum+=upper-lower+1;
                    return;
                }
                sum+=upper-lower;
        }
    }
}}








