import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {
    static int row;
    static int col;
    static int[][] pan;
    static int temp;
    static boolean[][] isChecked;
    static boolean solo;
    static int check;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
         col = Integer.parseInt(st.nextToken());
         int count=0;
         temp=0;
            check=0;
         pan=new int[row][col];
         isChecked=new boolean[row][col];
         solo=false;
        Queue<Point> q = new LinkedList<>();
         for(int i=0;i<row;i++){
             st = new StringTokenizer(br.readLine());
             for(int j=0;j<col;j++){
                 pan[i][j] = Integer.parseInt(st.nextToken());
                 if(pan[i][j]>0){
                     q.add(new Point(i, j));
                     isChecked[i][j]=true;
                 }

             }
         }

         while(!q.isEmpty())
         {
             int qsize = q.size();
             for (int index = 0; index < qsize; index++) {
                 Point p = q.poll();
                 int x = p.x;
                 int y=p.y;
                 melting(x,y-1,x,y);
                 melting(x,y+1,x,y);
                 melting(x-1,y,x,y);
                 melting(x+1,y,x,y);
                 if(pan[x][y]>=1){
                     q.add(new Point(x, y));

                 }
                 if(temp==4){
                     System.out.println(count);
                     return;
                 }

                 temp=0;

             }
             int qqsize=q.size();
             if(qqsize==1||qqsize==0){
                     System.out.println(0);
                     return;}
             for(boolean[] a:isChecked){
                 Arrays.fill(a,false);
             }
             Point p=q.peek();
             int x=p.x;
             int y=p.y;
             dfs(x,y,1,qqsize);
             if(!solo){
                 System.out.println(count+1);
                 return;
             }
             check=0;

             solo=false;





             count++;}


         System.out.println(0);}


    public static void dfs(int x,int y,int temp,int qqsize){
        if(check==qqsize){
            solo=true;
            return;
        }
        if(!solo){
        if(isRange(x-1,y)&&pan[x-1][y]>0&&!isChecked[x-1][y]){
            isChecked[x-1][y]=true;
            check++;
            dfs(x-1,y,temp+1,qqsize);
        }

        if(isRange(x+1,y)&&pan[x+1][y]>0&&!isChecked[x+1][y]){
            isChecked[x+1][y]=true;
            check++;
            dfs(x+1,y,temp+1,qqsize);
        }

        if(isRange(x,y+1)&&pan[x][y+1]>0&&!isChecked[x][y+1]){
            isChecked[x][y+1]=true;
            check++;
            dfs(x,y+1,temp+1,qqsize);
        }

        if(isRange(x,y-1)&&pan[x][y-1]>0&&!isChecked[x][y-1]){
            isChecked[x][y-1]=true;
            check++;
            dfs(x,y-1,temp+1,qqsize);
        }}else return;
    }
    public static boolean isRange(int x,int y){
        return x>=0&&x<row&&y>=0&&y<col;
    }
    public static boolean solo(int x,int y){
        if(isRange(x,y)&&pan[x][y]>0){
            return true;
        }else return false;
    }
    public static void melting(int x,int y,int currentx,int currenty){
        if(isRange(x,y)&&pan[x][y]==0&&!isChecked[x][y]){
            temp++;
            if(pan[currentx][currenty]>0){
            pan[currentx][currenty]-=1;}
        }
        return;
    }
}