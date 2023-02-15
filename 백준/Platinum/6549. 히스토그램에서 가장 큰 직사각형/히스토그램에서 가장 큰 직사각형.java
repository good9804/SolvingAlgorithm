
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {
    static long[] arr;
    static long[] tree;
    static int logn;
    static long first;
    static long max;
    static int size;

    public static void main(String[] args) throws IOException {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb=new StringBuilder();
    while(true){
        StringTokenizer st=new StringTokenizer(br.readLine());
       size=Integer.parseInt(st.nextToken());
        if(size==0){
            System.out.println(sb);
            return;
        }

        arr=new long[size+1];
        logn=0;
        for(int i=1;i<size;i*=2){
            logn++;
        }
        max=0;
        tree=new long[(int)Math.pow(2,logn+1)];
        first= tree.length/2;
        int k=1;
        arr[0]=Integer.MAX_VALUE;
        while(st.hasMoreTokens()){
            int temp=Integer.parseInt(st.nextToken());
            arr[k]=temp;
            tree[(int)first-1+k]=k;
            k++;
        }
        if(size==1){
            sb.append(arr[1]).append("\n");
            continue;
        }
        maketree(1);
        findmax(first,first+size-1);
        sb.append(max).append("\n");
    }

    }
    static long maketree(int index){
        if(index>=first/2){
            if(arr[(int)tree[(index*2)]]>arr[(int)tree[(index*2)+1]]){
                return tree[(int)index]=tree[index*2+1];
            }else return tree[index]=tree[index*2];
        }
        if(arr[(int)maketree(index*2)]>arr[(int)maketree(index*2+1)]){
            return tree[index]=tree[index*2+1];
        }else return tree[index]=tree[index*2];


    }
    static long findheight(long start,long end){
        long result=0;
        while(end>=start){
            if(end==start){
                if(arr[(int)tree[(int)start]]<=arr[(int)result]){
                    result=tree[(int)start];
                }
                return result;
            }
            if(start%2==1){
                if(arr[(int)tree[(int)start]]<arr[(int)result]){
                    result=tree[(int)start];
                }
                start++;
            }
            if(end%2==0){
                if(arr[(int)tree[(int)end]]<arr[(int)result]){
                    result=tree[(int)end];
                }
                end--;
            }
            start/=2;
            end/=2;
            }
        return result;
    }
    static void findmax(long start,long end){
        long h=findheight(start,end);
        max=Math.max((end-start+1)*arr[(int)h],max);

        if(first+h-2>=start){
            findmax(start,first+h-2);
        }
        if(first+h<=end){
            findmax(first+h,end);
        }
    }
    }






