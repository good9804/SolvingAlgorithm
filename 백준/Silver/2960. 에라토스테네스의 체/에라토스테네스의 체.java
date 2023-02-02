import java.lang.*;
import java.io.*;
import java.lang.reflect.Constructor;
import java.util.*;
import java.math.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        boolean isPrime[]=new boolean[num+1];

        int count=0;
        for(int i=2;i<=num;i++){
            if(isPrime[i]==false){
                for(int j=i;j<=num;j+=i){
                    if(isPrime[j]){continue;}
                    isPrime[j]=true;
                    ++count;
                    if(count==a){
                        System.out.println(j);
                        return;
                    }
                }
            }
        }
    }
}