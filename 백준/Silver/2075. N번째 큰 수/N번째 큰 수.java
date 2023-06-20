

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size= Integer.parseInt(br.readLine());//수 입력받기
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0;i<size;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<size;j++){
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }
        for(int i=0;i<size-1;i++){
            pq.poll();
        }
        System.out.println(pq.poll());


    }
}

