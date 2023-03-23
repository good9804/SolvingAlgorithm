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
    static boolean[] checked;
    static int size;
    static ArrayList<Point> people=new ArrayList<>();
    static ArrayList<Point> chicken=new ArrayList<>();
    static int order;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        order = Integer.parseInt(st.nextToken());
        min=Integer.MAX_VALUE;

        pan=new int[size+1][size+1];
        for(int i=1;i<=size;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=size;j++){
                int temp= Integer.parseInt(st.nextToken());
                pan[i][j] =temp;
                if(temp==1){
                    people.add(new Point(i,j));
                }
                else if(temp==2){
                    chicken.add(new Point(i,j));
                }
            }
        }
        checked=new boolean[chicken.size()];
        dfs(0,0);
        System.out.println(min);



    }
    static void dfs(int start,int current){
        if(current==order){
            int sum=0;
            for(int i=0;i<people.size();i++){
                int temp=Integer.MAX_VALUE;
                Point p=people.get(i);
                for(int j=0;j<chicken.size();j++){
                if(checked[j]){
                    Point c=chicken.get(j);
                    int length=Math.abs(p.x-c.x)+Math.abs(p.y-c.y);
                    temp=Math.min(temp,length);

                }

                }
                sum+=temp;
            }
            min=Math.min(sum,min);


            return;
        }

        for(int j=start;j<chicken.size();j++){
            checked[j]=true;
            dfs(j+1,current+1);
            checked[j]=false;
        }



    }


}








