
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.List;


class Main{
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        String[] colors=br.readLine().split("");

        int answer= Math.min(findAnswer("B",colors),findAnswer("R",colors));
        System.out.println(answer);
    }
    static String findMax(String[] colors){
        int bCount=0;
        int rCount=0;
        for(int i=0;i< colors.length;i++){
            if(colors[i].equals("B"))
                bCount++;
            else rCount++;
        }
        if(bCount>=rCount){
            return "B";

        }else return "R";
    }
    static int findAnswer(String maxColor,String[] colors){
        int answer=1;
        int start=0;
        boolean flag=false;
        while(start< colors.length){
            if(!colors[start].equals(maxColor)){
                flag=true;
                if(start== colors.length-1){
                    answer++;
                }
            }else{
                if(flag){
                    answer++;
                    flag=false;
                }
            }

            start++;
        }
        return answer;
    }
    }


