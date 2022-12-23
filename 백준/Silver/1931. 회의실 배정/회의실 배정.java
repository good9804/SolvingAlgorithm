import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {
    static int[][] pan;
    static int max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size=Integer.parseInt(br.readLine());
        pan=new int[size][2];
        for(int i=0;i<size;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            pan[i][0]=Integer.parseInt(st.nextToken());
            pan[i][1]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(pan, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]){
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            }
        });
        max=0;
        int time=0;
        for(int k=0;k<size;k++){
            if(time<=pan[k][0]){
                time=pan[k][1];
                max++;
            }
        }
        System.out.println(max);
    }}