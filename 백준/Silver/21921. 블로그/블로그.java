
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    static int N;
    static int score;

    static int P;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr=new int[N];

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left=0;
        int right=0;
        int sum=0;
        for(int i=0;i<X;i++){
            sum+=arr[right++];
        }
        int answer=sum;
        right--;
        int count=0;
        if(sum!=0){
        count++;}
        while(right<N){
            sum-=arr[left++];
            if(right+1<N){
            sum+=arr[++right];}else{break;}
            if(sum==answer){
                count++;
            }else if(sum>answer){
                answer=sum;
                count=1;
            }

        }
        if(answer==0){
            System.out.println("SAD");
            return;
        }
        System.out.println(answer);
        System.out.println(count);












    }




    }
