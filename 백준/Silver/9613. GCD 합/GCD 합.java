
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;


class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> arrayList = new ArrayList<>();
            long sum=0;
            int size = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                arrayList.add(Integer.parseInt(st.nextToken()));
            }


            for(int i=0;i<arrayList.size();i++){
                for(int j=i+1;j<arrayList.size();j++){
                    sum+=GCD(arrayList.get(i),arrayList.get(j));
                }
            }
            sb.append(sum+"\n");
        }
        System.out.print(sb);



    }
    static int GCD(int a,int b){
        if(b==0) {
            return a;
        }else return GCD(b, a % b);


    }



}