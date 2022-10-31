import java.io.*;

import java.util.Arrays;
import java.lang.String;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a=Integer.parseInt(br.readLine());
        String [][] arr=new String[a][2];
        for(int i=0;i<a;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0]=st.nextToken();
            arr[i][1] = st.nextToken();

        }
        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<a;i++){
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");

        }
        System.out.println(sb);




    }}