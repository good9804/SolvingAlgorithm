
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;


class Main {
    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer>[] trees=new ArrayList[size];
        for(int i=0;i<size;i++){
            trees[i]=new ArrayList<Integer>();
        }
        int rootNode=0;
        for(int i=0;i<size;i++){
            int parent=Integer.parseInt(st.nextToken());
            if(parent==-1){
                rootNode=i;
            }else{
                trees[parent].add(i);
            }

        }
        int removeNode=Integer.parseInt(br.readLine());
        trees[removeNode].clear();

        int answer=0;
        if(rootNode==removeNode){
            System.out.println(0);
            return;
        }
        Queue<Integer> queue=new LinkedList<>();
        queue.add(rootNode);

        while(!queue.isEmpty()){
            int parent= queue.poll();
            if(!trees[parent].isEmpty()){
            for(int child: trees[parent]){
                if(child==removeNode){
                    if(trees[parent].size()==1){
                        answer++;
                    }
                    continue;
                }
                else{queue.add(child);}
            }}else{ answer++;}
        }
        System.out.println(answer);




        }
}










