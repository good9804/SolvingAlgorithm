import java.lang.*;
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int testCount=Integer.parseInt(br.readLine());
        for(int i=0;i<testCount;i++){
            int wearCount=Integer.parseInt(br.readLine());
            if(wearCount==0){
                System.out.println("0");continue;
            }
            HashMap<String,Integer> wear=new HashMap<>();
            ArrayList<String> allWear= new ArrayList<>();

            for(int k=0;k<wearCount;k++){
                String[] str=br.readLine().split(" ");
                if(!allWear.contains(str[0])){
                    allWear.add(str[0]);
                    wear.put(str[1],wear.getOrDefault(str[1],0)+1);
                }}
            Iterator<String> itr=wear.keySet().iterator();
            int count=1;
            while(itr.hasNext()){
                String key=itr.next();
                count*=wear.get(key)+1;
            }
            System.out.println(count-1);


        }
    }

}