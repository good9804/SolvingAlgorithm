
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

        int term = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if(size==1){
            System.out.println(1);
            return;
        }
        int max=0;
        int length=1;
        int maxindex=0;
        int answer=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int start=0;
        map.put(arr[start],1);
        int end=1;
        while(start<size&&end<size){
            if(map.containsKey(arr[end])){
                map.put(arr[end],map.get(arr[end])+1);
                if(max<map.get(arr[end])){
                max=map.get(arr[end]);
                maxindex=arr[end];
                }
            }else map.put(arr[end],+1);

            boolean flag=false;
            while(max>term){
                if(map.get(arr[start])>=2){
                    map.put(arr[start],map.get(arr[start])-1);
                    if(maxindex==arr[start]){max--;}
                }else map.remove(arr[start]);
                start++;
                length--;
                flag=true;
            }


            end++;
            length++;
            answer=Math.max(answer,length);

        }
        System.out.println(answer);






    }

    }









