import java.util.*;
import java.math.*;
import java.awt.*;
class Solution {
    static int[] dx={0,1,-1,0};
    static int[] dy={-1,0,0,1};
    static int row;
    static int col;
    public int solution(int[][] maps) {
        
        row=maps.length;
        col=maps[0].length;
        boolean[][] isVisited=new boolean[row][col];
        Queue<Point> q=new LinkedList<>();
        q.add(new Point(0,0));
        isVisited[0][0]=true;
        int answer=0;
        while(!q.isEmpty()){
            answer++;
            
            int qsize=q.size();
            for(int k=0;k<qsize;k++){
            Point p=q.poll();
            if(p.x==row-1&&p.y==col-1){
                return answer;
            }
            for(int i=0;i<4;i++){
                int tempx=p.x+dx[i];
                int tempy=p.y+dy[i];
                if(isRange(tempx,tempy)&&!isVisited[tempx][tempy]&&maps[tempx][tempy]==1){
                    isVisited[tempx][tempy]=true;
                    q.add(new Point(tempx,tempy));
                }
            }
        }}
        return -1;
    }
    static boolean isRange(int x,int y){
        return x>=0&&x<row&&y>=0&&y<col;
    }
}
