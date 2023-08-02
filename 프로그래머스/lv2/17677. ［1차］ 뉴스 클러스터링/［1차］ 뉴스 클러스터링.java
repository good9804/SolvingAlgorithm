import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();
        HashSet<String> set=new HashSet<>();
        HashMap<String,Integer> str1map=new HashMap<>();
        HashMap<String,Integer> str2map=new HashMap<>();
        HashMap<String,Integer> Nmap=new HashMap<>();
        HashMap<String,Integer> Umap=new HashMap<>();
        for(int i=0;i<str1.length()-1;i++){
            String temp=str1.substring(i,i+2);
            boolean flag=true;
            for(int j=0;j<2;j++){
                if(temp.charAt(j)<'a'||temp.charAt(j)>'z'){
                    
                    flag=false;
                    break;
                }
            }
            if(!flag){
                continue;}
            str1map.put(temp,str1map.getOrDefault(temp,0)+1);
            set.add(temp);
        }
        for(int i=0;i<str2.length()-1;i++){
            String temp=str2.substring(i,i+2);
            boolean flag=true;
            for(int j=0;j<2;j++){
                if(temp.charAt(j)<'a'||temp.charAt(j)>'z'){
                    flag=false;
                    break;
                }
            }
            if(!flag){continue;}
            str2map.put(temp,str2map.getOrDefault(temp,0)+1);
            set.add(temp);
        }
        double u=0.0;
        double n=0.0;
        for(String temp:set){
            if(str1map.containsKey(temp)&&str2map.containsKey(temp)){
                u+=Math.max(str1map.get(temp),str2map.get(temp));
                n+=Math.min(str1map.get(temp),str2map.get(temp));
            }else if(str1map.containsKey(temp)){
                u+=str1map.get(temp);
            }else if(str2map.containsKey(temp)){
                u+=str2map.get(temp);
            }
        }
        
        double answer=0.0;
        if(n==0.0&&u==0.0){
            answer=1;
        }else if(n==0.0){
            answer=0;
        }
        else{
        answer= n/u;}
        
        answer*=65536;
        return (int)answer;
    }
}