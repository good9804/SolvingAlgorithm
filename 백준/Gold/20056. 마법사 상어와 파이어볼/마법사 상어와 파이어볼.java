
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;
import java.util.regex.Pattern;

class Main {
    static int[] dx={-1,-1,0,1,1,1,0,-1};
    static int[] dy={0,1,1,1,0,-1,-1,-1};
    static Queue<ball>[][] pan;
    static int size;
    public static void main(String[] args) throws IOException {
        //NxN 파이어볼 M개 위치 (r,c) 질량m 방향d 속력s
        //끝과끝은 연결되어잇음
        //1.모든 파이어볼 방향 d로 s칸만큼 이동
        //2.이동후 2개이상 파이어볼있는칸에서 파이어볼은 하나로 합쳐지고 4개로나뉘어진다
        //3. 나누어진 파이어볼의 질량은 (질량의합)/5, 속력은 속력의합/개수,합쳐지는 방향이 모두 홀수거나 짝수면 0,2,4,6 그렇지않으면 1357
        //0인 파이어볼소멸
        //k번 명령후 남아있는 파이어볼의 질량의합
        //입력 N M K,M개줄에 파이어볼정보 r c m s d


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        int ballcount = Integer.parseInt(st.nextToken());
        int order = Integer.parseInt(st.nextToken());
        int answer = 0;
        pan=new Queue[size+1][size+1];
        for(int i=1;i<=size;i++){
            for(int j=1;j<=size;j++){
                pan[i][j]=new LinkedList<ball>();
            }
        }
        for(int i=0;i<ballcount;i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            pan[r][c].add(new ball(r,c,m,s,d));
        }
        for(int play=0;play<order;play++) {

            for (int i = 1; i <= size; i++) {
                for (int j = 1; j <= size; j++) {
                    int psize = pan[i][j].size();
                    for(int s=0;s<psize;s++){

                        if (pan[i][j].isEmpty()||pan[i][j].peek().r != i || pan[i][j].peek().c != j) {
                            break;
                        }
                        ball b = pan[i][j].poll();
                        move(b);}

                    }
                }

             answer = 0;

            for (int i = 1; i <= size; i++) {
                for (int j = 1; j <= size; j++) {
                    if (pan[i][j].size() == 1) {
                        ball b = pan[i][j].poll();
                        b.r = i;
                        b.c = j;
                        pan[i][j].add(b);
                        answer += b.m;
                    } else if (pan[i][j].size() > 1) {
                        int summ = 0;
                        int sums = 0;
                        int sumball = 0;
                        boolean flag = false;
                        int temp = pan[i][j].peek().d % 2;
                        while (!pan[i][j].isEmpty()) {
                            ball b = pan[i][j].poll();
                            if (!flag) {
                                if (temp != b.d % 2) {
                                    flag = true;
                                }
                            }
                            summ += b.m;
                            sums += b.s;
                            sumball++;


                        }
                        summ /= 5;
                        if (summ == 0) {
                            pan[i][j].clear();
                            continue;
                        }
                        answer += summ * 4;
                        sums /= sumball;
                        if (flag) {
                            for (int q = 0; q < 4; q++) {

                                pan[i][j].add(new ball(i, j, summ, sums, 2 * q + 1));
                            }
                        } else {
                            for (int q = 0; q < 4; q++) {

                                pan[i][j].add(new ball(i, j, summ, sums, 2 * q));
                            }
                        }


                    }
                }
            }
        }
        System.out.println(answer);



   }
   static void move(ball b){
        int mod=0;

        int tempx=b.r+dx[b.d]*b.s%size;
       int tempy=b.c+dy[b.d]*b.s%size;
       if(tempx<1){
           tempx=size-Math.abs(tempx);
       }
       if(tempx>size){
           tempx-=size;
       }
       if(tempy<1){
           tempy=size-Math.abs(tempy);
       }
       if(tempy>size){
           tempy-=size;
       }
       pan[tempx][tempy].add(b);






   }
}
class ball{
    int r;
    int c;
    int m;
    int s;
    int d;

    public ball(int r, int c, int m, int s, int d) {
        this.r = r;
        this.c = c;
        this.m = m;
        this.d = d;
        this.s = s;
    }
}








