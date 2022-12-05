import java.util.*;
import java.lang.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> min = new PriorityQueue<>();
        int count = Integer.parseInt(br.readLine());
        for(int i=0;i<count;i++){
            int num=Integer.parseInt(br.readLine());
            if(num==0){
                if(min.isEmpty()){
                    System.out.println(0);
                }
                else {int result=min.poll();
                System.out.println(result);}

            }else {
                min.add(num);
            }
        }
    }

}