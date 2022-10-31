import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.lang.String;
import java.lang.Integer;

public class Main {
    public static void main(String args[]) throws IOException{

        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb=new StringBuilder();
       int T=Integer.parseInt(sc.readLine());

       int index[]=new int [T];
       for(int a=0;a<T;a++){
           index[a]=Integer.parseInt(sc.readLine());
       }
       Arrays.sort(index);
        for(int j=0;j<T;j++){
           sb.append(index[j]).append('\n');
        }
        System.out.println(sb);
       }
            }