import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        //n명의사람 끝말잇기
        //이전에 등장햇던단어는 쓰면안됨 ,한글자단어쓰면안됨
        //가장먼저 탈락하는사람의번호와 몇번째탈ㄹ락하는지 리턴
        int num=0;
        char prevWord=words[0].charAt(words[0].length()-1);
        HashSet<String> set=new HashSet<>();
        set.add(words[0]);
        int[] answer=new int[2];
      
        for(int i=1;i<words.length;i++){
            num++;
            num%=n;
            if(words[i].charAt(0)==prevWord&&!set.contains(words[i])){
                prevWord=words[i].charAt(words[i].length()-1);
                set.add(words[i]);
            }
            else{
                answer[0]=(num+1);
                answer[1]=(i/n)+1;
                break;
            }
            
            
            
        }
        return answer;
        
    }
}