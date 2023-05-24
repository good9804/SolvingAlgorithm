import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int size;
    static int max=Integer.MIN_VALUE;
    static ArrayList<Integer> AarrayList;
    static ArrayList<Integer> BarrayList;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      size=Integer.parseInt(br.readLine());
      AarrayList=new ArrayList<>();
       BarrayList=new ArrayList<>();
      StringTokenizer st=new StringTokenizer(br.readLine());
      for(int i=0;i<size;i++){
          AarrayList.add(Integer.parseInt(st.nextToken()));
      }
     st=new StringTokenizer(br.readLine());
        for(int i=0;i<size;i++){
            BarrayList.add(Integer.parseInt(st.nextToken()));
        }
        int answer=0;
        for(int i=0;i<size;i++){
            answer+=findmax()*findmin();
        }
        System.out.println(answer);
    }
    static int findmin(){
        int min=Integer.MAX_VALUE;
        int index=0;
        for(int i=0;i<AarrayList.size();i++){
            if(AarrayList.get(i)<min){
                min=AarrayList.get(i);
                index=i;
            }
        }
        AarrayList.remove(index);
        return min;

    }
    static int findmax(){
        int max=Integer.MIN_VALUE;
        int index=0;
        for(int i=0;i<BarrayList.size();i++){
            if(BarrayList.get(i)>max){
                max=BarrayList.get(i);
                index=i;
            }
        }
        BarrayList.remove(index);
        return max;

    }}



