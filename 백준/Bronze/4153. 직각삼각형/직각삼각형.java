import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        while(true){
        int A=sc.nextInt();
        int B=sc.nextInt();
        int C=sc.nextInt();
            if(A==0&&B==0&&C==0)
            {break;}

        int x=0;
        if(A>B){
            x=Math.max(A,C);
        }
        else x=Math.max(B,C);

        if((Math.pow(x,2)==Math.pow(A,2)+Math.pow(B,2))||(Math.pow(x,2)==Math.pow(C,2)+Math.pow(B,2))
            ||(Math.pow(x,2)==Math.pow(A,2)+Math.pow(C,2))){
            System.out.println("right");
        }else System.out.println("wrong");





}}}
