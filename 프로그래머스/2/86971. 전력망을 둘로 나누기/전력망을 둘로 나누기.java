import java.util.*;
import java.awt.*;

class Solution {
    static boolean isConnect[][];
    static Queue<Point> q;
    static boolean[][] isVisted;
    static int answer1;
    static int answer2;
    static int size;
    public int solution(int n, int[][] wires) {
        isConnect=new boolean[n+1][n+1];
        isVisted=new boolean[n+1][n+1];
        size=n;
        q=new LinkedList<>();
        for(int i=0;i<wires.length;i++){
            isConnect[wires[i][0]][wires[i][1]]=true;
            isConnect[wires[i][1]][wires[i][0]]=true;
            q.add(new Point(wires[i][0],wires[i][1]));
        }
        int answer=100;
        while(!q.isEmpty()){
            Point p=q.poll();
            isConnect[p.x][p.y]=false;
            isConnect[p.y][p.x]=false;
            
            for(int i=1;i<=size;i++){
                Arrays.fill(isVisted[i],false);
                isVisted[i][i]=true;
            }
            ArrayList<Integer> arr=new ArrayList<>();
            for(int i=1;i<=size;i++){
                for(int j=1;j<=size;j++){
                    if(isConnect[i][j]&&!isVisted[i][j]){
                        int sum=0;
                        Queue<Integer> q=new LinkedList<>();
                        q.add(i);
                        while(!q.isEmpty()){
                            
                                    sum++;
                           int start=q.poll();
                            for(int k=1;k<=size;k++){
                                if(isConnect[start][k]&&!isVisted[start][k]){
                                    
                        isVisted[start][k]=true;
                        isVisted[k][start]=true;
                                    q.add(k);
                                }
                            }
                        }
                        arr.add(sum);
                    }
                }
            }
            if(arr.size()==1){arr.add(1);}
            answer=Math.min(answer,(Math.abs(arr.get(0)-arr.get(1))));
            
            isConnect[p.x][p.y]=true;
            isConnect[p.y][p.x]=true;
            
        }
        return answer;
    }
    
    }
