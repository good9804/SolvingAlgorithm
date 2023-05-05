
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alpha=new int[27];
        String str = br.readLine().toUpperCase();
        for(int i=0;i<str.length();i++){
            int temp=str.charAt(i)-'A';
            alpha[temp]++;
        }
        int max=0;
        int answer=0;
        boolean two=false;
        for(int i=0;i<27;i++){
            if(alpha[i]>=max){
                if(alpha[i]==max){two=true;
                continue;}
                else {max=alpha[i];
                    answer=i;
                two=false;}
            }
        }

        if(two){
            System.out.println("?");
        }else System.out.println(Character.toChars(answer+'A'));

    }
}

