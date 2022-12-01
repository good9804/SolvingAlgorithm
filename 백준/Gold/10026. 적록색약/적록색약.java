
import java.util.*;
import java.lang.*;
import java.io.*;
import java.awt.*;
class Main{
    static int[][] picture;
    static boolean[][] isChecked;
    static int size;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        size=Integer.parseInt(br.readLine());
        picture=new int[size][size];
        isChecked=new boolean[size][size];
        for(int i=0;i<size;i++){
            String[] live=br.readLine().split("");
            for(int k=0;k<size;k++){
                if(live[k].equals("R")){
                    picture[i][k]=0;
                }else if(live[k].equals("G")){
                    picture[i][k]=1;
                } else picture[i][k]=2;
            } }

        Queue<Point> q=new LinkedList<>();
        int count=0;
        for(int row=0;row<size;row++){
            for(int col=0;col<size;col++){
                if(!isChecked[row][col]){
                count++;
                    q.add(new Point(row,col));
                    isChecked[row][col]=true;

                    while(!q.isEmpty()){

                        Point p=q.poll();
                        int currentRow=p.x;
                        int currentCol=p.y;
                        int color=picture[currentRow][currentCol];
                        if(isRange(currentRow-1,currentCol)&&picture[currentRow-1][currentCol]==color&&!isChecked[currentRow-1][currentCol])
                        {
                            q.add(new Point(currentRow-1,currentCol));

                            isChecked[currentRow-1][currentCol]=true;
                        }
                        if(isRange(currentRow,currentCol-1)&&picture[currentRow][currentCol-1]==color&&!isChecked[currentRow][currentCol-1])
                        {
                            q.add(new Point(currentRow,currentCol-1));

                            isChecked[currentRow][currentCol-1]=true;
                        }
                        if(isRange(currentRow+1,currentCol)&&picture[currentRow+1][currentCol]==color&&!isChecked[currentRow+1][currentCol])
                        {
                            q.add(new Point(currentRow+1,currentCol));

                            isChecked[currentRow+1][currentCol]=true;
                        }
                        if(isRange(currentRow,currentCol+1)&&picture[currentRow][currentCol+1]==color&&!isChecked[currentRow][currentCol+1])
                        {
                            q.add(new Point(currentRow,currentCol+1));

                            isChecked[currentRow][currentCol+1]=true;
                        }}

                }
            }
        }
        for(int index=0;index<size;index++){
            Arrays.fill(isChecked[index],false);
        }
        System.out.print(count+" ");
        count=0;
        for(int row=0;row<size;row++){
            for(int col=0;col<size;col++){
                if(!isChecked[row][col]){
                    count++;
                    q.add(new Point(row,col));
                    isChecked[row][col]=true;

                    while(!q.isEmpty()){

                        Point p=q.poll();
                        int currentRow=p.x;
                        int currentCol=p.y;
                        int color=picture[currentRow][currentCol];
                        if(color>1){
                        if(isRange(currentRow-1,currentCol)&&picture[currentRow-1][currentCol]==color&&!isChecked[currentRow-1][currentCol])
                        {
                            q.add(new Point(currentRow-1,currentCol));

                            isChecked[currentRow-1][currentCol]=true;
                        }
                        if(isRange(currentRow,currentCol-1)&&picture[currentRow][currentCol-1]==color&&!isChecked[currentRow][currentCol-1])
                        {
                            q.add(new Point(currentRow,currentCol-1));

                            isChecked[currentRow][currentCol-1]=true;
                        }
                        if(isRange(currentRow+1,currentCol)&&picture[currentRow+1][currentCol]==color&&!isChecked[currentRow+1][currentCol])
                        {
                            q.add(new Point(currentRow+1,currentCol));

                            isChecked[currentRow+1][currentCol]=true;
                        }
                        if(isRange(currentRow,currentCol+1)&&picture[currentRow][currentCol+1]==color&&!isChecked[currentRow][currentCol+1])
                        {
                            q.add(new Point(currentRow,currentCol+1));

                            isChecked[currentRow][currentCol+1]=true;
                        }} else{
                            if(isRange(currentRow-1,currentCol)&&picture[currentRow-1][currentCol]<2&&!isChecked[currentRow-1][currentCol])
                            {
                                q.add(new Point(currentRow-1,currentCol));

                                isChecked[currentRow-1][currentCol]=true;
                            }
                            if(isRange(currentRow,currentCol-1)&&picture[currentRow][currentCol-1]<2&&!isChecked[currentRow][currentCol-1])
                            {
                                q.add(new Point(currentRow,currentCol-1));

                                isChecked[currentRow][currentCol-1]=true;
                            }
                            if(isRange(currentRow+1,currentCol)&&picture[currentRow+1][currentCol]<2&&!isChecked[currentRow+1][currentCol])
                            {
                                q.add(new Point(currentRow+1,currentCol));

                                isChecked[currentRow+1][currentCol]=true;
                            }
                            if(isRange(currentRow,currentCol+1)&&picture[currentRow][currentCol+1]<2&&!isChecked[currentRow][currentCol+1])
                            {
                                q.add(new Point(currentRow,currentCol+1));

                                isChecked[currentRow][currentCol+1]=true;
                            }}

                }
            }
        }

    }
        System.out.print(count);
    }
    public static boolean isRange(int x,int y){
        return x>=0&&x<=(size-1)&&y>=0&&y<=(size-1);
    }
    }