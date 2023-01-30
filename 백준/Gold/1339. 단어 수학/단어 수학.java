
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> str = new ArrayList<>();
        int size = Integer.parseInt(br.readLine());
        int[] alpha = new int[26];
        boolean[] alpha2 = new boolean[26];
        int index=0;
        int[] lengtharr = new int[size];
        int c=0;
        int count=9;
        int answer=0;
        boolean bol=false;
        for(int i=0;i<size;i++){
            String[] s=br.readLine().split("");
            int temp=1;
            for(int k=s.length-1;k>=0;k--){
                int a=s[k].charAt(0);
                alpha[a-65]+=temp;
                temp*=10;
            }
        }
        for(int i=0;i<26;i++){
            bol=false;
            int num1=alpha[i];
            c=num1;
            for(int k=0;k<26;k++){
                int num2 = alpha[k];
                if(c<num2&&!alpha2[k]){
                    c=num2;
                    index=k;
                    bol=true;

                }

            }
            if(bol){
            alpha2[index]=true;
            answer+=c*count;
            count--;}
        }
        System.out.println(answer);



}
}
