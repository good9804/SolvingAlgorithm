class Solution {
    static int countO=0;
    static int countX=0;
    static int ticO=0;
    static int ticX=0;
    static int[][] pan=new int[3][3];// . 0 O 1 X 2
    static int[] dx={1,0,1};//남, 동,대각선 남동
    static int[] dy={0,1,1};
    public int solution(String[] board) {
        makePan(board);
        if(countX>countO||Math.abs(countX-countO)>1){//선공 헷갈리거나 순서가 지켜지지않았을때
            return 0;
        }
        findAnswer();
        System.out.println(ticO+" "+ticX);
        if(ticO==0&&ticX==0){
            return 1;
        }
        else if(ticX>ticO&&countO-countX==0){return 1;}
        else if(ticX<ticO&&countO-countX==1){return 1;}
        
        return 0;
    }
    
    static void findAnswer(){
        for(int i=0;i<3;i++){
            if(pan[i][0]==0){continue;}
                int tempX=i;
                int tempY=0;
                int count=0;
                for(int z=0;z<2;z++){
                    
                    tempY++;
                    if(pan[tempX][tempY]==pan[i][0]){
                        count++;
                    }else break;
                
                }
                if(count==2){
                    if(pan[i][0]==1){
                        ticO++;
                    }
                    else{ticX++;}
                }
        }
        for(int i=0;i<3;i++){
            if(pan[0][i]==0){continue;}
                int tempX=0;
                int tempY=i;
                int count=0;
                for(int z=0;z<2;z++){
                    tempX++;
                    if(pan[tempX][tempY]==pan[0][i]){
                        count++;
                    }else break;
                    
                
                }
                if(count==2){
                    if(pan[0][i]==1){
                        ticO++;
                    }
                    else{ticX++;}
                }
        }
        if(pan[0][0]!=0){
            int tempX=0;
            int tempY=0;
            int count=0;
            for(int z=0;z<2;z++){
                
                    tempX++;
                    tempY++;
                    if(pan[tempX][tempY]==pan[0][0]){
                        count++;
                    }else break;
                }
                if(count==2){
                    if(pan[0][0]==1){
                        ticO++;
                    }
                    else{ticX++;}
                }
        }
        int count=0;
        if(pan[2][0]!=0){
            int tempX=2;
            int tempY=0;
            for(int z=0;z<2;z++){
                
                    tempX--;
                    tempY++;
                    if(pan[tempX][tempY]==pan[2][0]){
                        count++;
                    }else break;
                }
                if(count==2){
                    if(pan[2][0]==1){
                        ticO++;
                    }
                    else{ticX++;}
                }
        }
        
        
        
    }
    static boolean isRange(int x,int y){
        return x>=0&&x<3&&y>=0&&y<3;
    }
    static Point change(int x,int y){
        Point p=new Point(x,y);
       if(x>2){
           p.x=0;
       } 
        if(y>2){
            p.y=0;
        }
        return p;
        
        
    }
    static void makePan(String[] board){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                pan[i][j]=check(board[i].charAt(j));
            }
        }
    }
    static int check(char c){
        if(c=='.'){
            return 0;
        }
        else if(c=='O'){
            countO++;
            return 1;
        }
        else{
            countX++;
            return 2; 
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