import java.lang.*;
import java.util.*;
import java.io.*;
import java.util.stream.Stream;
class Main{
    public static void main(String[] args) throws IOException{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String[] arr=br.readLine().split(" ");
            int[] intarr= Stream.of(arr).mapToInt(Integer::parseInt).toArray();
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited=new boolean[1000001];
            q.add(intarr[0]);
            int count=0;
        visited[intarr[0]]=true;

            if(intarr[0]==intarr[1]){
                System.out.println(count);
                return;
            }
            while(!q.isEmpty()){

                count++;
                int size=q.size();
                for(int i=0;i<size;i++){
                int current=q.remove();

                if(current-1==intarr[1]||current+1==intarr[1]||current*2==intarr[1]){
                    System.out.println(count);
                    return;
                }
                if(current-1>=0&&!visited[current-1]){
                    q.add(current-1);
                    visited[current-1]=true;
                }

                if(current+1<=100000&&!visited[current+1]){
                    q.add(current+1);
                    visited[current+1]=true;
                }

                if(current*2<=100000&&!visited[current*2]){
                    q.add(current*2);
                    visited[current*2]=true;
                }
                }
            }
    }
}