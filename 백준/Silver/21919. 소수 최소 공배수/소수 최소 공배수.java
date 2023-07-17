
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;


class Main{

    static int MAX=1000000;
    static boolean[] Primearr=new boolean[MAX+1];
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger answer=new BigInteger("1");
        HashSet<Long> hashSet = new HashSet<>();
        findPrime();
        boolean existPrime=false;
        while(st.hasMoreTokens()){
            long number = Long.parseLong(st.nextToken());
            if(!Primearr[(int)number]&&!hashSet.contains(number)){
                existPrime=true;
                answer=answer.multiply(BigInteger.valueOf(number));
                hashSet.add(number);
            }
        }

        if(!existPrime){
            System.out.println(-1);
        }
        else{
            System.out.println(answer);
        }


    }
    static void findPrime(){
        for(int i=2;i<=MAX;i++){
            if(!Primearr[i]){
                int index=2;
                while(index*i<=MAX){

                    Primearr[index*i]=true;
                    index++;
                }
            }
        }
    }



}