
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import java.util.*;

class Main {
    static int[] ufarr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int con=Integer.parseInt(st.nextToken());
        ufarr=new int[size];
        for(int i=0;i<size;i++){ufarr[i]=i;}
        for(int i=0;i<con;i++){
            st = new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            if(union(x,y)){
                System.out.println(i+1);
                return;
            }
        }
        System.out.println(0);
    }
    static boolean union(int a,int b){
        a=find(a);
        b=find(b);
        if(a==b){return true;}
        ufarr[b]=a;
        return false;
    }
    static int find(int x){
        if(ufarr[x]==x){
            return x;
        }else return ufarr[x]=find(ufarr[x]);
    }
}

