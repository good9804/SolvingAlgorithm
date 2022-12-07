import java.io.*;
import java.lang.*;
import java.util.*;
import java.awt.*;
class Main{
    static boolean[][] isChecked;
    static int[][] bat;
    static int col;
    static int row;
    static int zeroTomato=0;
    static int firstTomato=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        col=Integer.parseInt(st.nextToken());
        row=Integer.parseInt(st.nextToken());
        isChecked=new boolean[row][col];
        bat=new int[row][col];
        for(int i=0;i<row;i++){
            st=new StringTokenizer(br.readLine());
            int count=0;
            while(st.hasMoreTokens()){
                bat[i][count++]=Integer.parseInt(st.nextToken());
            }
        }
        Queue<Point> q=new LinkedList<>();
        for(int j=0;j<row;j++){
            for(int k=0;k<col;k++){
                if(bat[j][k]==1){
                    q.add(new Point(j,k));
                    isChecked[j][k]=true;
                }else if(bat[j][k]==0){
                    zeroTomato++;
                    firstTomato++;
                }
            }
        }
        int answer=0;
        while(!q.isEmpty()){
            if(firstTomato>0&&zeroTomato==0){
                break;
            }
            answer++;
            int qsize=q.size();
            for(int temp=0;temp<qsize;temp++){
                Point p=q.poll();
                int x=(int)p.getX();
                int y=(int)p.getY();
                if(isRange(x-1,y)&&bat[x-1][y]==0&&!isChecked[x-1][y]){
                    q.add(new Point(x-1,y));
                    isChecked[x-1][y]=true;
                    zeroTomato--;
                }
                if(isRange(x+1,y)&&bat[x+1][y]==0&&!isChecked[x+1][y]){
                    q.add(new Point(x+1,y));
                    isChecked[x+1][y]=true;
                    zeroTomato--;
                }
                if(isRange(x,y-1)&&bat[x][y-1]==0&&!isChecked[x][y-1]){
                    q.add(new Point(x,y-1));
                    isChecked[x][y-1]=true;
                    zeroTomato--;
                }
                if(isRange(x,y+1)&&bat[x][y+1]==0&&!isChecked[x][y+1]){
                    q.add(new Point(x,y+1));
                    isChecked[x][y+1]=true;
                    zeroTomato--;
                }


            }
        }

        if(!isTrue()&&firstTomato==0){
            System.out.println("0");
        }else if(!isTrue()&&zeroTomato>0){
            System.out.println("-1");
        }else if(isTrue()&&firstTomato==0){
            System.out.println("0");
        }else System.out.println(answer);

    }
    static boolean isRange(int x,int y){
        return x>=0&&x<=row-1&&y>=0&&y<=col-1;
    }
    static boolean isTrue(){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!isChecked[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}