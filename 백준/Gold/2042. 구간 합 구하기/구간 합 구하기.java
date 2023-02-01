
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {
    static long[] sumarr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int leafcount = Integer.parseInt(st.nextToken());
        long[] arr=new long[leafcount+1];

        int changenum = Integer.parseInt(st.nextToken());
        int sumcount = Integer.parseInt(st.nextToken());

        for(int i=1;i<=leafcount;i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        double allnode=0;
        int k=0;
        while(allnode<leafcount){
            k++;
            allnode=Math.pow(2,k);


        }

        int firstindex=(int) allnode;
        sumarr = new long[firstindex*2];
        int i=1;
        for(int j=firstindex;j<allnode+leafcount;j++){
        sumarr[j]=arr[i++];
        }

           int depthindex= (int) Math.pow(2,k);
        for(int j=depthindex;j<depthindex*2;j++){
            maketree(j,sumarr[j]);
        }


        for(int a=0;a<changenum+sumcount;a++){
            st = new StringTokenizer(br.readLine());
            if(st.nextToken().equals("1")){
            while (st.hasMoreTokens()){
                int temp=Integer.parseInt(st.nextToken());
                long num = Long.parseLong(st.nextToken());
                maketree(firstindex+temp-1,-sumarr[firstindex+temp-1]);
                sumarr[firstindex+temp-1]=num;

                arr[temp]=num;

                maketree(firstindex+temp-1,sumarr[firstindex+temp-1]);
            }}
            else{

                int start=Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int left=firstindex+start-1;
                int right=firstindex+end-1;
                long sum=0;
                while(left<=right){
                if(left%2==1){
                    sum+=sumarr[left++];

                }
                if(right%2==0){
                    sum+=sumarr[right--];

                }

                    left/=2;
                    right/=2;}
                System.out.println(sum);

            }
        }





    }
    public static void maketree(int index,long num){
        if(index==1){return;}
       sumarr[index/2]+=num;
       maketree(index/2,num);
    }
}




