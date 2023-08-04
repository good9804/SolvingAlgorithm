import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;


class Main{

    static int N;
    static int T;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Long> q=new PriorityQueue<>();
            long answer=0;
            for(int i=0;i<N;i++){
                q.add(Long.parseLong(br.readLine()));
            }
            if(N==1){
                System.out.print(0);
                return;
            }
            while(q.size()>1){
                long first=q.poll();
                long second=q.poll();
                answer+=first+second;
                q.add(first+second);

        }
        System.out.print(answer);






    }
}










