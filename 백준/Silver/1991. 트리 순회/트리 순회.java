
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static StringBuilder preanswer=new StringBuilder();
    static StringBuilder inanswer=new StringBuilder();
    static StringBuilder postanswer=new StringBuilder();
    static HashMap<String,Node> nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        nodes = new HashMap<>();
        for(int i=0;i<size;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String mid = st.nextToken();
            nodes.put(mid, new Node(mid, st.nextToken(), st.nextToken()));

        }
        pre(nodes.get("A"));
        in(nodes.get("A"));
        post(nodes.get("A"));
        System.out.println(preanswer);
        System.out.println(inanswer);
        System.out.println(postanswer);


    }
    static void pre(Node N){
        preanswer.append(N.mid);
        if(!N.left.equals(".")){
            pre(nodes.get(N.left));
        }
        if(!N.right.equals(".")){
            pre(nodes.get(N.right));
        }


    }
    static void in(Node N){

        if(!N.left.equals(".")){
            in(nodes.get(N.left));
        }
        inanswer.append(N.mid);
        if(!N.right.equals(".")){
            in(nodes.get(N.right));
        }
    }
    static void post(Node N){
        if(!N.left.equals(".")){
            post(nodes.get(N.left));
        }
        if(!N.right.equals(".")){
            post(nodes.get(N.right));
        }
        postanswer.append(N.mid);
    }
}
class Node{
    String mid;
    String left;
    String right;
    public Node(String mid,String left,String right){
        this.mid=mid;
        this.left=left;
        this.right=right;
    }

}









