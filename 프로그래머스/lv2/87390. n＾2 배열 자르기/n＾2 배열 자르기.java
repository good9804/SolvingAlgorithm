class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)right-(int)left+1];
            int k=0;
        for(long i=left;i<=right;i++){
            answer[(int)k++]=(int)Math.max(i/n+1,i%n+1);
        }
        
        
        return answer;
    }
}