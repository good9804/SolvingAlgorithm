import java.lang.*;
import java.io.*;
import java.lang.reflect.Constructor;
import java.util.*;
import java.math.*;
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        if(num==1){System.out.println(0);return;}
        if(num==3){System.out.println(1);return;}
        if(num==4){System.out.println(0);return;}
        boolean isPrime[]=new boolean[num+1];
        for(int i=2;i<=num;i++) {
            isPrime[i] = true;
        }
        int[] arr=new int[num];
        int index=0;
        for(int i=2;i<=num;i++){

            if(!isPrime[i]){

                continue;}
            for(int j=i*2;j<=num;j+=i){
                isPrime[j]=false;

            }
        }
        for(int i=2;i<=num;i++){
            if(isPrime[i]){arr[index++]=i;}
        }
        int count=0;
        int start=0;
        int end=0;
        int sum=0;
        int end2=0;
        while(true){
                if(arr[start]>num/2){if(num!=3&&isPrime[num]){count++;}break;}
            for(int  i=end2;i<=end;i++){
                sum+=arr[i];
            }
            if(sum>num){
                start++;
                end2=start;
                end=start;
                sum=0;
            }else if(sum<num){

                end++;
                end2=end;

            } else{count++;
                start++;
                end2=start;
                end=start;
            sum=0;}

        }
        System.out.println(count);
    }
    }