
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.List;


class Main{
    static int Min=Integer.MAX_VALUE;
    static int A;
    public static void main(String[] args) throws IOException {
        //1 ->M 10->MM 10^n-> n+1개의 M
        //5 ->K 50->MK 5*10^-> n개의 M+K;
        //find 최대값,최소값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        //최대값->최대한 m~~k로 자르기
        //최소-> 최대한 m은 길게 k는 따로따로 자르기
        System.out.println(findMax(sb));
        System.out.println(findMin(sb));
    }
    static String findMax(StringBuilder sb){
        StringBuilder answer = new StringBuilder();
        boolean findK=true;
        int count=0;
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='M'){
                findK=false;
                count++;
            }else if(!findK&&sb.charAt(i)=='K'){
                answer.append(5);
                for(int j=0;j<count;j++){
                    answer.append(0);
                }
                count=0;
                findK=true;
            }else if(findK&&sb.charAt(i)=='K'){
                answer.append(5);
                count=0;
                findK=true;
            }
        }
        if(count>0){
            answer.append(1);
            for(int i=1;i<count;i++){
                answer.append(1);
            }
        }
        return answer.toString();
    }
    static String findMin(StringBuilder sb){
        StringBuilder answer = new StringBuilder();
        StringTokenizer st= new StringTokenizer(sb.toString(),"K",true);
        while(st.hasMoreTokens()){
            String nextToken=st.nextToken();
            if(nextToken.contains("M")){
                answer.append(1);
                for(int i=1;i<nextToken.length();i++){
                    answer.append(0);
                }
            }else{answer.append(5);}
        }
        return answer.toString();
    }
}


