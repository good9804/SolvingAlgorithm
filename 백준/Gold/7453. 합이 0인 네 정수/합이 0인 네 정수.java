import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size= Integer.parseInt(br.readLine());
        long[] A = new long[size];
        long[] B = new long[size];
        long[] C = new long[size];
        long[] D = new long[size];
        long AB[] = new long[size * size];
        long CD[] = new long[size * size];

        for(int i=0;i<size;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Long.parseLong(st.nextToken());
            B[i] = Long.parseLong(st.nextToken());
            C[i]=Long.parseLong(st.nextToken());
            D[i]=Long.parseLong(st.nextToken());
        }
        int index=0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                AB[index] = A[i] + B[j];
                CD[index] = C[i] + D[j];
                index++;
            }
        }
        Arrays.sort(AB);
        Arrays.sort(CD);
        long result=0;
        int ABindex=0;
        int CDindex=CD.length-1;
        while(ABindex<AB.length&&CDindex>=0){
            long ABdup=1;
            long CDdup=1;
            if(AB[ABindex]+CD[CDindex]>0){
                CDindex--;

            }else if(AB[ABindex]+CD[CDindex]<0){ABindex++;}
            else{
                while(ABindex<AB.length-1&&AB[ABindex+1]==AB[ABindex]){
                    ABindex++;
                    ABdup++;
                }
                while(CDindex>0&&CD[CDindex-1]==CD[CDindex]){
                    CDindex--;
                    CDdup++;
                }
                ABindex++;
                result+=ABdup*CDdup;
            }
        }
        System.out.print(result);
    }
}




