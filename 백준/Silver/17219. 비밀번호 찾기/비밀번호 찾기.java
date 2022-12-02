
import java.util.*;
import java.lang.*;
import java.io.*;
import java.awt.*;
class Main{
    static HashMap<String,String> info=new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();
        int list=Integer.parseInt(st.nextToken());
        int find=Integer.parseInt(st.nextToken());
        for(int i=0;i<list;i++){
            st = new StringTokenizer(br.readLine());
            String id= st.nextToken();
            String pw=st.nextToken();
            info.put(id, pw);
        }
        for(int i=0;i<find;i++){
            sb.append(info.get(br.readLine()));
            if(i==find-1){
                break;
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    }