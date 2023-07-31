
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
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        List<Integer> boatArray=Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        M = Integer.parseInt(br.readLine());
        List<Integer> weightArray=Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        Collections.sort(boatArray,Collections.reverseOrder());
        Collections.sort(weightArray,Collections.reverseOrder());
        if(boatArray.get(0)<weightArray.get(0)){
            System.out.println(-1);
            return;
        }
        int answer=0;


        while(!weightArray.isEmpty()){
            answer++;
        for(int i=0;i<N;i++){
            int boat=boatArray.get(i);
            for(int j=0;j<weightArray.size();j++){
                    if(boat>=weightArray.get(j)){
                        weightArray.remove(j);
                        break;
                    }
                }

            }

        }


        System.out.println(answer);
        }
}








