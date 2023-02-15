
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {
    static int[] arr;
    static int[] tree;
    static int logn;
    static int first;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int size=Integer.parseInt(st.nextToken());
        int line=Integer.parseInt(st.nextToken());
        arr=new int[size+1];
        logn=0;
        for(int i=1;i<size;i*=2){
            logn++;
        }
        tree=new int[(int)Math.pow(2,logn+1)];
        first=tree.length/2;
        for(int i=1;i<=size;i++){
            int temp=Integer.parseInt(br.readLine());
            arr[i]=temp;
            tree[first+i-1]=i;
        }
        maketree(1);
        StringBuilder sb=new StringBuilder();
        arr[0]=Integer.MAX_VALUE;
        for(int i=0;i<line;i++){
            result=0;
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            findmin(first+start-1,first+end-1);
            sb.append(arr[result]).append("\n");
        }
        System.out.println(sb);

    }
    static void findmin(int start,int end){

        while(start<=end){
            if(start==end){
                if(arr[result]>arr[tree[start]]){
                    result=tree[start];
                }
                return;
            }
            if(start%2==1){
                if(arr[result]>arr[tree[start]]){
                    result=tree[start];
                }
                start++;
            }
            if(end%2==0){
                if(arr[result]>arr[tree[end]]){
                    result=tree[end];
                }
                end--;
            }
            start/=2;
            end/=2;
        }
    }
    static int maketree(int index){
        if(index>=first/2){
            if(arr[tree[index*2]]> arr[tree[index*2+1]]){
                return tree[index]=tree[index*2+1];
            }else return tree[index]=tree[index*2];
        }
        if(arr[maketree(index*2)]>arr[maketree(index*2+1)]){
            return tree[index]=tree[index*2+1];
        }else return tree[index]=tree[index*2];
    }
    }






