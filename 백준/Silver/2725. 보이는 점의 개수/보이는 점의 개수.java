import java.lang.*;
import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int test=Integer.parseInt(st.nextToken());
        int[] arr=new int[1001];
        arr[0]=0;
        arr[1]=2;
        for(int j=2;j<=1000;j++){
            int count=0;
            for(int k=1;k<=j;k++){
                if(gcd(j,k)==1){
                    count++;
                }
            }
        arr[j]=arr[j-1]+count;
        }
        for (int i = 0; i < test; i++){
           st = new StringTokenizer(br.readLine());
            int temp=Integer.parseInt(st.nextToken());
           if(temp==0){sb.append("\n");}
          sb.append(arr[temp]*2-1).append("\n");
        }
        System.out.println(sb);
    }
    static int gcd(int a, int b)
    {
        while (a%b != 0)
        {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return b;
    }

}