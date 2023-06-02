
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import java.util.*;
import java.util.List;

class Main {
    static int row;//행 사이즈
    static int col;//열 사이즈
    static int[][] pan;//정보를 담을 이차원 배열
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1,0 };//bfs를 위한 상하좌우


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        pan = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {//이차원 배열에 정보 담기
            String[] str = br.readLine().split("");
            for (int j = 1; j <= col; j++) {
                if (str[j-1].equals(".")) {
                    pan[i][j] = 0;//빈칸일시 0
                } else {
                    pan[i][j] = 1;//미네랄일시 1}
                }
            }
        }
        int ordercount = Integer.parseInt(br.readLine());//막대 던진 횟수
        boolean first = true;//차례를 결정하기위한 boolean
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < ordercount; i++) {
            int order = Integer.parseInt(st.nextToken());//막대 던진 높이
            if (first) {//창영이차례
                throwMackdae(row - order + 1, first);
                first = false;//막대던지기
            } else {
                throwMackdae(row - order + 1, first);
                first = true;
            }

        }//상근이 차례
        print();
    }
    static boolean isRange(int x,int y){
        return x>=1&&x<=row&&y>=1&&y<=col;
    }

    static void print(){
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                if(pan[i][j]==0){
                    sb.append(".");
                }else sb.append("x");
            }
           if(i!=row){ sb.append("\n");}
        }
        System.out.print(sb);
    }
    static void throwMackdae(int height,boolean first){
        if(first){
            for(int i=1;i<=col;i++){
                if(pan[height][i]==1){//미네랄 만날시
                    Queue<Point> queue = new LinkedList<>();//점들을 모으기위한 queue
                    HashSet<Point> apply = new HashSet<>();//중력 반영받을 점들을 모은 Set
                    pan[height][i]=0;
                    boolean[][] isVisited=new boolean[row+1][col+1];//중복 방문을 방지하기위한 배열 선언
                    isVisited[height][i]=true;//시작점 체크
                    queue.add(new Point(height,i));//시작점 담기
                    boolean[] prev=new boolean[4];//bfs로 방향 한곳마다 이어져있는 덩어리를 분리하여 탐색할 것이므로 반영하기전 미리 붙어있는 얼음을 체크 
                        Point current = queue.poll();
                        for(int index=0;index<4;index++){
                            int tempx=current.x+dx[index];
                            int tempy=current.y+dy[index];
                            if(isRange(tempx,tempy)&&pan[tempx][tempy]==1&&!isVisited[tempx][tempy]){
                                prev[index]=true;//상하좌우중 덩어리가 붙어있으면 true
                            }
                        }
                        for(int index=0;index<4;index++){//시작점에대한 방향 체크
                            int tempx=current.x+dx[index];
                            int tempy=current.y+dy[index];
                            if(isRange(tempx,tempy)&&pan[tempx][tempy]==1&&!isVisited[tempx][tempy]&&prev[index]){//반영되기전부터 원래 붙어있던 얼음덩어리면 탐색시작
                                queue.add(new Point(tempx,tempy));
                                apply.add(new Point(tempx,tempy));
                                isVisited[tempx][tempy]=true;
                                boolean isground = false;//땅에 붙어있는지 안붙어있는지 체크용
                                    while (!queue.isEmpty()) {
                                        Point currentpoint = queue.poll();


                                        for (int k = 0; k < 4; k++) {//bfs체크
                                            int tempxx = currentpoint.x + dx[k];
                                            int tempyy = currentpoint.y + dy[k];
                                            if (isRange(tempxx, tempyy) && pan[tempxx][tempyy] == 1 && !isVisited[tempxx][tempyy]) {
                                                queue.add(new Point(tempxx, tempyy));
                                                apply.add(new Point(tempxx,tempyy));
                                                isVisited[tempxx][tempyy] = true;
                                                if (tempxx == row) {//땅에 붙어있을시 
                                                    isground = true;//true로 변경
                                                }
                                            }
                                        }
                                    }
                                    if(isground){// 덩어리가 땅에붙어있었다면

                                        apply.clear();
                                        queue.clear();
                                        continue;//set,queue 비워준후 다음 방향 덩어리 check
                                    }else{Iterator<Point> iterator =apply.iterator();//땅이랑 떨어져있으므로 중력영향받기
                                    int min = Integer.MAX_VALUE;//떨어지는 간격 구하기위해 min
                                    while (iterator.hasNext()) {
                                        Point p = iterator.next();
                                        pan[p.x][p.y] = 0;
                                        for (int k = p.x + 1; k <= row; k++) {
                                            if (pan[k][p.y] == 1 && !apply.contains(new Point(k, p.y))) {//set에있지않은점이며,미네랄일시
                                                min = Math.min(min, k - p.x - 1);//땅에 붙어있는 미네랄 있는 점-원래점-1 (-1를 해준 이유는 원래 점이 3행이고 미네랄이 4행에 있을때
                                                                                // 변경없이 가만히 있어야하니까 -1을 해줘야한다
                                                break;
                                            }
                                        }
                                        min = Math.min(min, row - p.x);//자기 방향 아래로 미네랄이 아예 없는경우도 고려해서 바닥-미네랄있는행
                                    }
                                    Iterator<Point> iterator2 = apply.iterator();
                                    while (iterator2.hasNext()) {
                                        Point p = iterator2.next();
                                        pan[p.x + min][p.y] = 1;//간격만큼 이동
                                    }
                                }}

                            queue.clear();
                            apply.clear();
                            }
                        return;
                        }

                }
            }
        else{
            for(int i=col;i>=1;i--){
                if(pan[height][i]==1){//미네랄 만날시
                    Queue<Point> queue = new LinkedList<>();
                    HashSet<Point> apply = new HashSet<>();
                    pan[height][i]=0;
                    boolean[][] isVisited=new boolean[row+1][col+1];//중복 방문을 방지하기위한 배열 선언
                    isVisited[height][i]=true;//시작점 체크
                    queue.add(new Point(height,i));//시작점 담기
                    boolean[] prev=new boolean[4];
                    Point current = queue.poll();
                    for(int index=0;index<4;index++){
                        int tempx=current.x+dx[index];
                        int tempy=current.y+dy[index];
                        if(isRange(tempx,tempy)&&pan[tempx][tempy]==1&&!isVisited[tempx][tempy]){
                            prev[index]=true;
                        }
                    }
                    for(int index=0;index<4;index++){//시작점에대한 방향 체크
                        int tempx=current.x+dx[index];
                        int tempy=current.y+dy[index];
                        if(isRange(tempx,tempy)&&pan[tempx][tempy]==1&&!isVisited[tempx][tempy]&&prev[index]){
                            queue.add(new Point(tempx,tempy));
                            apply.add(new Point(tempx,tempy));
                            isVisited[tempx][tempy]=true;
                            boolean isground = false;
                            while (!queue.isEmpty()) {
                                Point currentpoint = queue.poll();


                                for (int k = 0; k < 4; k++) {//bfs체크
                                    int tempxx = currentpoint.x + dx[k];
                                    int tempyy = currentpoint.y + dy[k];
                                    if (isRange(tempxx, tempyy) && pan[tempxx][tempyy] == 1 && !isVisited[tempxx][tempyy]) {
                                        queue.add(new Point(tempxx, tempyy));
                                        apply.add(new Point(tempxx,tempyy));
                                        isVisited[tempxx][tempyy] = true;
                                        if (tempxx == row) {
                                            isground = true;
                                        }
                                    }
                                }
                            }
                            if(isground){

                                apply.clear();
                                queue.clear();
                                continue;
                            }else{Iterator<Point> iterator =apply.iterator();
                            int min = Integer.MAX_VALUE;
                            while (iterator.hasNext()) {
                                Point p = iterator.next();
                                pan[p.x][p.y] = 0;
                                for (int k = p.x + 1; k <= row; k++) {
                                    if (pan[k][p.y] == 1 && !apply.contains(new Point(k, p.y))) {
                                        min = Math.min(min, k - p.x - 1);
                                        break;
                                    }
                                }
                                min = Math.min(min, row - p.x);
                            }
                            Iterator<Point> iterator2 = apply.iterator();
                            while (iterator2.hasNext()) {
                                Point p = iterator2.next();
                                pan[p.x + min][p.y] = 1;
                            }
                        }}
                        queue.clear();
                        apply.clear();
                    }
                    return;
                }

            }
        }
}}












