
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.List;


class Main{
    static int size;
    static double[] energyArr;
    static int max=Integer.MIN_VALUE;
    static int maxindex=-1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        energyArr=new double[size];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<size;i++){
            int energy = Integer.parseInt(st.nextToken());
            energyArr[i]=energy;
            if(energy>max){
                max=energy;
                maxindex=i;
            }
        }
        double answer=max;
        int oddCount=0;
        for(int i=0;i<size;i++){
            if(i!=maxindex){
                answer+=energyArr[i]/2.0;
            }


        }
        System.out.println(answer);

    }

}
