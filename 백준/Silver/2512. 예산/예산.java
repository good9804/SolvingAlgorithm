
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
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum=0;
        for(int i=0;i<N;i++){
            int temp=Integer.parseInt(st.nextToken());
            pq.add(temp);

        }
        int all = Integer.parseInt(br.readLine());
        int k=all/N;
        int size=pq.size();
        while(!pq.isEmpty()){
            int num=pq.poll();
            if(num<=k){
                all-=num;
                size--;
                if(size==0){
                    System.out.println(num);
                    return;
                }
                k=all/size;
            }
            else{
                System.out.println(k);
                return;
            }


        }










    }




    }
