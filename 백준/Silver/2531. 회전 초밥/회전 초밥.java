
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
        arr=new int[size];
        int a = Integer.parseInt(st.nextToken());
        int term = Integer.parseInt(st.nextToken());
        int coupon = Integer.parseInt(st.nextToken());

        for(int i=0;i<size;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        boolean iscoupon=false;
        for(int i=0;i<term;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            if(arr[i]==coupon){
                iscoupon=true;
            }
        }
        int answer=0;
        if(!iscoupon&&map.size()==term){
            System.out.println(term+1);
            return;
        }else if(iscoupon){
            answer=map.size();
        }
        int start=0;
        int end=term-1;

        while(start<size){
            if(map.get(arr[start])>=2){
                map.replace(arr[start],map.get(arr[start]),map.get(arr[start])-1);
            }else map.remove(arr[start]);
            start++;
            end++;

            if(end>=size){
                end=0;
            }
            if(map.containsKey(arr[end])){
                map.put(arr[end],map.get(arr[end])+1);
            }else map.put(arr[end],1);
            if(map.containsKey(coupon)){
                answer=Math.max(map.size(),answer);
            }
            else{
                answer=Math.max(map.size()+1,answer);
            }

        }
        System.out.println(answer);






    }

    }









