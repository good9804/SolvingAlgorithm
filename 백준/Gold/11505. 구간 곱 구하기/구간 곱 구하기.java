import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {
    static int[] arr;
    static long[] tree;
    static int logn;
    static int first;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int size=Integer.parseInt(st.nextToken());
        int line=Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken());

        logn=0;
        for(int i=1;i<size;i*=2){
            logn++;
        }
        tree=new long[(int) Math.pow(2,logn+1)];
        first=tree.length/2;
        Arrays.fill(tree,1);
        for(int i=0;i<size;i++){
            int temp=Integer.parseInt(br.readLine());
            tree[first+i]=temp;

        }
        maketree(1);
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=line;i++){
            st=new StringTokenizer(br.readLine());
            int choice=Integer.parseInt(st.nextToken());
            if(choice==1){
                int changeindex=Integer.parseInt(st.nextToken());
                int changenum=Integer.parseInt(st.nextToken());

                    tree[first+changeindex-1]=changenum;
                    updatetree(first+changeindex-1);

            }
            else{
                int start=first+Integer.parseInt(st.nextToken())-1;
                int end=first+Integer.parseInt(st.nextToken())-1;
                if(start>end){
                    int temp=start;
                    start=end;
                    end=temp;
                }
                long sum=1;
                while(start<=end){
                    if(start==end){
                        sum=(sum*tree[start])%1000000007;
                        break;
                    }
                    if(start%2==1){
                        sum=(sum*tree[start++])%1000000007;
                    }
                    if(end%2==0){sum=(sum*tree[end--])%1000000007;}
                    start/=2;
                    end/=2;
                }

                sb.append(sum).append("\n");

            }
        }

        System.out.println(sb);

    }
    static long maketree(int index){
        if(index>=first){return tree[index];}
          return tree[index]=maketree(index*2)*maketree(index*2+1)%1000000007;

    }
    static void updatetree(int index){
        int temp=index/2;
        while(temp!=0){
            tree[temp]=(tree[temp*2]*tree[temp*2+1])%1000000007;
            temp/=2;
        }
    }
    static void changetree(int index){
        if(index>=first){
            return ;
        }
        changetree(index*2);
        changetree(index*2+1);
        tree[index]=tree[index*2]*tree[index*2+1];
    }
    }






