
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import java.util.*;

class Main {
    static int[] arr;
    static int answer;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size=Integer.parseInt(br.readLine());
        int[] answer=new int[size+1];
        Stack<Node> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        stack.push(new Node(1,Integer.parseInt(st.nextToken())));
        StringBuilder sb=new StringBuilder();
        sb.append(0).append(" ");
        for(int i=2;i<=size;i++){
            int currentheight=Integer.parseInt(st.nextToken());
            if(stack.peek().height<currentheight){
                while(!stack.isEmpty()){
                    Node tempnode=stack.pop();
                    if(tempnode.height<currentheight){continue;}
                    else{
                        stack.push(tempnode);
                        stack.push(new Node(i,currentheight));
                        sb.append(tempnode.index).append(" ");
                        break;}
                }
                if(stack.size()==0){
                    stack.push(new Node(i,currentheight));
                    sb.append(0).append(" ");
                }
            }else {sb.append(i-1).append(" ");
            stack.push(new Node(i,currentheight));}
        }
        System.out.println(sb);


}}
class Node{
    int index;
    int height;
    public Node(int index,int height){
        this.index=index;
        this.height=height;
    }
}

