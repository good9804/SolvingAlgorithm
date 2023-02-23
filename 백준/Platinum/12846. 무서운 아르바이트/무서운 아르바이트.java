
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
    static long answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int logn=0;
        for(int i=1;i<size;i*=2){
        logn++;}
        tree=new int[(int)Math.pow(2.,logn+1)];
        arr=new int[size+1];
        first=tree.length/2;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=size;i++){
            int temp = Integer.parseInt(st.nextToken());
            arr[i]=temp;
            tree[first+i-1]=i;
        }
        answer=0;
        arr[0]=Integer.MAX_VALUE;
        if(size==1){
            System.out.println(arr[1]);
            return;
        }
        init(1);
        find(first,first+size-1);
        System.out.println(answer);

    }
    static int getmin(int start,int end){
        int result=tree[start];
        while(end>=start){
            if(end==start){
                if(arr[result]>arr[tree[start]]){
                    return result=tree[start];
                }else if(arr[result]==arr[tree[start]]){
                    if(result>tree[start]){
                        result=tree[start];
                    }
                    return result;
                }
            }
            if(start%2==1){
                if(arr[result]>arr[tree[start]]){
                   result=tree[start];
                }else if(arr[result]==arr[tree[start]]){
                    if(result>tree[start]){
                        result=tree[start];
                    }

                }
                start++;
            }
            if(end%2==0){
                if(arr[result]>arr[tree[end]]){
                    result=tree[end];
                }else if(arr[result]==arr[tree[end]]){
                    if(result>tree[end]){
                        result=tree[end];
                    }

                }
                end--;
            }
            start/=2;
            end/=2;
        }
        return result;
    }
    static void find(int start,int end){
        int result=getmin(start,end);
        long temp=arr[result]*(end-start+1);
        if(answer<temp){
            answer=temp;
        }
        if(first+result-2>=start){
            find(start,first+result-2);
        }
        if(first+result<=end){
            find(first+result,end);
        }

    }
    static int init(int index){
        if(index>=first/2){
            if(arr[tree[index*2]]<=arr[tree[index*2+1]]){
                return tree[index]=tree[index*2];
            }else return tree[index]=tree[index*2+1];
        }
        if(arr[init(index*2)]<=arr[init(index*2+1)]){
            return tree[index]=tree[index*2];
        }else return tree[index]=tree[index*2+1];
    }
}






