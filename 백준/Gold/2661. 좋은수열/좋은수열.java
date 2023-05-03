
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import java.util.*;

class Main {
    static ArrayList<Integer>[] patharray;
    static boolean[] Visted;
    static String answer;
    static int size;
    static  boolean find=false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        backtracking("1","1");
        System.out.println(answer);

    }
    static void backtracking(String current,String last){
        if(find){return;}
        for(int i=0;i<(current.length()/2)-1;i++){
            int temp=(current.length()-1)-(current.length()-(i+2))+1;
            if(current.substring(current.length()-(i+2),current.length()).equals
                    (current.substring(current.length()-(i+2)-temp,current.length()-temp))){return;}
        }
        if(current.length()==size){
            find=true;
            answer = current;
            return;
        }
        if(last.equals("1")){

            backtracking(new String(current)+"2","2");
            backtracking(new String(current)+"3","3");
        }
        else if(last.equals("2")){
            backtracking(new String(current)+"1","1");
            backtracking(new String(current)+"3","3");
        }
        else{
            backtracking(new String(current)+"1","1");
            backtracking(new String(current)+"2","2");
        }
    }
}

