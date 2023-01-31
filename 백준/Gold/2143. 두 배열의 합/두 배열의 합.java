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
        long answer = Long.parseLong(br.readLine());
        int Asize = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();
        long[] A = new long[Asize];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<Asize;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        int Bsize = Integer.parseInt(br.readLine());
        long[] B=new long[Bsize];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<Bsize;i++){
            B[i] = Integer.parseInt(st.nextToken());
        }
        long result=0;
        List<Long> Asum = new ArrayList<>();
        List<Long> Bsum = new ArrayList<>();
        for(int i=0;i<Asize;i++){
            long sum=0;
            for(int j=i;j<Asize;j++){
             sum+=A[j];
             Asum.add(sum);
            }
        }
        for(int i=0;i<Bsize;i++){
            long sum=0;
            for(int j=i;j<Bsize;j++){
                sum+=B[j];
                Bsum.add(sum);

            }
        }
        Collections.sort(Asum);
        Collections.sort(Bsum);

        for(int i=0;i<Asum.size();i++){
            long temp=Asum.get(i);
            if(map.containsKey(temp)){
                map.put(temp, map.get(temp)+1);
            }else {
                map.put(temp,1);
            }
        }
        for(int i=0;i<Bsum.size();i++){
            long temp= Bsum.get(i);
            if(map.containsKey(answer-temp)) {
                 result+= map.get(answer-temp);
            }
        }

        System.out.println(result);
    }
}





