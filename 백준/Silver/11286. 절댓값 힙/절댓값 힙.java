

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int orderCount = Integer.parseInt(br.readLine());//입력개수
        PriorityQueue<Number> numberPriorityQueue=new PriorityQueue<>();//우선순위큐
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<orderCount;i++){
            int order = Integer.parseInt(br.readLine());
            if(order==0){
                if(numberPriorityQueue.isEmpty()){//큐가 비어있다면
                    sb.append(0+"\n");
                }else{
                    sb.append(numberPriorityQueue.poll().original+"\n");

                    /*if(numberPriorityQueue.isEmpty()){
                        sb.append(number1.original+"\n");
                        continue;
                    }
                    if(numberPriorityQueue.peek().absolute==number1.absolute){
                        if(numberPriorityQueue.peek().original>=number1.original){
                            sb.append(number1.original+"\n");
                        }else{
                            sb.append(numberPriorityQueue.poll().original+"\n");
                            numberPriorityQueue.add(number1);
                        }
                    }
                    else{
                        sb.append(number1.original+"\n");
                    }*/

                }
            }
            else{
                numberPriorityQueue.add(new Number(order,Math.abs(order)));
            }
        }
        System.out.print(sb);

    }
}
class Number implements Comparable<Number>{//기존값 ,절대값을 담는 클래스 선언
    int original;
    int absolute;
    public Number(int original,int absolute){
        this.original=original;
        this.absolute=absolute;
    }

    @Override
    public int compareTo(Number number){
        if(this.absolute==number.absolute){//절대값이 같으면 기존값 기준으로 정렬
            return Integer.compare(this.original,number.original);
        }
        else return Integer.compare(this.absolute,number.absolute);
    }
}


