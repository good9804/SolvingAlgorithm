
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    static int V;
    static int E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder(br.readLine());
        int order = Integer.parseInt(br.readLine());
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        int loop = str.length();
        for(int i=0;i<loop;i++){
            left.push(str.charAt(i));
        }
        while(order-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String ord = st.nextToken();

            if(ord.equals("P")){

                left.push(st.nextToken().charAt(0));
            }//왼쪽에추가
            else if(ord.equals("L")){
                if(!left.isEmpty()){
                    right.push(left.pop());
                }
            }//커서왼쪽
            else if(ord.equals("D")){
                if(!right.isEmpty()){
                    left.push(right.pop());
                }
            }//커서오른쪽
            else{
                if(!left.isEmpty()){
                    left.pop();
                }
            }//왼쪽문자삭제
        }
        str.setLength(0);
        while (!left.isEmpty()){
            str.append(left.pop());
        }
        str=str.reverse();
        while (!right.isEmpty()){
            str.append(right.pop());
        }
        System.out.println(str);

        }
    }
