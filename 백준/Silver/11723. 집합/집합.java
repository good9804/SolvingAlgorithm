
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int operationCount = Integer.parseInt(br.readLine());
        HashSet<Integer> hashSet = new HashSet<>();
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<operationCount;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String temp=st.nextToken();
            if(temp.equals("add")){
                hashSet.add(Integer.parseInt(st.nextToken()));
                continue;
            }
            else if(temp.equals("remove")){
                hashSet.remove(Integer.parseInt(st.nextToken()));

            }
            else if(temp.equals("check")){
                if(hashSet.contains(Integer.parseInt(st.nextToken()))){
                    stringBuilder.append(1).append("\n");
                }else stringBuilder.append(0).append("\n");
            }
            else if(temp.equals("toggle")){
                int num=Integer.parseInt(st.nextToken());
                if(hashSet.remove(num)){}
                else{
                    hashSet.add(num);
                }
            }
            else if(temp.equals("all")){
                hashSet.clear();
                for(int j=1;j<=20;j++){hashSet.add(j);}
            }
            else{
                hashSet.clear();
            }
        }
        System.out.print(stringBuilder);

    }
}

