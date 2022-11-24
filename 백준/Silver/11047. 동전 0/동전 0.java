import java.io.*;
import java.util.*;
import java.lang.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String[] arr=bf.readLine().split(" ");
        int[] unit=new int[Integer.parseInt(arr[0])];
        int money=Integer.parseInt(arr[1]);
        int temp=0;
        int count;
        int result=0;
        boolean first=true;
        for(int i=0;i<Integer.parseInt(arr[0]);i++){
            unit[i]=Integer.parseInt(bf.readLine());
            if(money/unit[i]==0&&first){
                temp=i;
                first=false;
            }else temp=i;
        }
        while(money!=0){
            if(temp==0){
                result +=money/unit[0];
                break;
            }
            count=temp;
            if(!first){
          count=temp-1;}
            
            int k=money/unit[count];
            result+=k;
            money-=unit[count]*k;
            temp--;
        }
        System.out.println(result);
    }
}