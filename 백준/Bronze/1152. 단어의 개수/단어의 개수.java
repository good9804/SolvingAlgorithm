import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str;
        str=sc.nextLine();
        int count=1;
        for(int i=0;i<str.length();i++) {
            if(i!=0){
                if(i==(str.length()-1)){
                    if(str.charAt(i)==' '){
                        break;}
                }
                else
                    if(str.charAt(i)==' ')
                        count++;
            }
            else
                if(str.length()==1)
                    if(str.charAt(i)==' ')
                        count --;
        }

        System.out.print(count);
    }}