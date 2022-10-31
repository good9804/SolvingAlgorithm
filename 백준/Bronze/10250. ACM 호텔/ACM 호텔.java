import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int i=0;i<T;i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            int x=0; int y=0;
            if(C%A==0) {
                x=C/A;
            }
            else  x=C/A+1;

            if(C%A==0){
            y=A;}
            else y=C%A;
            if(B<10)
            System.out.println(y+"0"+x);
            else
                if(x<10)
                    System.out.println(y+"0"+x);
                else System.out.println(y+""+x);


        }


}}