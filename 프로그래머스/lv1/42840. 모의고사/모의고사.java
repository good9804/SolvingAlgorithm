import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
            int[] answer=new int[3];
        int[] num1={1,2,3,4,5};
        int[] num2={2,1,2,3,2,4,2,5};
        int[] num3={3,3,1,1,2,2,4,4,5,5};
        for(int i=0;i<answers.length;i++){
            System.out.println(answers[i]);
            if(num1[i%num1.length]==answers[i]){
                answer[0]++;
            }
            if(num2[i%num2.length]==answers[i]){
                answer[1]++;
            }
            if(num3[i%num3.length]==answers[i]){
                answer[2]++;
            }
        }
        int min=0;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<3;i++){
            if(answer[i]==min){
                q.add(i);


            }else if(answer[i]>min){
                q.clear();
                min=answer[i];
                q.add(i);

            }
        }
        int[] a=new int[q.size()];
        int index=0;
        while(!q.isEmpty()){
            a[index++]=q.poll()+1;
        }
        
        return a;
    }
}