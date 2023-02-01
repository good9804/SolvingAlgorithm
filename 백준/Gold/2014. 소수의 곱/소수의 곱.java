
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {
    static long[] sumarr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        long[] arr = new long[size];
        int result = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> pq=new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        int k=0;
        while(st.hasMoreTokens()){
            long temp=Long.parseLong(st.nextToken());
            arr[k++]=temp;
            pq.add(temp);

        }
        long num=0;
        for(int i=0;i<result;i++){
            num=pq.poll();
            for(int j=0;j<arr.length;j++){
                long temp2=num*arr[j];

                pq.add(temp2);
                if(num%arr[j]==0){
                    break;
                }
            }
        }
        System.out.println(num);
    }
}