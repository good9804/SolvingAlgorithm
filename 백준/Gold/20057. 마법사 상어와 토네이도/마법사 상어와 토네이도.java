
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;
import java.util.regex.Pattern;

class Main {
    static int pan[][];
    static int size;
    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};
    static boolean[][] isChecked;
    static int answer;


    public static void main(String[] args) throws IOException {
        //A[r][c] 모래의양, 격자의 가운데 칸부터 토네이도 이동 시작
        //비율만큼 모래가 흩날림 알파로 이동하는 모래의 양은 남은 모래의양
        //모래는 누,모래가 격자밖으로 나갈수있음 격자밖으로나간 모래의양구하기
        //입력 N은홀수 N,각칸에있는 모래가주어짐 가운데있는모래의양은0
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        pan=new int[size+1][size+1];
        isChecked = new boolean[size + 1][size + 1];
        for(int i=1;i<=size;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=1;j<=size;j++){
                pan[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        answer=0;
        int row=size/2+1;
        int col=row;
        int order=row; //1 3 5 7 2 4 6 8
        for(int i=0;i<order;i++){

            if(i==order-1) {
                while(true){
                    isChecked[row][col]=true;
                    rotation1(row,col);
                    if(row==1&&col==1){
                        System.out.println(answer);
                        return;
                    }
                    col+=-1;
                }

            } else{
                int odd=2*i+1;
                int even=2*i+2;
                for(int j=0;j<2;j++){
                    for(int temp=0;temp<odd;temp++){
                        if( j==0){
                            rotation1(row,col);
                            row+=dx[j];
                            col+=dy[j];
                            isChecked[row][col]=true;
                        }
                        else{

                            rotation2(row,col);
                            row+=dx[j];
                            col+=dy[j];
                            isChecked[row][col]=true;
                        }
                    }
            }
            for(int j=2;j<4;j++){
                for(int temp=0;temp<even;temp++){
                    if( j==2){
                        rotation3(row,col);
                        row+=dx[j];
                        col+=dy[j];
                        isChecked[row][col]=true;
                    }
                    else{

                        rotation4(row,col);
                        row+=dx[j];
                        col+=dy[j];
                        isChecked[row][col]=true;
                    }
                }
            }
            }

        }






   }
   static void hap(int temprow,int tempcol,int temp){
        if(isRange(temprow,tempcol)){
        pan[temprow][tempcol]+=temp;}
        else answer+=temp;
   }
   static void rotation1(int temprow,int tempcol){
        int temp=pan[temprow][tempcol-1];
        int a=temp;
        hap(temprow-1,tempcol-1,temp*7/100);
        a-=temp*7/100;
       hap(temprow+1,tempcol-1,temp*7/100);
       a-=temp*7/100;
       hap(temprow-2,tempcol-1,temp*2/100);
       a-=temp*2/100;
       hap(temprow+2,tempcol-1,temp*2/100);
       a-=temp*2/100;

       hap(temprow-1,tempcol,temp*1/100);
       a-=temp*1/100;
       hap(temprow+1,tempcol,temp*1/100);
       a-=temp*1/100;
       hap(temprow-1,tempcol-2,temp*10/100);
       a-=temp*10/100;
       hap(temprow+1,tempcol-2,temp*10/100);
       a-=temp*10/100;
       hap(temprow,tempcol-3,temp*5/100);
       a-=temp*5/100;
       hap(temprow,tempcol-2,a);
        pan[temprow][tempcol-1]=0;
   }
    static void rotation2(int temprow,int tempcol){
        int temp=pan[temprow+1][tempcol];
        int a=temp;
        hap(temprow+1,tempcol-1,temp*7/100);
        hap(temprow+1,tempcol+1,temp*7/100);
        a-=temp*7/100;
        a-=temp*7/100;
        hap(temprow+1,tempcol+2,temp*2/100);
        hap(temprow+1,tempcol-2,temp*2/100);
        a-=temp*2/100;
        a-=temp*2/100;
        hap(temprow,tempcol-1,temp*1/100);
        hap(temprow,tempcol+1,temp*1/100);
        a-=temp*1/100;
        a-=temp*1/100;
        hap(temprow + 2, tempcol - 1, temp * 10 / 100);
        a-=temp*10/100;
        hap(temprow + 2, tempcol + 1, temp * 10 / 100);
        a-=temp*10/100;
        hap(temprow + 3, tempcol, temp * 5 / 100);
        a-=temp*5/100;
        hap(temprow+2,tempcol,a);
        pan[temprow+1][tempcol]=0;
    }
    static void rotation3(int temprow,int tempcol){
        int temp=pan[temprow][tempcol+1];
        int a=temp;
        hap(temprow-1,tempcol+1,temp*7/100);
        a-=temp*7/100;
        hap(temprow+1,tempcol+1,temp*7/100);
        a-=temp*7/100;
        hap(temprow-2,tempcol+1,temp*2/100);
        a-=temp*2/100;
        hap(temprow+2,tempcol+1,temp*2/100);
        a-=temp*2/100;

        hap(temprow-1,tempcol,temp*1/100);
        a-=temp*1/100;
        hap(temprow+1,tempcol,temp*1/100);
        a-=temp*1/100;
        hap(temprow-1,tempcol+2,temp*10/100);
        a-=temp*10/100;
        hap(temprow+1,tempcol+2,temp*10/100);
        a-=temp*10/100;
        hap(temprow,tempcol+3,temp*5/100);
        a-=temp*5/100;
        hap(temprow,tempcol+2,a);
        pan[temprow][tempcol+1]=0;

    }
    static void rotation4(int temprow,int tempcol){
        int temp=pan[temprow-1][tempcol];
        int a=temp;
        hap(temprow-1,tempcol-1,temp*7/100);
        hap(temprow-1,tempcol+1,temp*7/100);
        a-=temp*7/100;
        a-=temp*7/100;
        hap(temprow-1,tempcol+2,temp*2/100);
        hap(temprow-1,tempcol-2,temp*2/100);
        a-=temp*2/100;
        a-=temp*2/100;
        hap(temprow,tempcol-1,temp*1/100);
        hap(temprow,tempcol+1,temp*1/100);
        a-=temp*1/100;
        a-=temp*1/100;
        hap(temprow - 2, tempcol - 1, temp * 10 / 100);
        a-=temp*10/100;
        hap(temprow - 2, tempcol + 1, temp * 10 / 100);
        a-=temp*10/100;
        hap(temprow - 3, tempcol, temp * 5 / 100);
        a-=temp*5/100;
        hap(temprow-2,tempcol,a);
        pan[temprow-1][tempcol]=0;

    }
    static boolean isRange(int x,int y){
        return x>=1&&x<=size&&y>=1&&y<=size;
    }
}








