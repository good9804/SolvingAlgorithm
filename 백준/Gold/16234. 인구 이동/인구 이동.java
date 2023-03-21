

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;
import java.util.regex.Pattern;

class Main {
    static int size;
    static int order;
    static int[][] pan;
    static boolean[][] checked;
    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};

    static int L;
    static int R;

    public static void main(String[] args) throws IOException {
        //1.국경선을 공유하는 두 나라의 인구 차이가 L명 이상 R명 이하라면 두나라가 공유하는 국경선을 오늘 하루동안 연다.
        //2.국경선이 모두열리면 인구이동시작
        //3.국경선이 열러있는 인접한 칸만 이용해 이동가능+ 그나라를 하루동안 연합
        //4.연합을 이루고있는 각칸의 인구수는 (연합의인구수)/연합을 이루고있는 칸의 개수
        //5.연합해체 모든 국경선 닫기
        //각 나라의 인구수가 주어졌을때 인구이동 며칠동안 발생하는지
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());
        pan=new int[size+1][size+1];
        checked=new boolean[size+1][size+1];
        for(int i=1;i<=size;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=size;j++){
                pan[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer=0;


        HashMap<Queue<Point>, Integer> map = new HashMap<>();
        while(true){
        for(int i=1;i<=size;i++){
            for(int j=1;j<=size;j++){
                if(!checked[i][j]){
                    Queue<Point> q=new LinkedList<>();
                    Queue<Point> q2=new LinkedList<>();
                    int sum=0;
                    q.add(new Point(i,j));
                    boolean flag=false;
                    while(!q.isEmpty()){
                        int qsize = q.size();
                        for(int count=0;count<qsize;count++) {
                            Point p = q.poll();
                            int x = p.x;
                            int y = p.y;

                            for (int k = 0; k < 4; k++) {
                            int tempx=x+dx[k];
                            int tempy=y+dy[k];
                            if(tempx>=1&&tempx<=size&&tempy<=size&&tempy>=1&&!checked[tempx][tempy]&&Math.abs(pan[x][y]-pan[tempx][tempy])>=L&&Math.abs(pan[x][y]-pan[tempx][tempy])<=R){
                                if(!flag){
                                    flag=true;
                                    checked[x][y]=true;
                                    sum+=pan[x][y];
                                    q2.add(new Point(x,y));
                                }
                                q.add(new Point(tempx,tempy));
                                sum+=pan[tempx][tempy];
                                q2.add(new Point(tempx,tempy));
                                checked[tempx][tempy]=true;
                            }

                            }

                        }

                    }
                    if(flag){
                    map.put(q2,sum);}




                }
            }
        }
        if(map.isEmpty()){
            System.out.println(answer);
            return;
        }
        for( Queue<Point> queue : map.keySet() ){
            int sum= map.get(queue);
            int people= sum/queue.size();
            while(!queue.isEmpty()){
                Point p=queue.poll();
                pan[p.x][p.y]=people;
            }
        }
        map.clear();
        for(int i=1;i<=size;i++){
            Arrays.fill(checked[i],false);
        }



        answer++;}


    }





    }








