import java.util.*;
class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack=new Stack<>();
        Queue<Integer> q=new LinkedList<>();
        int current=1;
        int orderIndex=0;
        int answer=0;
        while(orderIndex<order.length&&current==order[orderIndex]){
            current++;
            orderIndex++;
            answer++;
        }
        if(answer==order.length){
            return answer;
        }
        for(int j=current;j<=order[orderIndex];j++){
                stack.push(j);
                current++;
            }
        
        while(orderIndex<order.length){
            if(stack.size()>0&&stack.peek()==order[orderIndex]){
                orderIndex++;
                stack.pop();
                answer++;
            }else if(current==order[orderIndex]){
                answer++;
                current++;
                orderIndex++;
            }else if(current<order[orderIndex]){
                for(int j=current;j<=order[orderIndex];j++)                 {
                stack.push(j);
                current++;
            }
            }
            else{
                return answer;
            }
        }
        
        return answer;
    }
}