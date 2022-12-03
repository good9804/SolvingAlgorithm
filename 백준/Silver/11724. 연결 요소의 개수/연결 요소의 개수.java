import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
    static Queue<Integer> q= new LinkedList<>();
    static boolean[] isChecked;
    static boolean[][] isConnected;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int size=Integer.parseInt(st.nextToken());
        int side=Integer.parseInt(st.nextToken());
        isChecked=new boolean[size+1];
        isConnected=new boolean[size+1][size+1];
        for(int i=0;i<side;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            isConnected[x][y]=true;
            isConnected[y][x]=true;
        }
        int count=1;
        int temp=1;
        isChecked[0]=true;
        isChecked[1]=true;
        while(!isTrue()){

            q.add(temp);
            if(!isChecked[temp]){
                count++;
            }
            while(!q.isEmpty()){
                int current=q.poll();
                for(int k=1;k<=size;k++){
                    if(isConnected[current][k]&&!isChecked[k]){
                        q.add(k);
                        isChecked[k]=true;
                    }
                }
            }
            temp++;
            if(temp>size){
                break;
            }
        }
        System.out.println(count);
    }
    static boolean isTrue(){
        for( boolean T:isChecked){
            if(!T){
                return false;
            }
        }
        return true;
    }
}