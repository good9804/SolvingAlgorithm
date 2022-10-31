import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();


        for(int i=0;i<A;i++){
            for(int k=A-1;k>i;--k){
                System.out.print(" ");
            }
            for(int j=0;j<i+1;j++){

                System.out.print("*");

            }

            System.out.println();
        }


}}