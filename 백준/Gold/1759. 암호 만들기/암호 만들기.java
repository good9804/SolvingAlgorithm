import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {
    static int size;
    static int[] arr;
    static boolean[] check;
    static String[] strarr;
    static int ja;
    static int mo;
    static ArrayList<String> answerarr=new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ja=0;
        mo=0;
        String[] s=br.readLine().split(" ");
        size = Integer.parseInt(s[0]);
        int alpha=Integer.parseInt(s[1]);
        String answer="";
        arr=new int[alpha];
         check = new boolean[alpha];
         strarr= br.readLine().split(" ");
        for(int i=0;i< strarr.length;i++){
            arr[i] = strarr[i].charAt(0);
        }
        for(int i=0;i< strarr.length;i++){
        back(strarr[i],arr[i]);
        }
        Collections.sort(answerarr);
        for(int k=0;k< answerarr.size();k++){
           String temp= answerarr.get(k);
           for(int j=0;j<temp.length();j++){
            alphacheck(temp.charAt(j));}

            if(ja<2||mo<1){
            }
            else{System.out.println(answerarr.get(k));}
            ja=0;
            mo=0;
        }




}
public static void back(String str,int current){
        if(str.length()>=size){

            answerarr.add(str);
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(!check[i]&&current<arr[i]){
                check[i]=true;
                str+=strarr[i];
                back(str,arr[i]);
                check[i]=false;
                str=str.substring(0,str.length()-1);
            }
        }
}
public static void alphacheck(Character s){
        if(s.equals('a')||s.equals('e')||s.equals('i')||s.equals('o')||s.equals('u')){
            mo++;
        }else ja++;
}
}