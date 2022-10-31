import java.util.Scanner;
import java.lang.String;
import java.lang.Integer;

public class Main {
    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int result[]=new int[Math.max(A,B)];
        int count=-1;
        for(int i=1;i<=Math.max(A,B);i++){
            if((A%i==0)&&(B%i==0)){
                count++;
                result[count]=i;

            }


            }

        System.out.println(result[count]);
        System.out.println(A*B/result[count]);
        }



 }