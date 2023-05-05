
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int chai = Integer.parseInt(st.nextToken());
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int answer=Integer.MAX_VALUE;
        int start=0;
        int end=0;
        while(start<=end&&end<size){
            if(arr[end]-arr[start]>chai){

                answer=Math.min(answer,arr[end]-arr[start]);
                start++;
                continue;
            }else if(arr[end]-arr[start]==chai){
                System.out.println(chai);
                return;
            }
            else{
                end++;

            }
        }
        System.out.println(answer);
    }}


