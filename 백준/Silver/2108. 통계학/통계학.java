import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int index[] = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = Integer.parseInt(br.readLine());
        }
        sb.append(sansool(index)).append("\n").append(center(index)).append("\n")
                .append(max(index)).append("\n").append(range(index)).append("\n");
        System.out.println(sb);
    }
        public static int sansool(int[] n){
        double sum=0;
        for(int i=0; i<n.length;i++){
            sum +=n[i];
        }
        if(sum>=0){
            double k=Math.round(sum/(n.length));
            int result= (int) k;
            return result;}
        else {
            double k=-Math.round(Math.abs(sum)/n.length);
            int result=-(int) k;
            return -result;}
        }
        public static int center(int[] n){
            Arrays.sort(n);
            return n[(n.length/2)];
        }
        public static int max(int[] n) {
            int standard[] = new int[8001]; //최빈값을 표현하기위한 배열생성
            int mode = 0;
            int max = -1;
            int result[] = new int[n.length];  //최빈값을 담기위한 배열
            for (int i = 0; i < n.length; i++) {
                standard[n[i] + 4000]++; //4000을 더해 넣기
            }
            for (int i = 0; i < standard.length; i++) {
                if (max <= standard[i]) {
                    if (max < standard[i] && standard[i] != 0) {
                        Arrays.fill(result, 0);
                        mode = 0;
                    }// 맥스값을 설정후 맥스값이 아예바뀌면 최빈값의결과를 담는 배열 초기화
                    max = standard[i];
                    if (max != 0) {
                        if(i-4000==0){
                            result[mode++]=-4001;//0는 정렬할때 빈배열과 헷갈리므로 -4001로설정
                        }else{
                        result[mode++] = i - 4000;}//-4000을해서 원래 값을넣어줌
                    }
                }
            }
            if (mode == 1) {
                if(result[0]==-4001){
                    return 0;
                }
                else{return result[0];}
            } else {
                int count=0;
                int present=0;
                int result2[] = new int[mode];
                for(int i=0; i< result.length;i++){
                    if(result[i]!=0){
                        if(result[i]==-4001){
                            result2[present++]=0;
                        }
                        else {result2[present++]=result[i];}
                    }
                }
                Arrays.sort(result2);
                while(true){
                if(result2[count]==result2[count+1])
                {
                    count++;
                }else return result2[count+1];}


            }
        }
        public static int range(int[] n){
        Arrays.sort(n);
        return n[n.length-1]-n[0];


        }

}