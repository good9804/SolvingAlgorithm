
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size=Integer.parseInt(st.nextToken());
        int[] arr=new int[size];
        int answer = Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<size;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result=0;
        int index1=0;
        int index2=0;
        int sum=0;
        while(true){
            if(answer>sum){
                if(index2==size)
                    break;
                sum += arr[index2++];
            } else if(answer==sum){
                result++;
                sum-=arr[index1++];
            } else{
                sum-=arr[index1++];
            }
        }
        System.out.println(result);
    }
}