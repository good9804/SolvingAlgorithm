import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        if(num==0){
            System.out.println("1");
            return;
        }
        int temp=0;
        int count=0;
        while(temp!=num){
            count++;
            if(count==1){
            int left=num/10;
            int right=num%10;
            int hap=left+right;
            temp =right*10+(hap%10);
            continue;}
            else{
                int left=temp/10;
                int right=temp%10;
                int hap=left+right;
                temp =right*10+(hap%10);
                continue;}
        }
        System.out.println(count);
    }
}