import java.util.Scanner;
import java.lang.String;
import java.lang.Integer;

public class Main {static final int M = 1234567891;
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        int a=sc.nextInt();
        String[] b=new String[a];
        int current=0;
        long sum=0;
        double count=0;
        long k=1;
        String l=sc.next();
        for(int i=0;i<a;i++){
         char input=l.charAt(i);
        current=check(input);
         sum+=current*k%M;
            k= k*31%M;

        count++;
        }
        long hash=sum%M;
        System.out.println(hash
        );

    }
    public static int check(char input){
        if(input=='a'){
            return 1;
        }
        else if(input=='b'){
            return 2;
        }else if(input=='c'){
            return 3;
        }
        else if(input=='d'){
            return 4;
        }else if(input=='e'){
            return 5;
        }else if(input=='f'){
            return 6;
        }else if(input=='g'){
            return 7;
        }else if(input=='h'){
            return 8;
        }else if(input=='i'){
            return 9;
        }else if(input=='j'){
            return 10;
        }else if(input=='k'){
            return 11;
        }else if(input=='l'){
            return 12;
        }else if(input=='m'){
            return 13;
        }else if(input=='n'){
            return 14;
        }else if(input=='o'){
            return 15;
        }else if(input=='p'){
            return 16;
        }else if(input=='q'){
            return 17;
        }else if(input=='r'){
            return 18;
        }else if(input=='s'){
            return 19;
        }else if(input=='t'){
            return 20;
        }else if(input=='u'){
            return 21;
        }else if(input=='v'){
            return 22;
        }else if(input=='w'){
            return 23;
        }else if(input=='x'){
            return 24;
        }else if(input=='y'){
            return 25;
        }else return 26;

    }
}
