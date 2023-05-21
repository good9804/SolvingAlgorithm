
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
        size = Integer.parseInt(br.readLine());
        int vipcount = Integer.parseInt(br.readLine());
        int[] dp=new int[size+1];
        if(size>1){
        dp[1]=1;
        dp[2]=2;}
        int sum=1;
        int[] vip = new int[vipcount];
        for(int i=0; i<vipcount;i++){

            vip[i] = Integer.parseInt(br.readLine());
        }
        if(size==1){
            System.out.println(1);return;
        }
        if(size==2){
            if(vipcount==0){
                System.out.println(2);
                return;
            }else{
                System.out.println(1);
                return;
            }
        }

        int first=0;
        int end=-1;
        if(vipcount==0){
            int k=3;
            while (true){
                dp[k]=dp[k-2]+dp[k-1];
                if(k>=size){
                    System.out.println(dp[k]);
                    return;
                }
                k++;
            }
        }
        if(vipcount==size){
            System.out.println(1);return;
        }
        for(int i=0;i<=vip.length;i++){
            if(i==0){
                if(dp[vip[first]-1]==0){
                    int k=3;
                    while(true){

                        dp[k]=dp[k-2]+dp[k-1];
                        if(k>=vip[first]-1){

                            break;}
                        k++;
                    }
                }

                if(dp[vip[first]-1]>0){
                    sum*=dp[vip[first]-1];}
                first++;
                end++;
                continue;
            }
            if(first>=vipcount){
                if(dp[size-vip[end]]==0){
                    int k=3;
                    while(true){

                        dp[k]=dp[k-2]+dp[k-1];
                        if(k>=size-vip[end]){

                            break;}
                        k++;
                    }}

                    if(dp[size-vip[end]]>0){
                    sum*=dp[size-vip[end]];}

                break;
            }
            if(dp[vip[first]-vip[end]-1]==0){
                int k=3;
                while(true){

                    dp[k]=dp[k-2]+dp[k-1];
                    if(k>=vip[first]-vip[end]-1){

                        break;}
                    k++;
                }

            }
            if(dp[vip[first]-vip[end]-1]>0){
                sum*=dp[vip[first]-vip[end]-1];}
            first++;
            end++;
            continue;



            }


        System.out.println(sum);

    }

    }









