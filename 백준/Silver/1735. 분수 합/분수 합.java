import java.lang.*;
import java.io.*;
import java.lang.reflect.Constructor;
import java.util.*;
import java.math.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int temp1= Integer.parseInt(st.nextToken());
        int temp2= Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int temp3=Integer.parseInt(st.nextToken());
        int temp4=Integer.parseInt(st.nextToken());
        int max;
        int min=temp2*temp4/makemin(temp2,temp4);

        int k=temp1*(min/temp2)+temp3*(min/temp4);

        System.out.println(k/makemin(min,k)+" "+min/makemin(min,k));



}
public static int makemin(int temp1,int temp2){

    while(temp2!=0){
        int max=temp1%temp2;
        temp1=temp2;
        temp2=max;
    }
    return temp1;
}
}