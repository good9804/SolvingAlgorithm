import java.util.*;
class Solution {
    public int solution(String dartResult) {
        System.out.println(dartResult.charAt(0));
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<dartResult.length();i++){
            if(dartResult.charAt(i)>='0'&&dartResult.charAt(i)<='9'){
                if(i!=0&&dartResult.charAt(i-1)=='1'){
                    stack.pop();
                    stack.push(10);
                    continue;
                }
                stack.push(dartResult.charAt(i)-'0');
            }else if(dartResult.charAt(i)>='A'&&dartResult.charAt(i)<='Z'){
                if(dartResult.charAt(i)=='S'){
                    stack.push(stack.pop());
                    continue;}
                if(dartResult.charAt(i)=='D'){
                    stack.push((int)Math.pow(stack.pop(),2));
                    continue;}
                if(dartResult.charAt(i)=='T'){
                    stack.push((int)Math.pow(stack.pop(),3));
                    continue;}
            }
            else{
                if(dartResult.charAt(i)=='*'){
                    if(stack.size()==1){
                        stack.push(stack.pop()*2);
                    }else{
                        int num1=stack.pop();
                        int num2=stack.pop();
                        stack.push(num2*2);
                        stack.push(num1*2);
                    }
                }else{
                    stack.push(stack.pop()*-1);
                }
            }
            
        }
        int answer = 0;
        while(!stack.isEmpty()){
            answer+=stack.pop();
        }
        
        return answer;
    }
}