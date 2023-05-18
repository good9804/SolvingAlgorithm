
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
    static int Asize;
    static int Bsize;
    static int[] A;
    static int[] B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Asize = Integer.parseInt(st.nextToken());
        Bsize = Integer.parseInt(st.nextToken());
        A=new int[Asize];
        B=new int[Bsize];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<Asize;i++){
            A[i]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<Bsize;i++){
            B[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        Arrays.sort(B);
        StringBuilder sb = new StringBuilder();
        int count=0;
        for(int i=0;i<Asize;i++){
            if(!binarysearch(A[i])){
                count++;
                sb.append(A[i]).append(" ");
            }
        }
        if(count==0){
            System.out.println(0);
            return;
        }else{
        System.out.println(count);
        System.out.print(sb);}
    }

    static boolean binarysearch(int answer){
        int start=0;
        int end=Bsize-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(B[mid]>answer){
                end=mid-1;
            }
            else if(B[mid]<answer){start=mid+1;}
            else{return true;}
        }
        return false;

    }
}








