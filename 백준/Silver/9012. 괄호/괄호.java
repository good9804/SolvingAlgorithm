import java.io.*;
import java.util.*;
import java.lang.String;
public class Main {
    public static void main(String args[]) throws IOException {

        int p=0;
        int q=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k=Integer.parseInt(br.readLine());
        for(int i=0;i<k;i++){
            p=0;
            q=0;

            String str=br.readLine();
            for(int a=0;a<str.length();a++){
                if(str.charAt(a)=='('){
                    p++;
                }
                else q++;
                if(q>p){
                    break;
                }
            }
            if(p==q){
                System.out.println("YES");
            } else {System.out.println("NO");


            }
        }

    }}