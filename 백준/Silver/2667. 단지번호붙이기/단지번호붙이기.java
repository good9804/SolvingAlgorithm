
import java.util.*;
import java.lang.*;
import java.io.*;
import java.awt.*;
class Main{
    static boolean[][] home;
    static boolean[][] isChecked;
    static ArrayList<Integer> answer=new ArrayList<>();
    static int size;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        size=Integer.parseInt(br.readLine());
        home=new boolean[size][size];
        isChecked=new boolean[size][size];
        for(int i=0;i<size;i++){
            String[] live=br.readLine().split("");
            for(int k=0;k<size;k++){
                if(Integer.parseInt(live[k])==1){
                    home[i][k]=true;
                }
            } }

        Queue<Point> q=new LinkedList<>();
        for(int row=0;row<size;row++){
            for(int col=0;col<size;col++){
                if(home[row][col]&&!isChecked[row][col]){

                    q.add(new Point(row,col));
                    isChecked[row][col]=true;
                    int count=1;
                    while(!q.isEmpty()){

                        Point p=q.poll();
                        int currentRow=p.x;
                        int currentCol=p.y;
                        if(isRange(currentRow-1,currentCol)&&home[currentRow-1][currentCol]&&!isChecked[currentRow-1][currentCol])
                        {
                            q.add(new Point(currentRow-1,currentCol));
                            count++;
                            isChecked[currentRow-1][currentCol]=true;
                        }
                        if(isRange(currentRow,currentCol-1)&&home[currentRow][currentCol-1]&&!isChecked[currentRow][currentCol-1])
                        {
                            q.add(new Point(currentRow,currentCol-1));
                            count++;
                            isChecked[currentRow][currentCol-1]=true;
                        }
                        if(isRange(currentRow+1,currentCol)&&home[currentRow+1][currentCol]&&!isChecked[currentRow+1][currentCol])
                        {
                            q.add(new Point(currentRow+1,currentCol));
                            count++;
                            isChecked[currentRow+1][currentCol]=true;
                        }
                        if(isRange(currentRow,currentCol+1)&&home[currentRow][currentCol+1]&&!isChecked[currentRow][currentCol+1])
                        {
                            q.add(new Point(currentRow,currentCol+1));
                            count++;
                            isChecked[currentRow][currentCol+1]=true;
                        }}
                    answer.add(count);
                }
            }
        }
        System.out.println(answer.size());
        Collections.sort(answer);
        for(int index=0;index<answer.size();index++){
            System.out.println(answer.get(index));
        }
    }
    public static boolean isRange(int x,int y){
        return x>=0&&x<=(size-1)&&y>=0&&y<=(size-1);
    }
}