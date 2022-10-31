import java.util.Scanner;
import java.lang.String;
import java.lang.Integer;

public class Main {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();
        int a=1;
        int b=6;
        int count=1;
        int result;
        while(true){
            if(T==1){
                result=count;
                break;
            }
            if(a<T&&T<= b+1){
                result =count+1;
                break;
            }
            count++;

                a=b;
                b=b+6*count;
        }
        System.out.println(result);







}}