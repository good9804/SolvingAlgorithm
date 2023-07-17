
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;


class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            BigInteger number = new BigInteger(st.nextToken());
            if(number.isProbablePrime(10)){
                sb.append(number+"\n");
            }else{
                sb.append(number.nextProbablePrime()+"\n");
            }
        }
        System.out.println(sb);



    }



}