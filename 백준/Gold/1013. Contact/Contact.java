
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;
import java.util.regex.Pattern;

class Main {
    static String answer="";
    static int result;
    static int astart;
    static int bstart;
    static int aanswer;
    static int banswer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();

        for(int t=0;t<test;t++) {
            String str = br.readLine();
            if(Pattern.matches("(100+1+|01)+",str)){
                sb.append("YES").append("\n");
            }else sb.append("NO").append("\n");

        }
        System.out.print(sb);

    }
}






