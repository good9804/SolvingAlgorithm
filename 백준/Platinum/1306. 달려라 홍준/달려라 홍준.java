
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {
    static int[] tree;
    static int[] arr;
    static int first;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int size=Integer.parseInt(st.nextToken());
        int rank = Integer.parseInt(st.nextToken());

        int logn=0;
        for(int i=1;i<size;i*=2){
            logn++;
        }
        tree=new int[(int)Math.pow(2,logn+1)];
        arr=new int[size+1];
        arr[0]=Integer.MIN_VALUE;
         first=tree.length/2;
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=size;i++){
            int temp = Integer.parseInt(st.nextToken());
            arr[i]=temp;
            tree[first+i-1]=i;
        }
        if(size==1){
            System.out.println(arr[1]);
            return;
        }
        init(1);
        if(size==rank){
            System.out.println(arr[tree[1]]);
            return;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=rank;i<=size-rank+1;i++){
            int result=find(first+i-1-(rank-1),first+i-1+(rank-1));
            sb.append(arr[result]+" ");
        }

        System.out.println(sb);
    }
    static int find(int start,int end){
        int result=tree[start];
        while(end>=start){
            if(end==start){
                if(arr[result]<=arr[tree[start]]){
                    result=tree[start];
                }
                return result;
            }

            if(start%2==1){
                if(arr[result]<=arr[tree[start]]){
                    result=tree[start];
                }
                start++;
            }
            if(end%2==0){
                if(arr[result]<=arr[tree[end]]){
                    result=tree[end];
                }
                end--;
            }
            start/=2;
            end/=2;
        }
        return result;

    }
    static int init(int index){
      if(index>=first/2){
          if(arr[tree[index*2]]>=arr[tree[index*2+1]]){
              return tree[index]=tree[index*2];
          }else return tree[index]=tree[index*2+1];
      }
        if(arr[init(index*2)]>=arr[init(index*2+1)]){
            return tree[index]=tree[index*2];
        }else return tree[index]=tree[index*2+1];
    }
}






