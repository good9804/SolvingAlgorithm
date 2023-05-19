
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import java.util.*;

class Main {
    static int row;
    static int col;
    static int[][] pan;
    static int answer=0;
    static ArrayList<int[]> universe;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        pan=new int[row][col];
        for (int i=0;i<row;i++){
            st=new StringTokenizer(br.readLine());
            for (int j=0;j<col;j++){
                pan[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        universe = new ArrayList<>();
        for(int i=0;i<row;i++){
            int[] temp=pan[i].clone();
            int[] index=new int[col];
            Arrays.sort(temp);
            for(int j=0;j<col;j++){
            index[j]=binarysearch(pan[i][j],temp);
            }
            universe.add(index);
        }
        for(int i=0;i<row;i++){
            int[] temp1=universe.get(i);
            for(int j=i+1;j<row;j++){
                int[] temp2=universe.get(j);
                boolean flag=true;
                for(int k=0;k<col;k++){
                    if(temp1[k]!=temp2[k]){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    static int binarysearch(int answer,int[] arr){
        int start=0;
        int end=arr.length-1;
        while (start<=end){
            int mid=(start+end)/2;
            if(arr[mid]>answer){
                end=mid-1;
            }
            else if(arr[mid]<answer){
                start=mid+1;
            }
            else{
                return mid;
            }
        }
        return 0;

    }
}








