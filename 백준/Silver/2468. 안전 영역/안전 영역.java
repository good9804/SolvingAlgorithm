import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {
    static int N;
    static int answer;
    static int count;
    static int[][] pan;
    static boolean[][] isChecked;
    static Queue<Point> q=new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> set = new HashSet<>();
        N = Integer.parseInt(br.readLine());
        answer=Integer.MIN_VALUE;
        count=0;
        pan = new int[N][N];
        isChecked = new boolean[N][N];
        answer=Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                pan[i][j]=Integer.parseInt(st.nextToken());
                set.add(pan[i][j]);
            }
        }
        set.add(0);
        Iterator<Integer> itr = set.iterator();
        while(itr.hasNext()){
            int standard= itr.next();
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(pan[i][j]<=standard||isChecked[i][j]){
                        continue;
                    }
                    count++;
                    q.add(new Point(i,j));
                    while(!q.isEmpty()){
                        int qsize= q.size();
                        for(int a=0;a<qsize;a++){
                        Point p=q.poll();
                        int x=p.x;
                        int y=p.y;
                            if(isRange(x-1,y)&&!isChecked[x-1][y]&&pan[x-1][y]>standard){
                                isChecked[x-1][y]=true;
                                q.add(new Point(x - 1, y));
                            }

                            if(isRange(x+1,y)&&!isChecked[x+1][y]&&pan[x+1][y]>standard){
                                isChecked[x+1][y]=true;
                                q.add(new Point(x + 1, y));

                            }

                            if(isRange(x,y+1)&&!isChecked[x][y+1]&&pan[x][y+1]>standard){
                                isChecked[x][y+1]=true;
                                q.add(new Point(x , y+1));
                            }

                            if(isRange(x,y-1)&&!isChecked[x][y-1]&&pan[x][y-1]>standard){
                                isChecked[x][y-1]=true;
                                q.add(new Point(x , y-1));
                            }
                        }

                    }
                }}
            if(answer<count){
                answer=count;
            }
            for(int index=0;index<N;index++){
                Arrays.fill(isChecked[index],false);
            }
            count=0;


            }
        System.out.println(answer);


        }



public static boolean isRange(int x,int y){
        return x>=0&&x<N&&y>=0&&y<N;
}
}