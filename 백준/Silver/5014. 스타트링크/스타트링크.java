import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {
    static int f;
    static int s;
    static int g;
    static int u;
    static int d;
    static int answer;
    static boolean[] isChecked;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        isChecked=new boolean[f+1];
        answer=-1;
        count=-1;
        isChecked[s]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(s);
        while(!q.isEmpty()){
            int qsize=q.size();
            count++;
            for(int i=0;i<qsize;i++){
                int current=q.poll();
                if(g==current){
                    answer=count;
                    q.clear();
                    break;
                }
                if(isRange(current+u)&&!isChecked[current+u]){
                    isChecked[current+u]=true;
                    q.add(current+u);
                }
                if(isRange(current-d)&&!isChecked[current-d]){
                    isChecked[current-d]=true;
                    q.add(current-d);
                }
            }
        }
        if(answer==-1){
            System.out.println("use the stairs");
        }else System.out.println(answer);

    }
public static boolean isRange(int current){
        return current<=f&&current>=1;
}}