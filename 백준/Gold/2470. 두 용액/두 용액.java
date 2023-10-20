
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

class Main {
    static int N;
    static int M;
    static int[] arr;
    static ArrayList<Integer> list=new ArrayList<>();
    static int answer=Integer.MAX_VALUE;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr=new int[N];
        StringTokenizer st=new StringTokenizer(br.readLine());
        int index=0;
        while(st.hasMoreTokens()){
            arr[index++] = Integer.parseInt(st.nextToken());

        }

        Arrays.sort(arr);
        for(int i=0;i<N;i++){
            if(arr[i]>answer){break;}
            binarySearch(arr[i]*-1,i,N-1);
            if(answer==0){
                System.out.println(sb);
                return;
            }
        }


        System.out.println(sb);
    }
    static void binarySearch(int num,int start,int end){

        int left=start;
        int right=end;
         int mid=(left+right)/2;
        while(left<=right){

         mid=(left+right)/2;
        int midnum=arr[mid];
        if(num>midnum){
            left=mid+1;

        }
        else if(num<midnum){
            right=mid-1;
        }
        if(num==midnum&&start!=mid){
            answer=0;
            sb.setLength(0);
            sb.append(num*-1+" "+num);
            return;
        }

        }
        if(isRange(mid-1)){
            if(answer>Math.abs(num-arr[mid-1])){
                answer=Math.abs(num-arr[mid-1]);
                sb.setLength(0);
                sb.append(num*-1+" "+arr[mid-1]);
            }
        }
        if(isRange(mid+1)){
            if(answer>Math.abs(num-arr[mid+1])){
                answer=Math.abs(num-arr[mid+1]);
                sb.setLength(0);
                sb.append(num*-1+" "+arr[mid+1]);
            }
        }
        if(isRange(mid)&&mid!=start){
            if(answer>Math.abs(num-arr[mid])){
                answer=Math.abs(num-arr[mid]);
                sb.setLength(0);
                sb.append(num*-1+" "+arr[mid]);
            }
        }






    }
    static boolean isRange(int x){
        return x>=0&&x<N;
    }

}





