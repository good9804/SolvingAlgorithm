
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;


class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node rootNode = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            String number=br.readLine();
            if(number==null|| number.equals("")){break;}
            else{rootNode.insert(Integer.parseInt(number));}
        }
        postOrder(rootNode);
        System.out.print(sb);
    }

    static void postOrder(Node N) {
        if (N.left != null) {
            postOrder(N.left);
        }
        if (N.right != null) {
            postOrder(N.right);
        }
        sb.append(N.num+"\n");
    }


}


class Node {
    int num;
    Node left;
    Node right;

    public Node(int num) {
        this.num = num;
    }

    public Node(int num, Node left, Node right) {
        this.num = num;
        this.left = left;
        this.right = right;
    }

    void insert(int num) {
        if(num<this.num){
        if (this.left == null) {
            this.left = new Node(num);
        } else {
            this.left.insert(num);
        }
        }
        else{
            if (this.right == null) {
            this.right = new Node(num);
        } else {
            this.right.insert(num);
        }}
    }

}










