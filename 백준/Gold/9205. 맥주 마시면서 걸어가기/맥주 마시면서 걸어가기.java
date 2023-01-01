import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int test = Integer.parseInt(st.nextToken());
        for(int count=0;count<test;count++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            Point[] map = new Point[size + 2];
            boolean[][] con = new boolean[size + 2][size + 2];
            boolean[] isChecked = new boolean[size + 2];
            boolean find=false;
            st = new StringTokenizer(br.readLine());
            int startx = Integer.parseInt(st.nextToken());
            int starty = Integer.parseInt(st.nextToken());
            map[0] = new Point(startx, starty);
            for (int i = 0; i < size; i++) {
                st = new StringTokenizer(br.readLine());
                int tempx = Integer.parseInt(st.nextToken());
                int tempy = Integer.parseInt(st.nextToken());
                map[1 + i] = new Point(tempx, tempy);

            }
            st = new StringTokenizer(br.readLine());
            int endx = Integer.parseInt(st.nextToken());
            int endy = Integer.parseInt(st.nextToken());
            map[size + 1] = new Point(endx, endy);
            for (int a = 0; a < size + 1; a++) {
                Point p = map[a];
                int x = p.x;
                int y = p.y;
                for (int b = a + 1; b < size + 2; b++) {
                    Point pp = map[b];
                    int xx = pp.x;
                    int yy = pp.y;
                    if (Math.abs(x - xx) + Math.abs(y - yy) <= 1000) {
                        con[a][b] = true;
                        con[b][a] = true;

                    }

                }
            }
            Queue<Integer> q = new LinkedList<>();
            q.add(0);
            while (!q.isEmpty()) {
                int qsize = q.size();
                for (int k = 0; k < qsize; k++) {
                    int current = q.poll();
                    if (current == size + 1) {
                        find=true;
                        break;
                    }
                    for (int index = 0; index < size + 2; index++) {
                        if (con[current][index] && !isChecked[index]) {
                            isChecked[index]=true;
                            q.add(index);
                        }
                    }
                }
                if(find){
                    break;
                }
            }
            if(find){
            System.out.println("happy");}
            else System.out.println("sad");

        }

    }
}