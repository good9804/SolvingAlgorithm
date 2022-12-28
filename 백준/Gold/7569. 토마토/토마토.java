import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {
    static int[][][] pan;
    static boolean[][][] isChecked;
    static int garo;
    static int sero;
    static int temp;
    static int h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        garo = Integer.parseInt(st.nextToken());
         sero = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        pan=new int[h][sero][garo];
        isChecked=new boolean[h][sero][garo];
temp=0;
        Queue<Point> q=new LinkedList<>();
        for(int c=0;c<h;c++){
        for(int i=0;i<sero;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<garo;j++){
                pan[c][i][j]=Integer.parseInt(st.nextToken());
                if(pan[c][i][j]==1){
                    q.add(new Point(i,j,c));
                    isChecked[c][i][j]=true;
                }
                if(pan[c][i][j]==0){
                    temp++;
                }
            }}}
        int count=-1;
        while(!q.isEmpty()){
            int qsize=q.size();

            count++;
            for(int k=0;k<qsize;k++){
            Point p=q.poll();
            int x=p.x;
            int y=p.y;
            int z=p.z;
            if(isRange(x+1,y,z)&&!isChecked[z][x+1][y]&&pan[z][x+1][y]==0){
                isChecked[z][x+1][y]=true;
                pan[z][x+1][y]=1;
                temp--;
                q.add(new Point(x+1,y,z));
            }
            if(isRange(x-1,y,z)&&!isChecked[z][x-1][y]&&pan[z][x-1][y]==0){

                    isChecked[z][x-1][y]=true;
                    pan[z][x-1][y]=1;
                    temp--;
                    q.add(new Point(x-1,y,z));
                }
            if(isRange(x,y-1,z)&&!isChecked[z][x][y-1]&&pan[z][x][y-1]==0){

                    isChecked[z][x][y-1]=true;
                    pan[z][x][y-1]=1;
                temp--;
                    q.add(new Point(x,y-1,z));
                }
            if(isRange(x,y+1,z)&&!isChecked[z][x][y+1]&&pan[z][x][y+1]==0){

                    isChecked[z][x][y+1]=true;
                    pan[z][x][y+1]=1;
                    temp--;
                    q.add(new Point(x,y+1,z));
                }
            if(h>1&&isRange(x,y,z+1)&&!isChecked[z+1][x][y]&&pan[z+1][x][y]==0){

                    isChecked[z+1][x][y]=true;
                    pan[z+1][x][y]=1;
                    temp--;
                    q.add(new Point(x,y,z+1));
                }
            if(h>1&&isRange(x,y,z-1)&&!isChecked[z-1][x][y]&&pan[z-1][x][y]==0){
                    isChecked[z-1][x][y]=true;
                    pan[z-1][x][y]=1;
                    temp--;
                    q.add(new Point(x, y,z-1 ));
                }


            }

        }
        if(temp==0){
        System.out.println(count);}
        else System.out.println(-1);

    }
    public static boolean isRange(int x,int y,int z){
        return x>=0&&x<sero&&y>=0&&y<garo&&z>=0&&z<h;
    }

}
class Point{
        int x;
        int y;
        int z;
public Point(int x,int y,int z){
        this.x=x;
        this.y=y;
        this.z=z;
        }

}