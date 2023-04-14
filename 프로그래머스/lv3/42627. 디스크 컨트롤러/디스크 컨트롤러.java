import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Task> tasks=new PriorityQueue<>();
        for(int i=0;i<jobs.length;i++){
         tasks.add(new Task(jobs[i][0],jobs[i][1]));
        }
        int i=0;
        int answer=0;
        while(!tasks.isEmpty()){
            if(i==0){
            Task t=tasks.poll();
        i=t.time+t.cost;
            answer+=t.cost;
                continue;
            }
            if(tasks.peek().time>=i){
                Task t2=tasks.poll();
                i=t2.time+t2.cost;
                answer+=t2.cost;
                continue;
            }
            else{
                Iterator<Task> iterator=tasks.iterator();
               int min=5000;
                Task maxTask=new Task(0,0);
                while(iterator.hasNext()){
                    Task tempTask=iterator.next();
                    if(tempTask.time<i&&tempTask.cost<min){
                        maxTask=tempTask;
                        min=maxTask.cost;
                    }else if(tempTask.time>=i){continue;};
                }
                tasks.remove(maxTask);
                answer+=i-maxTask.time+maxTask.cost;
                
                i+=maxTask.cost;
                
            }
            
            
        }
        return answer/jobs.length;
    }
}
class Task implements Comparable{
    
    int time;
    int cost;
    public Task(int time,int cost){
        this.time=time;
        this.cost=cost;
    }
    
    @Override
    public int compareTo(Object o){
        Task t=(Task) o;
        if(this.time==t.time){
            return this.cost-t.cost;
        }
        else return this.time-t.time;
    }
}