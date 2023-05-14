
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] answer=new int[10001];
        while (true){
            String num=br.readLine();
            if(num==null||num.equals("")){
                System.out.println(sb);
                return;
            }
            int n=Integer.parseInt(num);
            if(answer[n]!=0){

                sb.append(answer[n]).append("\n");
            }
            int temp=0;
            for(int i=0;;i++){
                temp=(temp*10+1)%n;

                if(temp==0){
                    answer[n]=i+1;
                    sb.append(i+1).append("\n");
                    break;
                }

            }

            }
        }
    }








