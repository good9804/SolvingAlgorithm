
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {
    static int size;
    static int[] arr;
    static int[] tree;
    static long[] multree;
    static int first;
    static int logn;
    static long mul;
    static long max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size=Integer.parseInt(br.readLine());

        StringTokenizer st=new StringTokenizer(br.readLine());
        logn=0;
        for(int i=1;i<size;i*=2){
            logn++;
        }
        tree=new int[(int) Math.pow(2,logn+1)];
        multree=new long[tree.length];
        Arrays.fill(multree,0);
        arr=new int[size+1];
        first=tree.length/2;
        arr[0]=Integer.MAX_VALUE;
        for(int i=1;i<=size;i++){
            int temp = Integer.parseInt(st.nextToken());
            arr[i]=temp;
            tree[first+i-1]=i;
            multree[first+i-1]=temp;
        }
        if(size==1){
            System.out.println(arr[1]*arr[1]);
            return;
        }
        init(1);
        max=Long.MIN_VALUE;
        find(first,first+size-1);
        System.out.println(max);


    }
    static int minindex(int start,int end){
        int result=tree[start];
        mul=0;
        while(end>=start) {
            if (start == end) {
                if (arr[result] > arr[tree[start]]) {
                    result = tree[start];
                } else if (arr[result] == arr[tree[start]]) {
                    if (result > tree[start]) {
                        result = tree[start];
                    }
                }
                mul+=multree[start];
                return result;
            }
            if (start % 2 == 1) {
                if (arr[result] > arr[tree[start]]) {
                    result = tree[start];
                } else if (arr[result] == arr[tree[start]]) {
                    if (result > tree[start]) {
                        result = tree[start];
                    }
                }
                mul+=multree[start];
                start++;
            }
            if (end % 2 == 0) {
                if (arr[result] > arr[tree[end]]) {
                    result = tree[end];
                } else if (arr[result] == arr[tree[end]]) {
                    if (result > tree[end]) {
                        result = tree[end];
                    }
                }
                mul+=multree[end];
                end--;
            }
            start /= 2;
            end /= 2;
        }
        return result;


        }


    static void find(int start,int end){

        int minindex=minindex(start,end);
        long temp=arr[minindex]*mul;
        if(max<temp){
            max=temp;
        }
        if(first+minindex<=end){
            find(first+minindex,end);
        }
        if(first+minindex-2>=start){
            find(start,first+minindex-2);
        }


    }
    static int init(int index){
        if(index>=first/2){
            multree[index]=multree[index*2]+multree[index*2+1];
            if(arr[tree[index*2]]<=arr[tree[index*2+1]]){
                return tree[index]=tree[index*2];
            }else return tree[index]=tree[index*2+1];
        }


        if(arr[init(index*2)]<=arr[init(index*2+1)]){
            multree[index]=multree[index*2]+multree[index*2+1];
            return tree[index]=tree[index*2];
        }else {multree[index]=multree[index*2]+multree[index*2+1];
            return tree[index]=tree[index*2+1];}
    }
}






