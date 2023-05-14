
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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] notdigit=new boolean[4000001];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=2;i<=4000000;i++){
            if(!notdigit[i]){
                list.add(i);
                int temp=2;
                while(true){
                    int j=temp*i;
                    if(j>4000000){break;}
                    notdigit[j]=true;
                    temp++;
                }
            }
        }
        int start=0;
        int end=1;
        int num = Integer.parseInt(br.readLine());
        if(num==1){
            System.out.println(0);return;
        }
        int sum=0;
        if(!notdigit[num]){sum++;}

        int current=0;
        current=list.get(start)+list.get(end);
        while(start<end&&end<list.size()){
            if(list.get(start)>num){break;}
            if(current==num){sum++;

                current-=list.get(start);
                start++;}
            else if(current>num){
                current-=list.get(start);
                start++;
            }
            else{
                end++;
                current+=list.get(end);
            }
        }
        System.out.println(sum);
        }
    }








