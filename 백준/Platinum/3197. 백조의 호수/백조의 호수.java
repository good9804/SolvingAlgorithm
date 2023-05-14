
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
    static Queue<Point> water;
    static Queue<Point> birds;
    static int[][] pan;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,1,-1};
    static int[] disjoint;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        water = new LinkedList<>();
        disjoint=new int[row*col];
        boolean[] Visited=new boolean[row*col];
        boolean[] Visited2=new boolean[row*col];
        for(int i=0;i<row*col;i++){
            disjoint[i]=i;
        }
        pan=new int[row+1][col+1];
        birds = new LinkedList<>();
        for(int i=1;i<=row;i++){
            String[] str=br.readLine().split("");
            for(int j=1;j<=col;j++){
                if(str[j-1].equals(".")){pan[i][j]=0;
                    water.add(new Point(i,j));
                }
                else if(str[j-1].equals("X")){pan[i][j]=1;
                    }
                else{pan[i][j]=0;birds.add(new Point(i,j));
                    water.add(new Point(i,j));
                    }

            }
        }
        int bird1;
        int bird2;

            Point p= birds.poll();
            bird1=change(p.x,p.y);
        p= birds.poll();
        bird2=change(p.x,p.y);

        int count=1;
        while(true){
        int wsize=water.size();
        Arrays.fill(Visited,false);
        for(int w=0;w<wsize;w++){
            Point currentwater=water.poll();
            int currentwaterxy=change(currentwater.x,currentwater.y);
            for(int i=0;i<4;i++){
                int tempx=currentwater.x+dx[i];
                int tempy=currentwater.y+dy[i];

                int tempxy=change(tempx,tempy);
            if(isRange(tempx,tempy)&&pan[tempx][tempy]==1&&!Visited[tempxy]){
                Visited[tempxy]=true;
                water.add(new Point(tempx,tempy));
                if(find(tempxy)!=find(currentwaterxy)){
                    union(currentwaterxy,tempxy);
                }
                pan[tempx][tempy]=0;
            }else if(isRange(tempx,tempy)&&pan[tempx][tempy]!=1&&!Visited[tempxy]){
                Visited[tempxy]=true;
                if(find(tempxy)!=find(currentwaterxy)){
                    union(currentwaterxy,tempxy);
                }
            }

            }
        }

            if(find(bird1)==find(bird2)){
                System.out.println(count-1);
                return;
            }
        count++;
        }


        }
        static boolean isRange(int x,int y){
        return x>=1&&x<=row&&y>=1&&y<=col;
        }
        static void union(int a,int b){
        a=find(a);
        b=find(b);
        disjoint[a]=b;
        }

        static int find(int a){
        if(a==disjoint[a]){
            return a;
        }else return disjoint[a]=find(disjoint[a]);}


        static int change(int x,int y){
        return (x-1)*col+y-1;
        }
    }








