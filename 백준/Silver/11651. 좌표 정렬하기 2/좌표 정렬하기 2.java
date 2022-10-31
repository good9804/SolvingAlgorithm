import java.io.*;
import java.util.*;
import java.lang.String;
import  java.util.Comparator;
public class Main {
    public static void main(String args[]) throws  java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
         int arr[][]=new int[k][2];

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<k;i++){
        String str=br.readLine();
        String str2[] = str.split(" ");
            arr[i][0] = Integer.parseInt(str2[0]);
            arr[i][1] = Integer.parseInt(str2[1]);
            };
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
               if(o1[1]==o2[1])
                   return o1[0]-o2[0];
               else return o1[1]-o2[1];
            }
        });
        for(int i=0;i<k;i++){
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }
        System.out.println(sb);

        }
    }