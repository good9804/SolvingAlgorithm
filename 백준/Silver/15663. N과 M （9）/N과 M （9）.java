import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {
    static int len;
    static int[] arr;
    static int[] visit;
    static String last;
    static int[] result;
    static HashSet<String> set = new HashSet<>();
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        arr=new int[count];
        result=new int[count];
        int index=0;
        while (st.hasMoreTokens()) {
            int temp = Integer.parseInt(st.nextToken());
            arr[index++]=temp;
        }
        last="";
        Arrays.sort(arr);
        visit=new int[arr.length];
        dfs(1);
        System.out.println(sb);
    }

    static void dfs(int x){
        if(x==len+1){
            StringBuilder str=new StringBuilder();
            for(int i=0;i<len;i++){
                str.append(result[i]).append(" ");
            }
            if(!set.contains(str.toString())){
                set.add(str.toString());
            sb.append(str).append("\n");}

            return;
        }
        for(int i=0;i<arr.length;i++){
            if(visit[i]>=0){
                visit[i]=-1;
                result[x-1]=arr[i];
                dfs(x+1);
                visit[i]=1;

            }
        }



    }
}


