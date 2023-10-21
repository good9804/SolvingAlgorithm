
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.List;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr=new int[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] lisDp=new int[N+1];
        int answer=Integer.MIN_VALUE;
        for(int i=1;i<=N;i++){
            lisDp[i]=1;
            for(int j=1;j<i;j++){
                if(arr[i]>arr[j]&&lisDp[j]>=lisDp[i]){
                    lisDp[i]=lisDp[j]+1;
                }
            }
            answer=Math.max(answer,lisDp[i]);
        }
        System.out.println(N-answer);




    }
}




