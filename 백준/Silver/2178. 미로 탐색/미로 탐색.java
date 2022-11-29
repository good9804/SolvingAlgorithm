
import java.lang.*;
import java.util.*;
import java.io.*;
import java.awt.*;

class Main{
    static int rowSize;
    static int colSize;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] size=br.readLine().split(" ");
        int[][] square=new int[Integer.parseInt(size[0])][Integer.parseInt(size[1])];
       rowSize=Integer.parseInt(size[0]);
        colSize=Integer.parseInt(size[1]);
        
        boolean[][] isVisited=new boolean[rowSize][colSize];
        for(int i=0;i<rowSize;i++){
            String[] side=br.readLine().split("");
            for(int k=0;k<colSize;k++){
                square[i][k]=Integer.parseInt(side[k]);
            }
        }
        Queue<Point> q=new LinkedList<>();
        q.add(new Point(0,0));
        isVisited[0][0]=true;
        int count=0;
       while(!q.isEmpty()){
            count++;
            int qSize=q.size();
            for(int j=0;j<qSize;j++){
                Point p=q.poll();
                int row=p.x;
                int col=p.y;
                if(row+1==rowSize&&col+1==colSize){
                    System.out.println(count);
                    return;
                }
                if(checkRange(row+1,col)&&square[row+1][col]==1&&!isVisited[row+1][col]){
                    q.add(new Point(row+1,col));
                    isVisited[row+1][col]=true;
                }
                if(checkRange(row,col+1)&&square[row][col+1]==1&&!isVisited[row][col+1]){
                    q.add(new Point(row,col+1));
                    isVisited[row][col+1]=true;
                }
                if(checkRange(row-1,col)&&square[row-1][col]==1&&!isVisited[row-1][col]){
                    q.add(new Point(row-1,col));
                    isVisited[row-1][col]=true;
                }
                if(checkRange(row,col-1)&&square[row][col-1]==1&&!isVisited[row][col-1]){
                    q.add(new Point(row,col-1));
                    isVisited[row][col-1]=true;
                }

            }
        }
    }
    public static boolean checkRange(int x,int y){
        return x<=(rowSize-1)&&x>=0&&y<=(colSize-1)&&y>=0;
    }
}