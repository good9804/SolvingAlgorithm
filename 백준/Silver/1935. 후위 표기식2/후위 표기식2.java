

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.StringTokenizer;

class Main{
    static int size;//피연산자의개수

    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        String str = br.readLine();//식 입력받기
        double[] num=new double[26];//피연산자 값을 담을 배열 선언(26)
        for(int i=0;i<str.length();i++){
            if((str.charAt(i)-'A')>=0&&(str.charAt(i)-'A')<=25&&num[str.charAt(i)-'A']==0){//대응하는 값으로 초기화가 안된 알파벳일때
                num[str.charAt(i) - 'A'] = Double.parseDouble(br.readLine());//각각 알파벳을 배열주소로 매핑
            }
        }
        Stack<Double> stack = new Stack<>();
        double answer=0;
        int i=0;
        boolean continuenum=false;
        while(i<str.length()){

            if((str.charAt(i)-'A')>=0&&(str.charAt(i)-'A'<=25)){
                stack.add(num[str.charAt(i)-'A']);}//알파벳이면 배열주소와 매핑하여 스택에 추가
            else{
                if (!stack.isEmpty()) {
                    double right=stack.pop();//제일먼저 뽑히는 숫자가 right
                    double left=stack.pop();
                    stack.add(calculate(left,right,str.charAt(i)));//계산
                }
            }

            i++;
        }
        System.out.printf("%.2f", stack.pop());//소수둘째자리까지


    }
    static double calculate(double left,double right,char operator){
        if(operator=='*'){
            return left*right;
        }
        else if(operator=='-'){
            return left-right;
        }
        else if(operator=='+'){
            return left+right;
        }
        else if(operator=='/'){
            return left/right;
        }else return left%right;
    }
}
