import java.util.Scanner;
import java.lang.String;
import java.lang.Integer;

public class Main {
    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);
       int T=sc.nextInt();
       for(int a=0;a<T;a++){
           int b=sc.nextInt();
           int c=sc.nextInt();
            int index[][]=new int[b+1][c];
           for (int i=0;i<=b;i++){
               for(int j=0;j<c;j++) {
                   if (i == 0) {
                       index[i][j] = j + 1;
                   }else
                   {
                   for(int p=i-1;p<i;p++){
                   for(int k=0;k<=j;k++){
                  index[i][j]+= index[p][k];
               }}}
       }




               }
           System.out.println(index[b][c-1]);

       }
            }


            }