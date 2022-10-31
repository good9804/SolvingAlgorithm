import java.util.Scanner;
import java.lang.String;
import java.lang.Integer;

public class Main {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        int a=sc.nextInt();
        int b=sc.nextInt();
        int sum=0;
        int answer=0;
        int current2;
        int result=0;
        int[] arr=new int[a];
        boolean first=true;
        for(int i=0;i<a;i++){
            arr[i]=sc.nextInt();
        }
        for(int k=0;k<a;k++){
            for(int j=1;j<a;j++){
                for(int l=2;l<a;l++){
                    sum=arr[k]+arr[j]+arr[l];
                    if(b-sum>=0&&k!=j&&j!=l&&k!=l){
                    current2=b-sum;
                    if(first==true){
                        answer=current2;
                        first=false;

                    }
                    if(answer>=current2){
                        answer=current2;
                        result=sum;
                    }
                    sum=0;}
                }
            }

        }

    System.out.println(result);





}}