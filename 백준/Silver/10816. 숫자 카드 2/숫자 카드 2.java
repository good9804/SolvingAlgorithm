import java.io.*;
import java.util.*;
import java.lang.String;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int k=Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer tok = new StringTokenizer(br.readLine());
        for(int i=0;i<k;i++){
            int num = Integer.parseInt(tok.nextToken());
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            } else map.put(num, 1);

        }
        int p = Integer.parseInt(br.readLine());
         tok = new StringTokenizer(br.readLine());
        for(int i=0;i<p;i++){
            int num = Integer.parseInt(tok.nextToken());
            if(map.containsKey(num)){
                sb.append(map.get(num)).append(" ");
            } else sb.append("0").append(" ");

        }
                System.out.println(sb);
    }}