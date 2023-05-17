import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] arr2;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i=0;
        arr2=new int[size];

        HashSet<Integer> set=new HashSet<>();

        while(st.hasMoreTokens()){
            int num=Integer.parseInt(st.nextToken());
            arr2[i++] =num;
            set.add(num);
        }
        arr= set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(arr);
        StringBuilder sb=new StringBuilder();
        for(int j=0;j<arr2.length;j++){
            sb.append(binary(arr2[j])).append(" ");
        }
        System.out.print(sb);
    }
    static int binary(int num){
        int start=0;
        int end=arr.length-1;
        while(true){
            int mid=(start+end)/2;
            if(arr[mid]>num){
                end=mid-1;
            }
            else if(arr[mid]<num){
                start=mid+1;
            }else return mid;




        }

    }
    }



