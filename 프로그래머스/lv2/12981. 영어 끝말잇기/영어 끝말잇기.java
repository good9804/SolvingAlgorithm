import java.util.Arrays;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        String [] currentList= new String[words.length];
        char lastWord= words[0].charAt(words[0].length()-1);
        currentList[0]=words[0];
        for(int i=1;i<words.length;i++){
            if((words[i].charAt(0)!=lastWord)||Arrays.asList(currentList).contains(words[i])){
                answer[0]=(i%n)+1;
                answer[1]=i/n+1;
                break;
            } lastWord= words[i].charAt(words[i].length()-1);
            currentList[i]=words[i];
            
            
        }

        return answer;
    }
}