
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
    static long sum=0;
    static boolean[] isChecked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        arr = new int[size];
        isChecked = new boolean[size];
        int index = 0;
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if(sum==size){
                    System.out.println(size);return;
                }
                int answer = arr[i] + arr[j];
                    binarysearch(0, answer,i,j);

            }


        }

        System.out.println(sum);

    }
    static void binarysearch(int startindex,int answer,int first,int second){
        int start=startindex;
        int end=size-1;
        int lower=-1;
        while(start<end){
            int mid=(start+end)/2;

            if(arr[mid]>=answer){
                end=mid;
            }else start=mid+1;
        }
        lower=end;
        start=startindex;
        end=size-1;
        int upper=-1;
        while (start<end){
        int mid=(start+end)/2;
        if(answer>=arr[mid]){
        start=mid+1;}else end=mid;
        }
        upper=end;
        if(lower>=0&&upper>=0){
            if(arr[upper]==answer){
            for(int i=lower;i<=upper;i++){
                if(!isChecked[i]&&i!=first&&i!=second){
                    sum++;
                    isChecked[i]=true;
                }
            }}else{
                for(int i=lower;i<upper;i++){
                    if(!isChecked[i]&&i!=first&&i!=second){
                        sum++;
                        isChecked[i]=true;
                    }
                }
            }
        }

        }

    }









