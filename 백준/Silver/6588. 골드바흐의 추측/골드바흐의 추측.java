import java.lang.*;
import java.io.*;
import java.lang.reflect.Constructor;
import java.util.*;
import java.math.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        boolean isPrime[]=new boolean[1000000+1];
        for(int i=2;i<=1000000;i++) {
            isPrime[i] = true;
        }

        for(int i=2;i<=1000000/2;i++){

            if(!isPrime[i]){
                continue;}
            for(int j=i*2;j<=1000000;j+=i){
                isPrime[j]=false;

            }
        }
        StringBuilder sb=new StringBuilder();
        while(true){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        if(num==0){
            System.out.println(sb);
            return;}

        boolean find=false;
        for(int i=2;i<=num/2;i++){
            if(isPrime[i]&&isPrime[num-i]){
                sb.append(num).append(" = ").append(i).append(" + ").append(num-i).append("\n");
                find=true;
                break;
            }
        }
        if(!find){
            sb.append("Goldbach's conjecture is wrong.").append("\n");
        }

        }
    }
}