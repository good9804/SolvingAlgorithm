import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int B=sc.nextInt();
        int C=sc.nextInt();
        int D=sc.nextInt();
        int x=C-A;
        int y=D-B;

       int xmin=Math.min(A,x);
       int ymin=Math.min(B,y);
       System.out.println((Math.min(xmin,ymin)));
}}
