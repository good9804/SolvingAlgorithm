
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
        StringTokenizer st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] student= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(student);

        PriorityQueue<Integer> gap=new PriorityQueue<>();
        for(int i=0;i< N-1;i++){
            gap.add(student[i+1]-student[i]);
        }
        int answer=0;
        for(int i=0;i<N-K;i++){
            answer+=gap.poll();
        }
        System.out.println(answer);


        }
}








