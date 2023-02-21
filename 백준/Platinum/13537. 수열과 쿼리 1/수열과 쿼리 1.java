
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

import java.util.List;

class Main {
    static int size;
    static int[] arr;
    static ArrayList<Integer>[] tree;
    static long[] multree;
    static int first;
    static int logn;
    static long mul;
    static long max;
    static int k;
    static long sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        arr=new int[size+1];
        logn=0;
        for(int i=1;i<size;i*=2){
            logn++;
        }
        tree=new ArrayList[(int)Math.pow(2,logn+1)];
        for(int i=0;i<tree.length;i++){
            tree[i]=new ArrayList<Integer>();
        }
        first=tree.length/2;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=size;i++){
            int temp = Integer.parseInt(st.nextToken());
            arr[i]=temp;
            tree[first+i-1].add(temp);
        }
        StringBuilder sb= new StringBuilder();
        arr[0]=Integer.MAX_VALUE;
        int line=Integer.parseInt(br.readLine());
        if(size==1){
            for(int i=0;i<line;i++){
                st = new StringTokenizer(br.readLine());
                sum=0;
                int start=first+Integer.parseInt(st.nextToken())-1;
                int end=first+Integer.parseInt(st.nextToken())-1;
                k=Integer.parseInt(st.nextToken());
                if(arr[1]>k){sb.append(1).append("\n");}
                else sb.append("0").append("\n");

            }
            System.out.println(sb);
            return;
        }
        init(1);
        for(int i=0;i<=first+size-1;i++){
           Collections.sort(tree[i]);
        }
        for(int i=0;i<line;i++){
            st = new StringTokenizer(br.readLine());
          sum=0;
            int start=first+Integer.parseInt(st.nextToken())-1;
            int end=first+Integer.parseInt(st.nextToken())-1;
             k=Integer.parseInt(st.nextToken());
            minindex(start,end);
            sb.append(sum).append("\n");
        }
        System.out.println(sb);

    }
    static void minindex(int start,int end){

        while(end>=start){

            if(end==start){
              int index=upperBound(tree[start], k);
              sum+=tree[start].size()-index;
           	return;
                /*while(right>=left){
                    int mid=(left+right)/2;

                    if(tree[start].get(mid)>k){
                        sum+=tree[start].size()-mid;
                        break;
                    }
                    else {
                        left=mid+1;
                    }

                }
            return;

            }*/}

            if(start%2==1){
                int left=0;
                int right=tree[start].size()-1;

                int index=upperBound(tree[start], k);
                sum+=tree[start].size()-index;
             /*   while(right>=left){
                    int mid=(left+right)/2;

                    if(tree[start].get(mid)>k){
                        sum+=tree[start].size()-mid;
                        break;
                    }
                    else {
                        left=mid+1;
                    }

                }*/


                    start++;
                }

            if(end%2==0){

                int left=0;
                int right=tree[end].size()-1;
                int index=upperBound(tree[end], k);
                sum+=tree[start].size()-index;
               /*  while(right>=left){
                    int mid=(left+right)/2;

                    if(tree[end].get(mid)>k){
                        sum+=tree[end].size()-mid;
                        break;
                    }
                    else {
                     left=mid+1;
                    }

                }*/


                end--;
            }
            start/=2;
            end/=2;
        }
        }

    

    private static int upperBound(List<Integer> data, int target) {
        int begin = 0;
        int end = data.size();
        
        while(begin < end) {
        	int mid = (begin + end) / 2;
            
            if(data.get(mid) <= target) {
            	begin = mid + 1;
            }
            else {
            	end = mid;
            }
        }
        return end;
    }





    static void init(int index){
        if(index>=first/2){
            tree[index].addAll(tree[index*2]);
            tree[index].addAll(tree[index*2+1]);
            return;
        }
        init(index*2);
        init(index*2+1);
        tree[index].addAll(tree[index*2]);
        tree[index].addAll(tree[index*2+1]);




    }
}






