import java.lang.*;
import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
static int[] candyindex;
static int firstindex;
static int answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int test=Integer.parseInt(st.nextToken());
        int k=0;
        double treeindex=0;
        while(treeindex<1000000){
            k++;
            treeindex=Math.pow(2,k);

        }
        int size=(int)Math.pow(2,k+1);
        firstindex=(int) treeindex;
        candyindex=new int[size];

        for(int i=0;i<test;i++){
            st=new StringTokenizer(br.readLine());
            int choice=Integer.parseInt(st.nextToken());
            if(choice==1){
                int rank=Integer.parseInt(st.nextToken());
               find(rank,1);
                System.out.println(answer-firstindex+1);
                candyindex[answer]-=1;
                maketree(answer,-1);

            }
            else{
                int candy=Integer.parseInt(st.nextToken());
                int count=Integer.parseInt(st.nextToken());
                candyindex[firstindex+candy-1]+=count;
                maketree(firstindex+candy-1,count);
            }
        }



    }
static void maketree(int index,int num){
        if(index==1){return;}
        candyindex[index/2]+=num;
        maketree(index/2,num );

}
static void find(int rank,int index){
        if(index>=firstindex){answer= index;return;}
        if(rank<=candyindex[index*2]){
            find(rank,index*2);
        }
            else{ rank-=candyindex[index*2];
        find(rank,index*2+1);}

    }

}