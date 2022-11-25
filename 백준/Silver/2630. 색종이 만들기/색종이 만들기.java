
import java.util.*;
import java.lang.*;
import java.io.*;
class Main{
    static int white=0;
    static int blue=0;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int length=Integer.parseInt(bf.readLine());
        int[][] square=new int[length][length];
        for(int i=0;i<length;i++){
            String[] side=bf.readLine().split(" ");
            square[i]=Arrays.stream(side).mapToInt(Integer::parseInt).toArray();
        }
        findPaper(square);
        System.out.println(white);
        System.out.println(blue);
    }
    public static void findPaper(int[][] square){

        if(findValue(square,1)&&!findValue(square,0)){
            blue++;
            return;
        }
        if(findValue(square,0)&&!findValue(square,1)){
            white++;
            return;
        }
       
        for(int index=0;index<2;index++){

            int half=square[0].length/2;
            for(int j=0;j<2;j++){
                int[][] squareTemp=new int[square.length/2][square.length/2];
                for(int i=0;i<square.length/2;i++){
                System.arraycopy(square[i+half*index],j*half,squareTemp[i],0,half);
                }
                findPaper(squareTemp);

            }
        }

    }
    public static boolean findValue(int[][] square,int value){
        for(int i=0;i<square.length;i++){
           if( !(Arrays.stream(square[i])
                    .allMatch(a -> a==value))){
               return false;
           }
        }
        return true;
    }
}