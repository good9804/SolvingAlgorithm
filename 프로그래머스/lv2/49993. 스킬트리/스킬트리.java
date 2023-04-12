import java.lang.*;
import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<skill.length();i++){
            set.add(skill.charAt(i));
        }
        int answer=0;
        for(int i=0;i<skill_trees.length;i++){
            int index=0;
            boolean flag=false;
            for(int j=0;j<skill_trees[i].length();j++){
            if(set.contains(skill_trees[i].charAt(j))){
                if(skill.charAt(index)==skill_trees[i].charAt(j)){
                    index++;
                    continue;
                }else  {
                    flag=true;break;}
            }
                
            }
            if((index==skill.length()||index>=0)&&!flag){answer++;}
        }
        return answer;
    }
}