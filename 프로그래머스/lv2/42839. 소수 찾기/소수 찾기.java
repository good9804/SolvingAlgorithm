import java.math.*;
import java.util.*;
import java.lang.*;
class Solution {
    static int answer=0;
    static boolean[] isVisted;
    static String number;
    static HashSet<String> set;
    public int solution(String numbers) {
        number=numbers;
        set=new HashSet<>();
        isVisted=new boolean[numbers.length()];
    for(int i=0;i<numbers.length();i++){
        if(numbers.charAt(i)=='0'){continue;}
        System.out.println("first"+numbers.charAt(i));
        dfs(new StringBuilder(numbers.charAt(i)));}
        return answer;
    }
    static void dfs(StringBuilder sb){
        System.out.println(sb);
        set.add(sb.toString());
        
        if(isPrime(sb.toString())){answer++;
                                  }
        for(int i=0;i<isVisted.length;i++){
            if(sb.length()==0&&number.charAt(i)=='0'){continue;}
             if(!isVisted[i]){
                 StringBuilder sbtemp=new StringBuilder(sb);
                 if(!set.contains(sbtemp.append(number.charAt(i)).toString())){
                isVisted[i]=true;
                dfs(sbtemp);
                
                isVisted[i]=false;}
            }
        }
    }
    static boolean isPrime(String num){
        if(num.length()==0){return false;}
        
        int num1=Integer.parseInt(num);
        if(num1==1){return false;}
        if(num1==2||num1==3){return true;}
        for(int i=2;i<=Math.sqrt(num1);i++){
            if(num1%i==0){return false;}
        }
        return true;
    }
}