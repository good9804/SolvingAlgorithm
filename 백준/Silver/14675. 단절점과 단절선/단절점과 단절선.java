
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeSize = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        int[] nodes = new int[nodeSize+1];
        ArrayList<Bridge> bridges = new ArrayList<>();
        for(int i=0;i<nodeSize-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            nodes[first]++;
            nodes[last]++;
            bridges.add(new Bridge(first,last));

        }
        int qsize = Integer.parseInt(br.readLine());
        for(int i=0;i<qsize;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int question = Integer.parseInt(st.nextToken());
            if(question==1){
                int node = Integer.parseInt(st.nextToken());
                if(nodes[node]>1){
                    answer.append("yes\n");
                }else{answer.append("no\n");}
            }
            else{
                int bridge = Integer.parseInt(st.nextToken());
                if(bridges.get(bridge-1).first>=1&&bridges.get(bridge-1).last>=1){
                    answer.append("yes\n");
                }else{
                    answer.append("no\n");
                }

            }
        }
        System.out.print(answer.substring(0,answer.length()-1));




    }

}
class Bridge{
    int first;
    int last;
    public Bridge(int first,int last){
        this.first=first;
        this.last=last;
    }
}









