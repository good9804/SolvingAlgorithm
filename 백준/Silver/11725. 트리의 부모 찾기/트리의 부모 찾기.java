
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static ArrayList<Integer> arrayList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] trees=new ArrayList[size+1];
        boolean[] checked=new boolean[size+1];
        int[] answer=new int[size+1];

        for(int i=1;i<=size;i++){
            trees[i]=new ArrayList<>();
        }
        for(int i=0;i<size-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            trees[first].add(last);
            trees[last].add(first);
        }
        int count=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        checked[1]=true;
        while(count<size-1){
            int parent= q.poll();
            for(int child:trees[parent]){
                if(!checked[child]){
                checked[child]=true;
                q.add(child);
                count++;
                answer[child]=parent;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=2;i<=size;i++){
            sb.append(answer[i]+"\n");
        }
        System.out.print(sb);


    }
}









