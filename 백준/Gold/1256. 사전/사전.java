import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {
    static long[][] arr;
    static long answer;
    static int hap;
    static int INF=1000000000;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));





            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
             int b = Integer.parseInt(st.nextToken());
        long answer=Long.parseLong(st.nextToken());
         arr=new long[202][202];
         arr[0][0]=1;
        for(int i=1;i<=a+b;i++){
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    arr[i][j]=1;
                }
                else {arr[i][j]=(arr[i-1][j-1]+arr[i-1][j]);}
                if(arr[i][j]>INF){
                    arr[i][j]=INF;
                }
            }
        }

            hap=a+b;
            int index=a+b;
            if(arr[a+b][a]<answer){
                System.out.print(-1);
                return;
            }
            find(answer,a,1,index);



        }

static void find(long rank,int a,int count,int index){

        if(a==0){
            for(int i=0;i<=hap-count;i++){
                System.out.print("z");
            }
            return;
        }
        if(rank<=arr[index-1][a-1]){
            System.out.print("a");
            a--;
            find(rank,a,count+1,--index);
        }
            else{rank-=arr[index-1][a-1];
            System.out.print("z");

                find(rank,a,count+1,--index);
            }
}}


