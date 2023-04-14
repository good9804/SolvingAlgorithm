import java.util.*;
import java.lang.*;
class Solution {
    public String solution(int[] numbers) {
        
        PriorityQueue<Num> nums=new PriorityQueue<>();
        for(int i=0;i<numbers.length;i++){nums.add(new Num(String.valueOf(numbers[i])));}
        StringBuilder sb=new StringBuilder();
        if(nums.peek().num.equals("0")){return "0";}
        while(!nums.isEmpty()){
            sb.append(nums.poll().num);
        }
        return sb.toString();
    }
}
class Num implements Comparable{
    String num;
    public Num(String num){
        this.num=num;
    }
    @Override
    public int compareTo(Object o){
        Num n=(Num) o;
        return (Integer.parseInt(n.num+this.num)-Integer.parseInt(this.num+n.num));
    }
}