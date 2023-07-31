
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
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        int[] antena= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(antena);

        PriorityQueue<Integer> gap=new PriorityQueue<>();
        for(int i=0;i< N-1;i++){
            gap.add(antena[i+1]-antena[i]);
        }
        int answer=0;
        for(int i=0;i<N-K;i++){
            answer+=gap.poll();
        }
        System.out.println(answer);


        }
}








