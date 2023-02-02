import java.lang.*;
import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
static long[] candyindex;
static int firstindex;
static int answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size=Integer.parseInt(st.nextToken());
        int test=Integer.parseInt(st.nextToken());
        int k=0;
        double treeindex=0;
        while(treeindex<size){
            k++;
            treeindex=Math.pow(2,k);

        }
        int allsize=(int)Math.pow(2,k+1);
        firstindex=(int) treeindex;
        candyindex=new long[allsize];

        st = new StringTokenizer(br.readLine());
        int index=firstindex;
        while (st.hasMoreTokens()){
            long temp=Long.parseLong(st.nextToken());
            candyindex[index]=temp;
            maketree(index++,temp);
        }

        for(int i=0;i<test;i++){
            st = new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            if(start>end){
                int a=start;
                start=end;
                end=a;
            }
            int changeindex=Integer.parseInt(st.nextToken());
            long newnum=Integer.parseInt(st.nextToken());
            long sum=0;
            int left=firstindex+start-1;
            int right=firstindex+end-1;
            if(left==right){
                System.out.println(candyindex[left]);
            }
            else {
                while(left<=right){
            if(left%2==1){sum+=candyindex[left++]; }

            if(right%2==0){sum+=candyindex[right--];}
                left/=2;
                right/=2;

            }
            System.out.println(sum);}

            maketree(firstindex+changeindex-1,newnum-candyindex[firstindex+changeindex-1]);
            candyindex[firstindex+changeindex-1]=newnum;
        }



    }
static void maketree(int index,long num){
        if(index==1){return;}
        candyindex[index/2]+=num;
        maketree(index/2,num );

}



}






