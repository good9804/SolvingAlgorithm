

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;


class Main{

    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int allCount=0;
        arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            allCount+=arr[i];
        }
        long answer=Integer.MIN_VALUE;
        long hap=allCount-arr[0];
        long twoHap=allCount-arr[0];
        for(int i=1;i<N;i++){

            twoHap-=arr[i];
            //맨처음고정된애 + 움직이는애
            if(i==1){
                answer=Math.max((hap-arr[i])*2,answer);
            }else{
                answer=Math.max((hap-arr[i]+twoHap),answer);


            }

        }
        hap=allCount-arr[N-1];
        twoHap=allCount-arr[N-1];
        for(int i=N-2;i>=0;i--){
            //맨처음고정된애 + 움직이는애
            twoHap-=arr[i];
            if(i==N-2){
                answer=Math.max((hap-arr[i])*2,answer);
            }else{
                answer=Math.max((hap-arr[i]+twoHap),answer);
            }

        }
        int middleCount=allCount-arr[0]-arr[N-1];
        for(int i=1;i<N-1;i++){
            answer=Math.max(middleCount+arr[i],answer);
        }
        System.out.println(answer);








    }
}









