import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
    static int[] answer=new int[1001];
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        answer[1]=1;
        answer[2]=2;
        answer[3]=3;
        int temp=4;
        while(temp<=n){
            answer[temp]=(answer[temp-1]+answer[temp-2])%10007;
            temp++;
        }
        System.out.println(answer[n]);
    }
}