import java.io.*;
import java.util.*;

public class Main {



static int[] arr;
static long[][] sum;
static int test;
    static int n, m;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       test=Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i=1;
        arr=new int[test+1];
        sum=new long[test][21];

        while (st.hasMoreTokens()){
            arr[i++] = Integer.parseInt(st.nextToken());
        }
        sum[1][arr[1]]=1;
        for(int j=1;j<=test-1;j++){
                for(int k=0;k<21;k++){
                    if(arr[j]+k<=20){
                        sum[j][k]+=sum[j-1][arr[j]+k];
                    }
                        if(k-arr[j]>=0){
                            sum[j][k]+=sum[j-1][k-arr[j]];
                        }
                }
        }

        System.out.println(sum[test-1][arr[test]]);



    }
    static void dfs(int index,int hap){
        if(hap<0||hap>20){return;}
        if(index==test){return;}
        int temp=0;
        if(hap-arr[index]>=0){temp+=sum[index-1][hap-arr[index]];}
        if(hap+arr[index]<=20){temp+=sum[index-1][hap+arr[index]];}
        sum[index][hap]=temp;

        if(hap+arr[index+1]<=20){
        dfs(index+1,hap+arr[index+1]);}
        if(hap-arr[index+1]>=0){
        dfs(index+1,hap-arr[index+1]);}


    }





    }

