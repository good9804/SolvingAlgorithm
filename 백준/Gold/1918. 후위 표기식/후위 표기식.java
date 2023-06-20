

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();//식 입력받기
        Stack<Character> operandStack = new Stack<>();//피연산자 스택
        Stack<Character> operatorStack = new Stack<>();//연산자 스택
        StringBuilder sb = new StringBuilder();//답을 담을 문장
        int Bracket=0;
        for(int i=0;i<str.length();i++){
            Character c=str.charAt(i);
            if ('A' <= c && 'Z' >= c) {
                sb.append(c);
            }else{
                if(c=='('){
                    operatorStack.push(c);
                    Bracket++;
                }
                else if(c==')'){
                    while(true){
                        Character operator=operatorStack.pop();
                        if(operator=='('){

                            Bracket--;
                            break;
                        }
                        if(operator!='('&&operator!=')'){
                        sb.append(operator);}

                    }
                }//AB+CD*+EF*-
                else if(c=='+'||c=='-'){
                    if(operatorStack.isEmpty()){
                        operatorStack.push(c);
                        continue;}
                    if(Bracket>0){
                        while (true){
                            if (operatorStack.peek()=='('){
                                break;
                            }
                            sb.append(operatorStack.pop());
                        }
                        operatorStack.push(c);
                    }else if(operatorStack.peek()=='*'||operatorStack.peek()=='/'){
                        while(!operatorStack.isEmpty()){
                            sb.append(operatorStack.pop());
                        }
                        operatorStack.push(c);
                    }else if(operatorStack.peek()=='-'||operatorStack.peek()=='+'){
                        sb.append(operatorStack.pop());

                        operatorStack.push(c);

                    }else{
                        operatorStack.push(c);
                    }
                }
                else{//ABC*D**E*
                    if(operatorStack.isEmpty()){
                        operatorStack.push(c);
                        continue;
                    }
                    if(operatorStack.peek()=='*'||operatorStack.peek()=='/'){

                        sb.append(operatorStack.pop());
                    }
                    //GABCD/E+*F/-*
                    operatorStack.push(c);
                }

            }
        }
        while(!operatorStack.isEmpty()){
            sb.append(operatorStack.pop());
        }
        System.out.print(sb);
    }
}

