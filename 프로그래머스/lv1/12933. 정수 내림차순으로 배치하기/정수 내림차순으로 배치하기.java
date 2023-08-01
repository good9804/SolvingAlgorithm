import java.util.*;
class Solution {
    public long solution(long n) {
        String[] arr=Long.toString(n).split("");
        Arrays.sort(arr, Collections.reverseOrder());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]);
        }
        long answer=Long.parseLong(sb.toString());
        
        return answer;
    }
}