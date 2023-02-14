
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {
    static int[] minnode;
    static int[] maxnode;
    static int first;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int size=Integer.parseInt(st.nextToken());
        int line=Integer.parseInt(st.nextToken());
        int logn=0;
        for(int i=1;i<size;i*=2){
            logn++;
        }
       minnode=new int[(int)Math.pow(2,logn+1)];
        maxnode=new int[(int)Math.pow(2,logn+1)];
        Arrays.fill(minnode,Integer.MAX_VALUE);
       first= minnode.length/2;

        for(int i=0;i<size;i++){
            int temp=Integer.parseInt(br.readLine());
            maxnode[first+i]=temp;
            minnode[first+i]=temp;

        }
        makeminnode(1);
        makemaxnode(1);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<line;i++){
            st=new StringTokenizer(br.readLine());
            int start=first+Integer.parseInt(st.nextToken())-1;
            int end=first+Integer.parseInt(st.nextToken())-1;

            sb.append(minQuery(start,end)).append(" ").append(maxQuery(start,end)).append("\n");
        }
        System.out.println(sb);

    }
    static long maxQuery(int start, int end) {
        long result = 0;
        while (start < end) {
            if(start % 2 == 1) result = Math.max(result, maxnode[start]);
            if(end % 2 == 0) result = Math.max(result, maxnode[end]);
            start = (start+1)/2;
            end = (end-1)/2;
        }
        if(start == end) result = Math.max(result, maxnode[start]);
        return result;
    }

    private static long minQuery(int start, int end) {
        long result = Long.MAX_VALUE;
        while (start < end) {
            if(start % 2 == 1) result = Math.min(result, minnode[start]);
            if(end % 2 == 0) result = Math.min(result, minnode[end]);
            start = (start+1)/2;
            end = (end-1)/2;
        }
        if(start == end) result = Math.min(result, minnode[start]);
        return result;
    }

    static int makeminnode(int i){
        if(i>=first){return minnode[i];}
        return minnode[i]=Math.min(makeminnode(i*2),makeminnode(i*2+1));
    }
    static int makemaxnode(int i){
        if(i>=first){return maxnode[i];}
        return maxnode[i]=Math.max(makemaxnode(i*2),makemaxnode(i*2+1));
    }}






