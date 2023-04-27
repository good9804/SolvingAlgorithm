
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import java.util.*;

class Main {
    static ArrayList<Integer>[] small;
    static ArrayList<Integer>[] big;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int compare = Integer.parseInt(st.nextToken());
        small=new ArrayList[size+1];
        big=new ArrayList[size+1];
        for(int i=1;i<=size;i++){
           small[i]=new ArrayList<Integer>();
            big[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<compare;i++){
            st = new StringTokenizer(br.readLine());//a<b
            int smaller=Integer.parseInt(st.nextToken());
            int bigger=Integer.parseInt(st.nextToken());
            big[smaller].add(bigger);
            small[bigger].add(smaller);
        }
        int answer=0;
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=size;i++){
            q.add(i);
            int smallcount=0;
            int bigcount=0;
            boolean[] smallcheck=new boolean[size+1];
            boolean[] bigcheck=new boolean[size+1];
            while(!q.isEmpty()){
                int temp=q.poll();
                for(int current:small[temp]){
                    if(!smallcheck[current]){
                    smallcount++;
                    q.add(current);
                    smallcheck[current]=true;}
                }
            }
            q.add(i);
            while(!q.isEmpty()){
                int temp=q.poll();
                for(int current:big[temp]){
                    if(!bigcheck[current]){
                    bigcount++;
                    q.add(current);
                    bigcheck[current]=true;}
                }
            }
            if(smallcount+bigcount==size-1){answer++;}

        }
        System.out.println(answer);



    }
}

