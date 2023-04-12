import java.util.*;
import java.lang.*;
class Solution {
    public int solution(String s) {
        
        
        
        Deque<Character> sq=new ArrayDeque<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            sq.addFirst(s.charAt(i));
                sb.append(s.charAt(i));
        }
        int x=0;
        int temp=s.length();
        int answer=0;
        while(x<temp){
            if(isRight(sb.toString())){
                answer++;
            }
            sq.addLast(sq.pollFirst());
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
            x++;
            
            
            
        }
        return answer;
    }
    static boolean isRight(String s){
        Stack<Character> stack1=new Stack<>();
        Stack<Character> stack2=new Stack<>();
        for(int i=s.length()-1;i>=0;i--){
            stack1.push(s.charAt(i));
        }
        int ssize=stack1.size();
        for(int i=0;i<ssize;i++){
            char temp=stack1.pop();
            if(temp==')'){
                if(stack2.size()>0&&stack2.peek()=='('){
                    stack2.pop();
                    continue;
                }else{ return false;}
            }
            else if(temp=='}'){
                  if(stack2.size()>0&&stack2.peek()=='{'){
                    stack2.pop();
                    continue;
                }else{ return false;}
            }
            else if(temp==']'){
                  if(stack2.size()>0&&stack2.peek()=='['){
                    stack2.pop();
                    continue;
                }else{ return false;}
            }
            else if(temp=='('){
                stack2.push(temp);
            }
            else if(temp=='{'){stack2.push(temp);}
            else{stack2.push(temp);}
        }
        if(stack2.size()>0){return false;}
            return true;
            
            
            
            
            
        }
    }
