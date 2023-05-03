
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import java.util.*;

class Main {
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int test=0;test<testcase;test++) {
            int clothes = Integer.parseInt(br.readLine());
            HashMap<String, Integer> clothMap = new HashMap<>();
            for (int i = 0; i < clothes; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String category = st.nextToken();
                clothMap.put(category, clothMap.getOrDefault(category, 0) + 1);
            }
            int answer=1;
            if(clothMap.size()==1){
                for (Map.Entry<String, Integer> map : clothMap.entrySet()) {
                    answer*=map.getValue();

                }
                sb.append(answer).append("\n");
            }
            else{for (Map.Entry<String, Integer> map : clothMap.entrySet()) {
                answer*= map.getValue()+1;

            }
            sb.append(answer-1).append("\n");}
        }
        System.out.print(sb);


    }
}

