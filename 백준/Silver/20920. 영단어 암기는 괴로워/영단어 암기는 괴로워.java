
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

class Main {
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M  = Integer.parseInt(st.nextToken());
        HashMap<String, word> map = new HashMap<>();
                ArrayList<word> list=new ArrayList<>();
        for(int i=0;i<N;i++){
            String str = br.readLine();
            if(str.length()<M){continue;}
            if(map.containsKey(str)){
                word p=map.get(str);
                p.count++;

            }
            else{
                map.put(str,new word(str));
            }

        }
       
        for(word w:map.values()){
            list.add(w);
        }
        Collections.sort(list);
        StringBuilder sb=new StringBuilder();
        for(word w:list){
            sb.append(w.str+"\n");
        }
        System.out.print(sb);
        }



}
class word implements Comparable<word>{
    String str;
    int count;
    public word(String str){
        this.str=str;
        this.count=0;
    }
    @Override
    public int compareTo(word w){
        if(this.count==w.count){
            if( w.str.length()==this.str.length()){
                return this.str.compareTo(w.str);
            }
            else return w.str.length()-this.str.length();
        }
        else{
            return w.count-this.count;
        }

    }
}




