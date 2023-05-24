import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int size;
    static int max=Integer.MIN_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      size=Integer.parseInt(br.readLine());
      arr=new int[size];
      for(int i=0;i<size;i++){
          arr[i]=Integer.parseInt(br.readLine());
      }
      Arrays.sort(arr);
      int max=0;
      for(int i=0;i<size;i++){
          max=Math.max(max,arr[i]*(size-i));
      }
        System.out.println(max);
    }}



