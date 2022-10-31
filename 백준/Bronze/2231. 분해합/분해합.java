import java.util.Scanner;
import java.lang.String;
import java.lang.Integer;

public class Main {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();
        int k=0;
        for(int i=0;i<T;i++){
            int number=i;
            int sum=i;
            while(number!=0){
                sum+=number%10;
                number /= 10;
            }
            if(sum==T){
                k=i;
                break;
            }

        }
        System.out.println(k);




}}