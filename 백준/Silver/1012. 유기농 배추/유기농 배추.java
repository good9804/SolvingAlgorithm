import java.util.*;
import java.lang.*;
import java.io.*;
class Main{
    static boolean[][] bat;
    static boolean[][] isChecked;
    static int garo;
    static int sero;
    static int answer=0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount=Integer.parseInt(br.readLine());
        for(int i=0;i<testCount;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
             garo=Integer.parseInt(st.nextToken());
             sero=Integer.parseInt(st.nextToken());
            int bachu=Integer.parseInt(st.nextToken());
            bat=new boolean[sero][garo];
            isChecked=new boolean[sero][garo];
            for(int k=0;k<bachu;k++){
                st = new StringTokenizer(br.readLine());
                int garo2=Integer.parseInt(st.nextToken());
                int sero2=Integer.parseInt(st.nextToken());
                bat[sero2][garo2]=true;

            }
            Queue<Integer> q=new LinkedList<>();
            for(int x=0;x<sero;x++){
                for(int y=0;y<garo;y++){
                    if(bat[x][y]&&!isChecked[x][y]){
                    dfs(x,y);
                    answer++;
                    }
                }
            }
            System.out.println(answer);
            answer=0;
            for(boolean[] a:bat){
            Arrays.fill(a,false);}
            for(boolean[] a:isChecked){
                Arrays.fill(a,false);}
        }
    }
    static boolean isRange(int x,int y){
        return x>=0&&x<=sero-1&&y>=0&&y<=garo-1;
    }
    static void dfs(int x,int y){
        isChecked[x][y]=true;
        if(isRange(x-1,y)&&!isChecked[x-1][y]&&bat[x-1][y]){
            dfs(x-1,y);
        }
        if(isRange(x+1,y)&&!isChecked[x+1][y]&&bat[x+1][y]){
            dfs(x+1,y);
        }
         if(isRange(x,y-1)&&!isChecked[x][y-1]&&bat[x][y-1]){
            dfs(x,y-1);
        }
         if(isRange(x,y+1)&&!isChecked[x][y+1]&&bat[x][y+1]){
            dfs(x,y+1);
        }
    }
}