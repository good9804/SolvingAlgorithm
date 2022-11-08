import java.util.Stack;

public class Solution {
    public static int solution(int[] ingredient) {
                int answer=0;
                Stack<Integer> all=new Stack<>();
                Stack<Integer> result=new Stack<>();
                Stack<Integer> tem=new Stack<>();
                result.push(1);
                result.push(2);
                result.push(3);
                result.push(1);
                for(int i=0;i<ingredient.length;i++)        {
                    all.push(ingredient[i]);
                    if(all.size()>=4){
                        tem.push(all.elementAt(all.size()-4));
                        tem.push(all.elementAt(all.size()-3));
                        tem.push(all.elementAt(all.size()-2));
                        tem.push(all.elementAt(all.size()-1));
                    }
                    if(tem.equals(result)){
                        all.remove(all.size()-1);
                        all.remove(all.size()-1);
                        all.remove(all.size()-1);
                        all.remove(all.size()-1);
                        answer++;
                    }
                    tem.clear();
                }
                return answer;
            }
        }