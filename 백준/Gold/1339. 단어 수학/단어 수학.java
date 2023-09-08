
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

class Main {
    static int N;
    static int count;
    static int[] dx={1,-1,-1,1};
    static int[] dy={1,-1,1,-1};
    static int[] arr;
    static boolean[] isChecked;
    static boolean[] isfinished;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        HashMap<Character,Integer> map=new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            String str = br.readLine();
            list.add(str);
            int temp=1;
            for(int j=str.length()-1;j>=0;j--){
                char c=str.charAt(j);
                map.put(c,map.getOrDefault(c,0)+temp);
                temp*=10;
            }
        }
        PriorityQueue<Node> pq=new PriorityQueue<>();
        for(Character c:map.keySet()){
            pq.add(new Node(c,map.get(c)));
        }
        int count=9;
        int[] value=new int[26];
        while(!pq.isEmpty()){
            value[pq.poll().c-'A']=count--;
        }
        int answer=0;
        for(String str:list){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<str.length();i++){
                sb.append(value[str.charAt(i)-'A']);
            }
            answer+=Integer.parseInt(sb.toString());
        }
        System.out.println(answer);


    }


    }
    class Node implements Comparable<Node>{
    char c;
    int num;
    public Node(char c,int num){
        this.c=c;
        this.num=num;
    }
    @Override
        public int compareTo(Node n){
        return n.num-this.num;
    }
    }




