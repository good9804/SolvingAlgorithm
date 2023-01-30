
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {
    static int[][] pan;
    static int row;
    static int size;
    static int[] col;
    static int[] right;
    static int[] left;
    static int answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        pan = new int[size][size];
        col = new int[size];
        right = new int[2 * size - 1];
        left= new int[2 * size - 1];
        row=0;
        answer=0;
        int count=0;
        backtrack(row,count);
        System.out.println(answer);

}
    public static void backtrack(int queen,int count){
        if(count==size){
            answer++;
        }
        for(int i=0;i<size;i++){
            if(col[i]!=1&&right[queen-i+size-1]!=1&&left[queen+i]!=1){
            int check=queen-i;
            int check2=queen+i;
            col[i]=1;
            right[check + size - 1] = 1;
            left[check2] = 1;
                backtrack(queen+1,count+1);

                col[i]=0;
                right[check + size - 1] = 0;
                left[check2] = 0;
            }

        }

    }
}