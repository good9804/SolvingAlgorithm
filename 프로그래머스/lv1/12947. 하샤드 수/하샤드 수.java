class Solution {
    public boolean solution(int x) {
        String str=String.valueOf(x);
        int answer=0;
        for(int i=0;i<str.length();i++){
            answer+=str.charAt(i)-'0';
        }
        
        return x%answer==0;
        
    }
}