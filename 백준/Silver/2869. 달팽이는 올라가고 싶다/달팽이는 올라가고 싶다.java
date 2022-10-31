import java.io.*;

import java.util.Arrays;
import java.lang.String;
import java.util.StringTokenizer;


public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int d = (c - b) / (a - b);

       
        if ((c - b) % (a - b) != 0) {
            d++;
        }
        System.out.print(d);


    }}