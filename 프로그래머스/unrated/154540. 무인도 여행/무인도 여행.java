import java.util.*;
class Solution {
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static boolean[][] isVisited;
    static int[][] pan;
    static int row;
    static int col;
    static ArrayList<Integer> result=new ArrayList<>();
    public int[] solution(String[] maps) {
        row=maps.length;
        col=maps[0].length();
        isVisited=new boolean[row][col];
        pan=new int[row][col];
        makePan(maps);
        bfs();
        if(result.size()==0){
            return new int[] {-1};
        }
        int[] answer=new int[result.size()];

        for(int i=0;i<answer.length;i++){
            answer[i]=result.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }

    static void bfs(){
        Queue<Point> q=new LinkedList<>();
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(pan[i][j]>0&&!isVisited[i][j]){
                    q.add(new Point(i,j));
                    isVisited[i][j]=true;
                    int answer=0;
                    while(!q.isEmpty()){
                        Point p=q.poll();
                        answer+=pan[p.x][p.y];
                        for(int z=0;z<4;z++){
                            int tempX=p.x+dx[z];
                            int tempY=p.y+dy[z];
                            if(isRange(tempX,tempY)&&!isVisited[tempX][tempY]&&pan[tempX][tempY]>0){
                                q.add(new Point(tempX,tempY));
                                isVisited[tempX][tempY]=true;
                                
                            }
                        }
                    }
                    result.add(answer);
                }
            }
        }
        
    }
    static boolean isRange(int x,int y){
        return x>=0&&x<row&&y>=0&&y<col;
    }
    static void makePan(String[] maps){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                char c=maps[i].charAt(j);
                if(c=='X'){
                    pan[i][j]=0;
                }else{
                    pan[i][j]=c-'0';
                }
            }
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