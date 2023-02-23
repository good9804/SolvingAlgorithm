
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
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        StringBuilder sb=new StringBuilder();
        int logn=0;
        for(int i=1;i<size;i*=2){
            logn++;
        }

        tree=new int[(int)Math.pow(2,logn+1)];
        first= tree.length/2;
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=size;i++){
            tree[first + i - 1] = Integer.parseInt(st.nextToken());
        }
        int line = Integer.parseInt(br.readLine());
        if(size==1){
            for(int i=0;i<line;i++){
                st = new StringTokenizer(br.readLine());
                int choice = Integer.parseInt(st.nextToken());
                if(choice==1){continue;}
                else{sb.append("1").append("\n");}
            }
            System.out.println(sb);
            return;
        }
        init(1);
        for(int i=0;i<line;i++){
            st = new StringTokenizer(br.readLine());
            int choice = Integer.parseInt(st.nextToken());
            if(choice==1){
                int index=first+Integer.parseInt(st.nextToken())-1;
                int num = Integer.parseInt(st.nextToken());
                update(index,num);
            }
            else{
                answer=0;
                int rank=Integer.parseInt(st.nextToken());
                find(rank,1);
                sb.append(answer-first+1).append("\n");
            }

        }


        System.out.println(sb);
    }
    static void find(int rank,int index){
        if(index>=first){
            answer=index;
            return;
        }
        if(tree[index*2]>=rank){
            find(rank,index*2);
        }else {
            rank-=tree[index*2];
            find(rank,index*2+1);
        }
    }
    static void update(int index,int num){

        while(index!=0){
            tree[index]+=num;
            index/=2;
        }

    }
    static int init(int index){
      if(index>=first/2){

              return tree[index]=tree[index*2]+tree[index*2+1];
      }
      return tree[index]=init(index*2)+init(index*2+1);
    }
}






