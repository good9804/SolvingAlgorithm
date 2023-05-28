
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import java.util.*;

class Main {
    static int row;
    static int col;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,0-1,1};
    static Queue<Point> ice=new LinkedList<>();
    static int[][] pan;
    static int[] unionarr;
    static Point firstDuck;
    static Point secondDuck;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        pan=new int[row+1][col+1];
        unionarr=new int[(row*col)+1];
        for(int i=1;i<unionarr.length;i++){
            unionarr[i]=i;
        }
        boolean flag=false;
        for(int i=1;i<=row;i++){
            String[] str=br.readLine().split("");
            for(int j=1;j<=col;j++){
            if(str[j-1].equals("X")){
                pan[i][j]=1;
            }else if(str[j-1].equals("L")){
                pan[i][j]=0;

                ice.add(new Point(i,j));
                if(!flag){
                    flag=true;
                    firstDuck=new Point(i,j);
                }else secondDuck=new Point(i,j);
            }else {
                pan[i][j]=0;
                ice.add(new Point(i,j));
            }
        }}
        int day=0;
        while(true){
            day++;
            melting();
            if(isMeet()){
                System.out.println(day-1);
                return;
            }

        }
    }
    static boolean isRange(int x,int y){
        return x>=1&&x<=row&&y>=1&&y<=col;
    }
    static void union(int a,int b){
        a=find(a);
        b=find(b);
        unionarr[a]=b;
    }
    static int find(int a){
        if(unionarr[a]==a){
            return a;
        }else return unionarr[a]=find(unionarr[a]);
    }
    static boolean isMeet(){
        if(find((firstDuck.x-1)*col+firstDuck.y)==find((secondDuck.x-1)*col+secondDuck.y)){
            return  true;
        }
        return false;
    }
    static void melting(){
        int icesize = ice.size();
        boolean[][] isVisted=new boolean[row+1][col+1];
        for(int s=0;s<icesize;s++){
            Point currentice = ice.poll();
            for(int i=0;i<4;i++){
                int tempx=currentice.x+dx[i];
                int tempy=currentice.y+dy[i];
                if(isRange(tempx,tempy)&&pan[tempx][tempy]==1&&!isVisted[tempx][tempy]){
                    pan[tempx][tempy]=0;
                    ice.add(new Point(tempx, tempy));
                    isVisted[tempx][tempy]=true;
                    if(find((currentice.x-1)*col+currentice.y)!=(tempx-1)*col+tempy){
                    union((currentice.x-1)*col+currentice.y,(tempx-1)*col+tempy);}
                }else if(isRange(tempx,tempy)&&pan[tempx][tempy]==0&&!isVisted[tempx][tempy]){
                    isVisted[tempx][tempy]=true;
                    if(find((currentice.x-1)*col+currentice.y)!=(tempx-1)*col+tempy){
                        union((currentice.x-1)*col+currentice.y,(tempx-1)*col+tempy);}
            }
        }
    }
    }}










