import java.util.Scanner;
import java.lang.String;
import java.lang.Integer;

public class Main {
    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);

        while(true){

            String a=sc.next();

            char b[]= new char[a.length()];
            for(int i=0;i<a.length();i++){
                b[i]=a.charAt(i);
            }
            if(b[0]=='0'){
                break;
            }
            if(a.length()%2==0){
            for(int j=0;j<a.length();j++){
            if(b[j]==b[a.length()-j-1]){
                if(j==a.length()/2-1){
                    System.out.println("yes");
                }
            }else
            { System.out.println("no");
                break;
                    }

            }}else {for(int j=0;j<a.length();j++){
                if(b[j]==b[a.length()-j-1]){
                    if(j==a.length()/2){
                        System.out.println("yes");}
                    }
                else
                { System.out.println("no");
                    break;
                }

            }


        }

    }
}}