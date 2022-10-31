import java.util.*;
public class Main {
    public static void main(String[] args){
    Scanner sc= new Scanner(System.in);
    long a= sc.nextLong();
    long b=sc.nextLong();
    long c= a-b;
    long d=b-a;
    if(c>=d){
    System.out.println(c);
    }
    else {
        System.out.println(d);
        }
}}