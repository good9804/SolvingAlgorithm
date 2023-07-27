import java.util.*;
class Solution {
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    //시작점 0 벽 -1 통로 1 레버 2 출구 3
    static int[][] pan;
    static int row;
    static int col;
    static Point start;
    static Point Lever;
    static Point exit;
    static int answer=-1;
    public int solution(String[] maps) {
        
        row=maps.length;
        col=maps[0].length();
        pan= new int[row][col];
        makePan(maps);//2차원 배열 생성
        if(!bfs(start,Lever)){
            return -1;
        }
        answer--;
        if(!bfs(Lever,exit)){
             return -1;
        }
        
        
        return answer;
    }
    static boolean isRange(int x,int y){
        return x>=0&&x<row&&y>=0&&y<col;
    }
    static boolean bfs(Point depart,Point goal){
        boolean[][] isVisited=new boolean[row][col];
        Queue<Point> q=new LinkedList<>();
        q.add(depart);
        isVisited[depart.x][depart.y]=true;
        while(!q.isEmpty()){
            answer++;
            int qsize=q.size();
            for(int i=0;i<qsize;i++){
                Point p=q.poll();
                if(p.x==goal.x&&p.y==goal.y){
                    return true;
                }
                for(int j=0;j<4;j++){
                    int tempX=p.x+dx[j];
                    int tempY=p.y+dy[j];
                    if(isRange(tempX,tempY)&&!isVisited[tempX][tempY]&&pan[tempX][tempY]>=0){
                        q.add(new Point(tempX,tempY));
                        isVisited[tempX][tempY]=true;
                        
                    }
                }
            }
        }
        return false;
    }
    static void makePan(String[] maps){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                pan[i][j]=check(maps[i].charAt(j),i,j);
            }
        }
    }
    static int check(char c,int x,int y){
        if(c=='S'){
            start=new Point(x,y);
            return 0;
        }
        else if(c=='E'){
            exit=new Point(x,y);
            return 3;
        }
        else if(c=='L'){
            Lever=new Point(x,y);
            return 2;
        }
        else if(c=='O'){
            return 1;
        }
        else {
            return -1;
        }
    }
}
class Point{
    int x;
    int y;
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }
}