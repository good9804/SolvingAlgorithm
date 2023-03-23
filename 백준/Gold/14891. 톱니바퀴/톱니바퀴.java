
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;
import java.util.regex.Pattern;

class Main {
    static int[][] wheels;
    static boolean[] checked;
    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        wheels=new int[5][9];
        checked=new boolean[5];
        for(int i=1;i<=4;i++){
            int j=1;
            for(String s:br.readLine().split("")){
                wheels[i][j++]=Integer.parseInt(s);
            }
        }

        int order=Integer.parseInt(br.readLine());
        for(int i=0;i<order;i++){
            Arrays.fill(checked,false);
            StringTokenizer st=new StringTokenizer(br.readLine());
            int wheel = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            check(wheel);
            go(wheel,direction);
        }
        int sum=0;
        for(int i=1;i<=4;i++){
            if(wheels[i][1]==1){
                sum+=Math.pow(2,i-1);
            }
        }
        System.out.println(sum);

    }
    static void check(int wheel){
        checked[wheel]=true;
        //우측
        for(int i=wheel;i<=3;i++){
            if((wheels[i][3]!=wheels[i+1][7])&&checked[i]){
                checked[i+1]=true;
            }
        }

        //좌측
        for(int i=wheel;i>=2;i--){
            if((wheels[i][7]!=wheels[i-1][3])&&checked[i]){
                checked[i-1]=true;
            }
        }
    }

    static void go(int wheel,int direction){

        int temp=wheel%2;
        for(int i=1;i<=4;i++){
            if(checked[i]){
                if(i%2==temp){
                    rotation(i,direction);
                }else rotation(i,-direction);
            }
        }
    }
    static void rotation(int wheel,int direction){
        if(direction==1){
            int temp=wheels[wheel][8];

            for(int i=8;i>=2;i--){
                wheels[wheel][i]=wheels[wheel][i-1];
            }
            wheels[wheel][1]=temp;
        }
        else{
            int temp=wheels[wheel][1];

            for(int i=1;i<=7;i++){
                wheels[wheel][i]=wheels[wheel][i+1];
            }
            wheels[wheel][8]=temp;
        }

    }


}








