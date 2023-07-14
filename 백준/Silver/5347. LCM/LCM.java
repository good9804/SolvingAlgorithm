
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;


class Main{
    static int first;
    static int second;
    static HashMap<Integer, Integer> firstMap = new HashMap<>();
    static HashMap<Integer, Integer> secondMap = new HashMap<>();
    static int MAX=1000000;
    static boolean[] primeArr=new boolean[MAX+1];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        primeFind();
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            firstMap.clear();
            secondMap.clear();
            first = Integer.parseInt(st.nextToken());
            second = Integer.parseInt(st.nextToken());
            sb.append(find()+"\n");
        }
        System.out.print(sb);



    }
    static void primeFind(){
        for(int i=2;i<=MAX/2;i++){
            if(!primeArr[i]){
                int index=1;
                while(true){
                    index++;
                    int number=index*i;
                    if(number<=MAX){
                        primeArr[number]=true;
                    }else{
                        break;
                    }
                }
            }
        }
    }
    static long find(){
        Div(first,true);
        Div(second,false);
        long number=1;
        for(int key: firstMap.keySet()){
            if(secondMap.containsKey(key)){
                number*=Math.pow(key,Math.max(firstMap.get(key),secondMap.get(key)));
            }else{
                number*=Math.pow(key,firstMap.get(key));
            }
        }
        for(int key: secondMap.keySet()){
            if(number%key!=0){
                number*=Math.pow(key,secondMap.get(key));

            }
        }
        return number;



    }
    static void Div(int number,boolean isFirst){
        int tempFirst=number;
        if(isFirst){
            int i=2;
            while(tempFirst!=1){
                if(!primeArr[i]){
                    int count=0;
                    while(tempFirst%i==0){
                        tempFirst/=i;
                        count++;

                    }
                    if(count>0){
                    firstMap.put(i,firstMap.getOrDefault(i,0)+count);}
                }
                i++;
            }
        }else{
            int i=2;
            while(tempFirst!=1){

                if(!primeArr[i]){
                    int count=0;
                    while(tempFirst%i==0){
                        tempFirst/=i;
                        count++;

                    }
                    if(count>0){
                        secondMap.put(i,secondMap.getOrDefault(i,0)+count);}
                }
                i++;
            }
        }
    }
}