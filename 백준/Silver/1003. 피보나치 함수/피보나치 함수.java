import java.lang.*;
import java.io.*;
import java.util.*;
class Main{
    static int[][] fib=new int[41][2];
    public static void main(String[] args) throws IOException{
        fib[0][0]=1;
        fib[0][1]=0;
        fib[1][0]=0;
        fib[1][1]=1;
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        
        int testcount=Integer.parseInt(bf.readLine());
        for(int i=0;i<testcount;i++){
            int n=Integer.parseInt(bf.readLine());
            fibonacci(n);
            System.out.println(fib[n][0]+" "+fib[n][1]);
           
        }
    }
    public static int[] fibonacci(int n){
        if(fib[n][0]==0&&fib[n][1]==0){
            fib[n][0]=fibonacci(n-1)[0]+fibonacci(n-2)[0];
            fib[n][1]=fibonacci(n-1)[1]+fibonacci(n-2)[1];
        }
        return fib[n];
    }
}