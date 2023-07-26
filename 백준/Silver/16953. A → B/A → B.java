
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        find(B,0);
        if(Min==Integer.MAX_VALUE){
            Min=-1;
        }
        System.out.println(Min);
    }
    static void find(int B,int count){
        if(B==A){
            Min=Math.min(Min,count+1);
            return;
        }else if(Min!=Integer.MAX_VALUE){
            return;
        }else if(B<A){return;}
        else{
            if(B%2==0){
                find(B/2,count+1);
            }
            else if(B%2==1&&B%10==1){
                find(B/10,count+1);
            }else{
                return;
            }
        }

    }
}


