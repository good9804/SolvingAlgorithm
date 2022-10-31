import java.io.*;
import java.util.Arrays;
import java.lang.String;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(br.readLine());
        int index[]=new int[n];
        for(int i=0; i<n;i++){
            index[i]=Integer.parseInt(br.readLine());
            }
        Arrays.sort(index);
        for(int i=0;i<n;i++){
            sb.append(index[i]).append("\n");
        }
        System.out.println(sb);
        }}