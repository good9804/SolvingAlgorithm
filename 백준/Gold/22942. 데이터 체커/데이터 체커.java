

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int circleCount = Integer.parseInt(br.readLine());//원의 개수
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        Stack<Circle> stack=new Stack<>();
        stack.add(new Circle(Integer.parseInt(stringTokenizer.nextToken()),
                Integer.parseInt(stringTokenizer.nextToken())));//첫 원 정보 넣어주기

        for(int i=1;i<circleCount;i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            int x=Integer.parseInt(stringTokenizer.nextToken());
            int radius=Integer.parseInt(stringTokenizer.nextToken());
            Iterator<Circle> iterator= stack.iterator();
            while(iterator.hasNext()){
                Circle c=iterator.next();
                int distance=Math.abs(c.x-x);
                if((distance>Math.abs(c.radius-radius)&&distance<c.radius+radius)||
                        c.radius+radius==distance||Math.abs(c.radius-radius)==distance){
                    System.out.println("NO");
                    return;
                }else continue;
            }


        }
        System.out.println("YES");
    }
}
class Circle{
    int x;
    int radius;

    public Circle(int x, int radius) {
        this.x = x;
        this.radius = radius;
    }
}

