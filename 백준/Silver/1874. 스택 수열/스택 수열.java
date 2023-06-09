
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    static int size;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int index=0;
        int num=1;
        while(true){
            if(index>=size){//원하는 정답 index까지 갔다면 정답 출력
                System.out.println(sb);
                return;
            }
            if(num>size+1){//num이 size+1를 추가하면 불가능으로 판단
                System.out.println("NO");
                return;
            }
            if(!stack.isEmpty()&&stack.peek()==arr[index]){//스택이 비어있지않고 스택 출구가 답 비교부분과 같다면 pop
                sb.append("-\n");
                index++;
                stack.pop();
            }else{
                sb.append("+\n");
                stack.push(num);
                num++;
            }
        }
    }
}
