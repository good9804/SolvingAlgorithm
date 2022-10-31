import java.io.BufferedReader;
import java.util.Comparator;

import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.lang.String;
import java.util.StringTokenizer;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int count=0;
        for(int i=0; i<n;i++){
            int k=Integer.parseInt(st.nextToken());

            for(int j=2;j<=k;j++){
                if(j!=k){
                if(k%j==0){
                  break;
                }} else if(j==k){
                    if(k%j==0){
                        count++;
                    }
                }

            }
        }
        System.out.println(count);

    }

            }