import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {
    static Character[][] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        double len = Math.pow(2, size);

         tree=new Character[27][3];
        for(int i=0;i<size;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count=0;
            int temp=0;
            while (st.hasMoreTokens()){
                String node=st.nextToken();
                char node2=node.charAt(0);
                if (count == 0) {

                    temp = node.charAt(0) - 'A';
                    tree[temp][0] = node2;
                } else if (count == 1) {
                    if (node2 - 'A' == -19) {
                        tree[temp][1] = '.';
                    } else tree[temp][1] = node2;
                } else {
                    if (node2 - 'A' == -19) {
                        tree[temp][2] = '.';
                    } else tree[temp][2] = node2;
                }
                count++;
            }
        }
        pre(tree[0][0]);
        System.out.println();
        in(tree[0][0]);
        System.out.println();
        post(tree[0][0]);




    }
    public static void pre(Character node){
       if(node.equals('.')){
           return;
       }
       System.out.print(node);
       int index=node-'A';
       pre(tree[index][1]);
        pre(tree[index][2]);
    }
    public static void in(Character node){
        if(node.equals('.')){
            return;
        }

        int index=node-'A';
        in(tree[index][1]);
        System.out.print(node);
        in(tree[index][2]);

    }
    public static void post(Character node){
        if(node.equals('.')){
            return;
        }

        int index=node-'A';
        post(tree[index][1]);
        post(tree[index][2]);
        System.out.print(node);
    }
}