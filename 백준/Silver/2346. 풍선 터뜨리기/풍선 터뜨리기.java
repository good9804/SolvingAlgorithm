
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    static int size;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Balloon> balloons = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<size;i++){
            balloons.add(new Balloon(i+1, Integer.parseInt(st.nextToken())));//번호와 종이 넣어주기
        }

        sb.append(1+" ");
        int start=balloons.getFirst().paper;//이동해야할 변수 선언
        balloons.poll();//1번부터 시작이니 반영하고시작

        while (!balloons.isEmpty()) {
            if(start>=0){//양수면
                for(int i=0;i<start-1;i++){
                    balloons.add(balloons.poll());//앞에있는 풍선빼서 뒤로 넣어주기
                }

                Balloon balloon=balloons.poll();
                start=balloon.paper;//이동해야할 변수값 변경
                sb.append(balloon.index+" ");//인덱스 정답으로 추가
            }
            else{
                for(int i=0;i<-1*(start+1);i++){
                    balloons.addFirst(balloons.pollLast());//음수일 경우 뒤에있는애를빼서 앞으로 넣어주기
                }


                Balloon balloon=balloons.pollLast();//그다음으로 와야할 풍선이 정답이므로 맨 뒤에서 가져오기
                start=balloon.paper;
                sb.append(balloon.index+" ");
            }
        }
        System.out.println(sb);




    }
}
class Balloon{//인덱스와 종이를 담는 클래스
    int index;
    int paper;

    public Balloon(int index, int paper) {
        this.index = index;
        this.paper = paper;
    }
}
