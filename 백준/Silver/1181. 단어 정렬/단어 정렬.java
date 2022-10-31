import java.io.BufferedReader;
import java.util.Comparator;

import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.lang.String;


public class Main {
    public static void main(String args[]) throws IOException{

        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
       int a=Integer.parseInt(sc.readLine());

       String list[]=new String[a];
       String tmp=new String();
       for(int i=0;i<a;i++){
           list[i]=sc.readLine();

       }
        Arrays.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length()){
                    return o1.compareTo(o2);
                } else {return o1.length()-o2.length();}
            }});




       for(int i=0;i<a;i++){
           if(i!=0){
                if(list[i].equals(list[i-1]))
                {}
                else System.out.println(list[i]);
               }
           else if(i==0)System.out.println(list[i]);
       }

       }

            }