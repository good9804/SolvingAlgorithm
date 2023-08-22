
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
         N = Integer.parseInt(st.nextToken());
        int K= Integer.parseInt(st.nextToken());
        boolean[] check=new boolean[N];
        int count=0;
         String hp=br.readLine();
        PriorityQueue<Integer> Hindex = new PriorityQueue<>();
        PriorityQueue<Integer> Pindex = new PriorityQueue<>();
        for(int i=0;i<hp.length();i++){
            char c=hp.charAt(i);
            if(c=='H'){
                Hindex.add(i);
                continue;
            }
            if(c=='P'){
                Pindex.add(i);
                continue;
            }
        }
        while(!Pindex.isEmpty()&&!Hindex.isEmpty()){
            int p=Pindex.peek();
            if(Math.abs(p-Hindex.peek())<=K){
                Hindex.poll();
                Pindex.poll();
                count++;
            }else if(p>Hindex.peek()){
                Hindex.poll();
            }else{
                Pindex.poll();
            }
        }



        System.out.println(count);

    }
    static boolean isRange(int index){
        return index>=0&&index<N;
    }




    }
