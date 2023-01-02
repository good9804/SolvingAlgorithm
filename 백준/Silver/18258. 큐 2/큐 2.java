import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {


    public static void main(String[] args) throws IOException {
        int temp=0;
        Queue<Integer> q=new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int test = Integer.parseInt(br.readLine());
        for(int i=0;i<test;i++){
            String[] order=br.readLine().split(" ");
            if(order.length==2){
                    q.add(Integer.parseInt(order[1]));
                temp=Integer.parseInt(order[1]);

            } else{
                if(order[0].equals("front")){
                    if(!q.isEmpty()){
                        sb.append(q.peek()).append("\n");

                    }else sb.append(-1).append("\n");
                }
                else if(order[0].equals("back")){
                    if(!q.isEmpty()){
                        sb.append(temp).append("\n");
                    } else sb.append(-1).append("\n");

                }
                else if(order[0].equals("size")){
                    sb.append(q.size()).append("\n");
                }
                else if(order[0].equals("empty")){
                    if(q.isEmpty()){
                        sb.append(1).append("\n");
                    }else sb.append(0).append("\n");
                }
                else if(order[0].equals("pop")){
                    if(!q.isEmpty()){
                        sb.append(q.poll()).append("\n");

                    }else sb.append(-1).append("\n");
                }

            }

        }
        System.out.println(sb.substring(0,sb.length()));
}}