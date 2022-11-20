import java.util.stream.Stream;
import java.util.Arrays;
import java.lang.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str=s.split(" ");
        int[] arr = Stream.of(str).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        answer=Integer.toString(arr[0])+" "+Integer.toString(arr[arr.length-1]);
        return answer;
    }
}