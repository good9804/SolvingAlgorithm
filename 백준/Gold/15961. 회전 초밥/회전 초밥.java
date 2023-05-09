
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import java.util.*;

class Main {
    static int size;
    static int[][] values;
    static int min=Integer.MAX_VALUE;
    static ArrayList<Integer>[] friends;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        size = Integer.parseInt(stringTokenizer.nextToken());
        int max = Integer.parseInt(stringTokenizer.nextToken());
        int term = Integer.parseInt(stringTokenizer.nextToken());
        int coupon = Integer.parseInt(stringTokenizer.nextToken());
        int[] sushi=new int[size+term];
        for(int i=0;i<size;i++){
            sushi[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0;i<term;i++){
            sushi[size+i]=sushi[i];
        }
        int[] current=new int[size+term];
        int start=0;
        int end=term;
        int answer=term;
        boolean flag=false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<term;i++){
            map.put(sushi[i],map.getOrDefault(sushi[i],0)+1);
        }
        if(map.size()==term&&!map.containsKey(coupon)){
            System.out.println(term+1);return;
        }
        int result=0;
        while(start<size){
            if(map.get(sushi[start])==1){
                map.remove(sushi[start]);}
            else{map.replace(sushi[start],map.get(sushi[start])-1);}
            map.put(sushi[end],map.getOrDefault(sushi[end],0)+1);
            if(!map.containsKey(coupon)){
                result=Math.max(result,map.size()+1);
            }else result=Math.max(result,map.size());

            start++;
            end++;
            }


        System.out.println(result);
            }}






