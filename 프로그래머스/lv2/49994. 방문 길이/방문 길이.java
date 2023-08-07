import java.util.*;
class Solution {
    static boolean[][][] isVisited=new boolean[11][11][4];
    static int row=10;
    static int col=10;
    public int solution(String dirs) {
        int answer = 0;
        int x=5;
        int y=5;
        for(int i=0;i<dirs.length();i++){
            if(dirs.charAt(i)=='U'){
                if(isRange(x-1,y)&&(!isVisited[x-1][y][0]&&!isVisited[x][y][1])){
                   
                    isVisited[x-1][y][0]=true;
                    isVisited[x][y][1]=true;
                     x--;
                    answer++;
                }else if(isRange(x-1,y)&&(isVisited[x-1][y][0]||isVisited[x][y][1])){
                    x--;
                }
            }else if(dirs.charAt(i)=='D'){
                if(isRange(x+1,y)&&(!isVisited[x+1][y][1]&&!isVisited[x][y][0])){
                   isVisited[x+1][y][1]=true;
                    isVisited[x][y][0]=true;
                     x++;
                    answer++;
                }else if(isRange(x+1,y)&&(isVisited[x+1][y][1]||isVisited[x][y][0])){
                    x++;
                }
                
            }else if(dirs.charAt(i)=='R'){
                if(isRange(x,y+1)&&(!isVisited[x][y+1][2]&&!isVisited[x][y][3])){
                    isVisited[x][y+1][2]=true;
                    isVisited[x][y][3]=true;
                    y++;
                    answer++;
                }else if(isRange(x,y+1)&&(isVisited[x][y+1][2]||isVisited[x][y][3])){
                    y++;
                }
                
            }else{
                 if(isRange(x,y-1)&&(!isVisited[x][y-1][3]&&!isVisited[x][y][2])){
                   isVisited[x][y-1][3]=true;
                    isVisited[x][y][2]=true;
                    y--;
                    answer++;
                }else if(isRange(x,y-1)&&(isVisited[x][y-1][3]||isVisited[x][y][2])){
                    y--;
                }
                
            }
    }
        
        return answer;
    
}
    static boolean isRange(int x,int y){
        return x>=0&&x<=row&&y>=0&&y<=col;
    }
}


