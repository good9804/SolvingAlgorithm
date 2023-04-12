import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer=0;
        Deque<Integer> q=new ArrayDeque<>();
        int temp=n;
        while(temp!=0){
            q.addFirst(temp%k);
            temp/=k;
        }
        StringBuilder sb=new StringBuilder();
        ArrayList<Integer> a=new ArrayList<>();
        while(!q.isEmpty()){
            int tempq=q.pollFirst();
            if(tempq!=0){
                sb.append(tempq);
            }
            else
            {
            if(sb.length()==0){
                    continue;
            }else{
             if(isPrime(Long.parseLong(sb.toString()))){
                        answer++;
                 
            }
                sb.setLength(0);
           }}}
        
        if(sb.length()>0){
           if(isPrime(Long.parseLong(sb.toString()))){
                        answer++;
                    }
        }
        
        

        return answer;
    }
static boolean isPrime(long x){
    if(x==1){return false;}
    if(x==2||x==3){return true;}
    for(int i=2;i<=(int)Math.sqrt(x);i++){
        if(x%i==0){return false;}
    }
    return true;
}}
