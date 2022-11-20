import java.lang.String;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int count=0;
        int killzero=0;
        String str=s;
        
        while(!str.equals("1")){
            String string="";
            int k=str.length();
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)=='0'){
                    continue;
                }
                string+=str.charAt(i);
            }
            str=string;
            killzero+=k-str.length();
            str=Integer.toBinaryString(str.length());
            count++;}
        answer[0]=count;
        answer[1]=killzero;

        return answer;
    }
}