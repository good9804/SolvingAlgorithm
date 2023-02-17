
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
    static int first;

    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size=Integer.parseInt(br.readLine());

        logn=0;
        for(int i=1;i<size;i*=2){
            logn++;
        }
        tree=new long[(int)Math.pow(2,logn+1)];
        arr=new long[size+1];
        arr[0]=Long.MAX_VALUE;
        first=tree.length/2;
        StringTokenizer st=new StringTokenizer(br.readLine());
        int k=1;
        while(st.hasMoreTokens()){
            long temp=Long.parseLong(st.nextToken());
            tree[first+k-1]=k;
            arr[k]=temp;
            k++;

        }
        StringBuilder sb=new StringBuilder();
        int line=Integer.parseInt(br.readLine());
        init(1);
        for(int i=0;i<line;i++){
            st=new StringTokenizer(br.readLine());
            int choice = Integer.parseInt(st.nextToken());
            if(choice==1){
                int changeindex = Integer.parseInt(st.nextToken());
                long num = Long.parseLong(st.nextToken());
                arr[changeindex]=num;
                update(first+changeindex-1);
            }
            else{
                int start = first + Integer.parseInt(st.nextToken())-1;
                int end = first + Integer.parseInt(st.nextToken())-1;
                sb.append(find(start,end)).append("\n");

            }


        }
        System.out.println(sb);
    }
    static long find(int start,int end){
        int result=0;
        while(end>=start){
            if(start==end){
                if(arr[result]>arr[(int)tree[start]]){

                    result=(int)tree[start];
                }else if(arr[result]==arr[(int)tree[start]]){
                    if(result>tree[start]){
                        result=(int)tree[start];
                    }
                }
                return result;
            }
            if(start%2==1){
                if(arr[result]>arr[(int)tree[start]]){

                    result=(int)tree[start];
                }else if(arr[result]==arr[(int)tree[start]]){
                    if(result>tree[start]){
                        result=(int)tree[start];
                    }
                }
                start++;
            }
            if(end%2==0){
                if(arr[result]>arr[(int)tree[end]]){

                    result=(int)tree[end];
                }else if(arr[result]==arr[(int)tree[end]]){
                    if(result>tree[end]){
                        result=(int)tree[end];
                    }
                }
                end--;
            }
            start/=2;
            end/=2;
        }
        return result;


    }
    static long init(int index){
        if(index>=first/2){
            if(arr[(int)tree[index*2]]<=arr[(int)tree[index*2+1]]){
                return tree[index]=tree[index*2];

            }else return tree[index]=tree[index*2+1];
        }
        if(arr[(int)init(index*2)]<=arr[(int)init(index*2+1)]){
            return tree[index]=tree[index*2];

        }else return tree[index]=tree[index*2+1];

    }

    static void update(int index){
        int temp=index/2;

        while(temp!=0){
            if(arr[(int)tree[temp*2]]<=arr[(int)tree[temp*2+1]]){
                tree[temp]=tree[temp*2];
            }else tree[temp]=tree[temp*2+1];
            temp/=2;
        }
    }
    }






