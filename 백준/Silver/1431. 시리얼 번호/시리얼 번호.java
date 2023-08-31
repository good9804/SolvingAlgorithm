
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

class Main {
    static int row;
    static int col;

    static boolean[][][] isVisisted;
    static boolean[][] pan;
    static int[][][] dp;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int[] horsedx={-1,-2,1,2,-1,-2,1,2};
    static int[] horsedy={-2,-1,-2,-1,2,1,2,1};
    static int answer=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<number> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            list.add(new number(br.readLine()));
        }
        Collections.sort(list);
        for(number n:list){
            System.out.println(n.word);
        }


    }


}
class number implements Comparable<number>{
    String word;
    int hap=0;
    public number(String word){
        this.word=word;
        for(int i=0;i<word.length();i++){

            if(word.charAt(i)<='9'){
               hap+=this.word.charAt(i)-'0';
            }

        }
    }
    @Override
    public int compareTo(number n){
        if(this.word.length()!=n.word.length()){
            return this.word.length()-n.word.length();
        }else if(this.hap==n.hap){
            return this.word.compareTo(n.word);

        }else{
            return this.hap-n.hap;
        }
    }
}






