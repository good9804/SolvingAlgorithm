class Solution {
    static int answer=0;
    static int size;
    static int targetNumber;
    static int[] arr;
    public int solution(int[] numbers, int target) {
        size=numbers.length;
        targetNumber=target;
        arr=numbers;
        dfs(0,0);
        return answer;
    }
    static void dfs(int index,int current){
        if(index==size){
            if(current==targetNumber){
                answer++;
            }
            return;
        }
        dfs(index+1,current+arr[index]);
        dfs(index+1,current-arr[index]);
    }
}