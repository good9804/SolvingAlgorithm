class Solution {
    public int solution(int n) {
        String temp=Integer.toBinaryString(n);
        int copyN=n;
        while(true){ 
            ++copyN;
        if(Integer.bitCount(copyN)==Integer.bitCount(n))
        {
        break;    
        }}
        
        return copyN;
    }
}