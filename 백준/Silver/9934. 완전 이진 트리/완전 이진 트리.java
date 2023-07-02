
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;


class Main {
    static HashMap<Integer, ArrayList<Integer>> depthmap = new HashMap<>();
    static int depth;
    static ArrayList<Integer> array=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        depth = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=depth;i++){
            depthmap.put(i, new ArrayList<>());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            array.add(Integer.parseInt(st.nextToken()));
        }
        postBinary(0,array.size()-1,1);
        for(int i=1;i<=depth;i++){
            int size=depthmap.get(i).size();
            for(int j=0;j<size;j++){
                sb.append(depthmap.get(i).get(j)+" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);




    }
    static void postBinary(int start,int end,int k){
        if(k>depth){
            return;
        }
        int mid=(start+end)/2;
        depthmap.get(k).add(array.get(mid));
        postBinary(start,mid-1,k+1);
        postBinary(mid+1,end,k+1);
    }
}









