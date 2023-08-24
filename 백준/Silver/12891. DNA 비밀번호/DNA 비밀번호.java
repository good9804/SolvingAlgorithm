
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
class Main {
    static int N;
    static int M;
    static int K;
    static int[] current;
    static int[] arr;




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        current=new int[4];
        arr=new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left=0;
        int right=0;
        for(int i=right;i<K;i++){
            if(str.charAt(i)=='A'){current[0]++;}
            else if(str.charAt(i)=='C'){current[1]++;}
            else if(str.charAt(i)=='G'){current[2]++;}
            else{current[3]++;}
        }
        boolean flag=true;
        int count=0;
        if(Ok()){
            count++;
        }
        right=K-1;
        while(right<N-1){
         if(str.charAt(left)=='A'){
             current[0]--;
         }
           else if(str.charAt(left)=='C'){
             current[1]--;
         }
            else if(str.charAt(left)=='G'){
             current[2]--;
         }
            else{
             current[3]--;
         }
            left++;
            right++;

            if(str.charAt(right)=='A'){
                current[0]++;
            }
            else if(str.charAt(right)=='C'){
                current[1]++;
            }
            else if(str.charAt(right)=='G'){
                current[2]++;
            }
            else{
                current[3]++;
            }
            if(Ok()){count++;}
        }
        System.out.println(count);

}
static boolean Ok(){
    for(int i=0;i<4;i++){
        if(arr[i]>current[i])
        {
            return false;
        }
    }
    return true;
}

}
