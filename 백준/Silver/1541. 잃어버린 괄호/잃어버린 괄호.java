import java.lang.*;
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] strarr=br.readLine().split("-");
        int sum=0;
        for(int i=0;i<strarr.length;i++){
            int temp=0;
            String[] strarr2=strarr[i].split("\\+");
            for(int k=0;k<strarr2.length;k++){
                temp+=Integer.parseInt(strarr2[k]);
            }
            if(i==0){
                sum+=temp;
            }else sum-=temp;

        }
        System.out.println(sum);
    }
}