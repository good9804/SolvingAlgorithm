import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
    static int size;
    static boolean[] isConnected;
    static boolean[][] all;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        size=Integer.parseInt(br.readLine());
        isConnected=new boolean[size+1];
        all=new boolean[size+1][size+1];
        for(int i=1;i<=size;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int count=1;
            while(st.hasMoreTokens()){
                if(st.nextToken().equals("1")){
                    all[i][count]= true;
                }
                count++;
            }

        }
        for(int i=1;i<=size;i++){
            Arrays.fill(isConnected,false);
            dfs(i);
            for(int j=1;j<=size;j++){
                if(j!=size){
                    if(isConnected[j]){
                        sb.append("1 ");
                    }else {sb.append("0 ");}}
                else {

                    if(isConnected[j]){
                        sb.append("1");
                    }else {sb.append("0");}
                }

            }
            System.out.println(sb);
            sb.setLength(0);
        }

    }
    static void dfs(int i){

        for(int k=1;k<=size;k++){
            if(all[i][k]&&!isConnected[k]){
                isConnected[k]=true;
                dfs(k);
            }
        }
    }}