
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringBuilder answer=new StringBuilder();

        for(int t=0;t<test;t++){
            boolean flag=false;
            int numcount = Integer.parseInt(br.readLine());
            String[] arr=new String[numcount];
            HashSet<String> set = new HashSet<>();
            for(int i=0;i<numcount;i++){
                arr[i]=br.readLine();
            }
            Arrays.sort(arr, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length()-o2.length();
                }
            });
            for(int i=0;i<numcount;i++){
                if(i==0){
                    set.add(arr[0]);
                }else{
                    String str= arr[i];
                    StringBuilder sb=new StringBuilder();
                    for(int index=0;index<str.length();index++){
                        sb.append(str.charAt(index));
                        if(set.contains(sb.toString())){
                            flag=true;
                            break;
                        }
                    }
                    set.add(sb.toString());
                }
                if(flag){
                    break;
                }
            }
            if(flag){
                answer.append("NO").append("\n");
            }else answer.append("YES").append("\n");


        }
        System.out.println(answer);

    }}






