
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;


class Main {
    static int size;
    static ArrayList<Integer>[] trees;
    static int allWater;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        double allWater = Double.parseDouble(st.nextToken());
        trees=new ArrayList[size+1];
        boolean[] Checked=new boolean[size+1];
        for(int i=1;i<=size;i++){
            trees[i]=new ArrayList<>();
        }
        for(int i=0;i<size-1;i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            trees[node1].add(node2);
            trees[node2].add(node1);


        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        Checked[1]=true;
        double leafCount=0.0;
        while(!queue.isEmpty()){
            int parent= queue.poll();
            boolean isLeaf=true;
            for(int child:trees[parent]){
                if(!Checked[child]){
                isLeaf=false;
                Checked[child]=true;
                queue.add(child);
                }
            }
            if(isLeaf){leafCount++;}
        }
        System.out.println(allWater/leafCount);

    }

}










