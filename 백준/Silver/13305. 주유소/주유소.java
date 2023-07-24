
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
    static int[] oilCostArr;
    static int[] distanceArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        oilCostArr=new int[size];
        distanceArr=new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<size-1;i++){
            distanceArr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<size;i++){
            oilCostArr[i] = Integer.parseInt(st.nextToken());
        }
        int current=0;
        long answer=0;
        while(true){
            int index=findCheaper(current);
            if (index == -1) {
                for (int i = current; i < size-1; i++) {
                    answer += oilCostArr[current] * distanceArr[i];
                }
                break;
            } else {

                for (int i = current; i < index; i++) {
                    answer += oilCostArr[current] * distanceArr[i];
                }
                current = index;
            }
            if(current==size-1){
                break;
            }
        }

        System.out.println(answer);

    }
    static int findCheaper(int index){
        for(int i=index;i<size;i++){
            if(oilCostArr[index]>oilCostArr[i]){
                return i;
            }
        }
        return -1;
    }}
