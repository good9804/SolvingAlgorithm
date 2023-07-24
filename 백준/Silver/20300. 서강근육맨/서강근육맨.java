
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.List;


class Main{
    static int size;
    static long[] muscleArr;
    static int max=Integer.MIN_VALUE;
    static int maxindex=-1;
    static long M=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        muscleArr=new long[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<size;i++){
            muscleArr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(muscleArr);

        if(size%2==1){
            M=muscleArr[size-1];
            find(0,size-2);
        }
        else{
            find(0,size-1);
        }
        System.out.println(M);

    }
    static void find(int start,int end){
        while(start<end){
            if(muscleArr[start]+muscleArr[end]>M){
                M=muscleArr[start]+muscleArr[end];
            }
            start++;
            end--;
        }
    }
    }


