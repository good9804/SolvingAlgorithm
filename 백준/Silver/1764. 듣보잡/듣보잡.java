import java.util.*;
import java.lang.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        List<String> list=new ArrayList<>();
    HashMap<String, Integer> map=new HashMap<String,Integer>();
    BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String[] arr=bf.readLine().split(" ");
        int sum=Integer.parseInt(arr[0])+Integer.parseInt(arr[1]);
        for(int i=0;i<sum;i++){
            String str=bf.readLine();
            map.put(str,map.getOrDefault(str,0)+1);
        }
        for(String key:map.keySet()){
            if(map.get(key)>=2)
            {
                list.add(key);
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int index=0;index<list.size();index++){
            System.out.println(list.get(index));
        }
        
        
        
}
}