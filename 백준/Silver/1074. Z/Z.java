import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class Main{
    static int x;
    static int y;
    static int count;
    public static void main(String[] args) throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        double size=Math.pow(2,Integer.parseInt(st.nextToken()));

        x=Integer.parseInt(st.nextToken());
        y=Integer.parseInt(st.nextToken());
        find(x,y,(int) size);
        System.out.print(count);
    }
    public static void find(int x,int y,int size){
        if(x<size/2&&y<size/2){

            if(size==2){
                return;
            }
            find(x,y,size/2);

        }else if(x<size/2&&y>=size/2){
            count+=(int) (size/2)*(size/2);

            if(size==2){
                return;
            }
            find(x,y-size/2,size/2);
        }
        else if(x>=size/2&&y<size/2){
            count+=(int) size*(size/2);

            if(size==2){
                return;
            }
            find(x-size/2,y,size/2);
        }
        else{
            count+=(int) size*size-size/2*size/2;

            if(size==2){
                return;
            }
            find(x-size/2,y-size/2,size/2);
        }
    }

}
