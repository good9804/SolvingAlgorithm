import java.util.*;
import java.lang.*;
import java.io.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer=new ArrayList<>();
        boolean[] check=new boolean[progresses.length];
        boolean[] confirm=new boolean[progresses.length];
        Queue<program> q=new LinkedList<>();
        for(int i=0;i<progresses.length;i++){
            q.add(new program(progresses[i],speeds[i],i));
        }
        
        while(!q.isEmpty()){
            int qsize=q.size();
            for(int i=0;i<qsize;i++){
            program p=q.poll();
            p.progresse+=p.speed;
            if(p.progresse>=100){
                    check[p.index]=true;
                }
            else q.add(p);}
            int temp=0;
            for(int j=0;j<check.length;j++){
                if(check[j]&&!confirm[j]){
                    confirm[j]=true;
                    temp++;
                }else if(!check[j]&&!confirm[j]){break;}
                
            }
            if(temp!=0){
            answer.add(temp);}
            
        
        }
           
    int[] answers=new int[answer.size()];
        for(int i=0;i<answers.length;i++){
            answers[i]=answer.get(i);
        }
        return answers;
}}
class program{
    int progresse;
    int speed;
    int index;
    public program(int progresse,int speed,int index){
        this.progresse=progresse;
        this.speed=speed;
        this.index=index;
    }
}