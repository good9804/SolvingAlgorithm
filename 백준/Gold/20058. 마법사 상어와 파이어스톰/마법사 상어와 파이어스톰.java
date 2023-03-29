
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;
import java.util.regex.Pattern;

class Main {
    static int[][] pan;
    static int[][] pan2;
    static boolean[][] isChecked;
    static boolean[][] isVisited;
    static int size;
    static int[] dx={-1,1,0,0};
    static int[] dy={-0,0,1,-1};
    static ArrayList<Queue<Integer>> rotationq;
    static int realsize;
    static int firstanswer;
    static int secondanswer;

    public static void main(String[] args) throws IOException {
        //2^n * 2^n 격자 , 2^L * 2^L 격자를 나누고 격자단위로 90회전//완료
        //얼음있는칸과 3개이상 인접해있지않은 칸의 얼음양 -1
        //동시에 일어난다고했으니 변화된값을 어떻게보관해서 반영할지 고민
        //Q번 시전후 남아있는얼음 A[r][c]의 합,남아있는얼음중 가장큰 덩어리가 차지하는칸의개수(양수로 제일크게 연결되어있는 칸의개수)
        //입력N Q,각 칸 얼음양, 시전한 L
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        size=Integer.parseInt(st.nextToken());
         realsize=(int)Math.pow(2,size);
        int order=Integer.parseInt(st.nextToken());
        rotationq = new ArrayList<>();
        pan=new int[realsize+1][realsize+1];
        pan2=new int[realsize+1][realsize+1];
        isVisited=new boolean[realsize+1][realsize+1];
        for(int i=1;i<=realsize;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=realsize;j++){
                pan[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<order;i++){
            int L = Integer.parseInt(st.nextToken());

            int Lsize=(int)Math.pow(2,L);
            int count=realsize/Lsize;
            if(L!=0){
            for(int j=1;j<=realsize;j+=Lsize){
                for(int k=1;k<=realsize;k+=Lsize){

                    int initcol=(k+k+Lsize-1)/2;
                    int initrow=(j+j+Lsize-1)/2;
                    rotation(initrow,initcol,j,k);




                }
            }}
            for(int j=1;j<=realsize;j++){
                for(int k=1;k<=realsize;k++){
                    check(j, k);

                }}
             firstanswer=0;
            for(int j=1;j<=realsize;j++){
                for(int k=1;k<=realsize;k++){
                    if(pan[j][k]>=1){
                    pan[j][k]+=pan2[j][k];
                    firstanswer+=pan[j][k];}
                    pan2[j][k]=0;
                    isVisited[j][k]=false;
                }}
            secondanswer=Integer.MIN_VALUE;
            Queue<Point> q = new LinkedList<>();;
            for(int j=1;j<=realsize;j++){
                for(int k=1;k<=realsize;k++){
                    if(!isVisited[j][k]){
                        q.add(new Point(j, k));
                        int ice=0;
                        while(!q.isEmpty()){
                            Point p= q.poll();
                            for(int n=0;n<4;n++){
                                int tempx=p.x+dx[n];
                                int tempy=p.y+dy[n];
                                if(isRange(tempx,tempy)&&!isVisited[tempx][tempy]&&pan[tempx][tempy]>=1){
                                    isVisited[tempx][tempy]=true;
                                    q.add(new Point(tempx,tempy));
                                    ice++;
                                }

                            }
                            secondanswer=Math.max(ice,secondanswer);
                        }

                    }

                }}












        }


        System.out.println(firstanswer);
        System.out.println(secondanswer);


 }
 static boolean isRange(int row,int col){
        return row>=1&&row<=realsize&&col>=1&&col<=realsize;
 }
 static void check(int row,int col){
        int count=0;
        for(int i=0;i<4;i++){
            int tempx=row+dx[i];
            int tempy=col+dy[i];
            if(!isRange(tempx,tempy)||pan[tempx][tempy]<1){
                count++;
            }


        }
        if(count>=2){
            pan2[row][col]=-1;
        }


 }

 static void rotation(int row,int col,int maxrow,int maxcol){
        int startrow=row;
     int startcol=col;
     int count=1;
     for(int i=0;i<4;i++){
         rotationq.add(new LinkedList<>());
     }
     int order=Math.abs(row-maxrow);
        for(int k=0;k<=order;k++){
            int step=2*count;

            for(int i=startrow;i<=startrow+step-1;i++){
                rotationq.get(0).add(pan[i][startcol]);
            }
            for(int i=startcol;i<=startcol+step-1;i++){
                rotationq.get(1).add(pan[startrow][i]);

            }
            for(int i=startrow;i<=startrow+step-1;i++){
                rotationq.get(2).add(pan[i][startcol+step-1]);

            }
            for(int i=startcol;i<=startcol+step-1;i++){
                rotationq.get(3).add(pan[startrow+step-1][i]);

            }

            for(int i=startrow;i<=startrow+step-1;i++){
                pan[i][startcol]=rotationq.get(3).poll();
            }
            for(int i=startcol+step-1;i>=startcol;i--){
                pan[startrow][i]=rotationq.get(0).poll();
            }
            for(int i=startrow;i<=startrow+step-1;i++){
                pan[i][startcol+step-1]=rotationq.get(1).poll();
            }
            for(int i=startcol+step-1;i>=startcol;i--){
                pan[startrow+step-1][i]=rotationq.get(2).poll();
            }
            startrow-=1;
            startcol-=1;
            count++;
            rotationq.get(0).clear();
            rotationq.get(1).clear();
            rotationq.get(2).clear();
            rotationq.get(3).clear();


        }
     rotationq.clear();
    }

 }









