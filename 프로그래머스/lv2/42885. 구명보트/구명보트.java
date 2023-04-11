import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        
        int left=0;
        int right=people.length-1;
        Arrays.sort(people);
        int answer=0;
        while(left<=right){
            int sum=0;
            if(people[left]+people[right]>limit){
                right--;
                answer++;
            }else{
                
                right--;
                left++;
                answer++;
            }
        }
        return answer;
    }
}