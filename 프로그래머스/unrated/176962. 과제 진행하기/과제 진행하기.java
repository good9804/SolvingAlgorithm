import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        ArrayList<String> answer=new ArrayList<>();
        PriorityQueue<Work> pq=new PriorityQueue<>();
        for(int i=0;i<plans.length;i++){
            pq.add(new Work(plans[i][0],plans[i][1],plans[i][2]));
        }
        Stack<Work> stack=new Stack<>();
        Work currentWork=pq.poll();
        int currentTime=currentWork.startTime;
        while(true){
            int playtime=exchangeTime(currentTime,currentWork.cost);
            
            if(pq.isEmpty()){
                answer.add(currentWork.name);
                while(!stack.isEmpty()){
                    answer.add(stack.pop().name);
                    
                }
                break;
            }
            if(playtime<=
              pq.peek().startTime){//과제를 충분히 마칠수있을때
                answer.add(currentWork.name);
                if(stack.isEmpty()){
                currentWork=pq.poll();
                currentTime=currentWork.startTime;
                continue;}
                else{
                    if(playtime==pq.peek().startTime){
                        currentWork=pq.poll();
                    }
                    else {
                        
                        currentWork=stack.pop();
                    }
                }
                currentTime=playtime;
            }else{//과제하다가 도중에끝날때
                currentWork.cost-=minusTime(pq.peek().startTime,currentTime);
                
                stack.push(currentWork);
                currentWork=pq.poll();
                currentTime=currentWork.startTime;
            }
            
        }
        String[] result=new String[answer.size()];
        for(int i=0;i<result.length;i++){
            result[i]=answer.get(i);
        }
        
        return result;
    }
    static int changeTime(String time){
    String[] str=time.split(":");
    return Integer.parseInt(str[0]+str[1]);
}
    static int minusTime(int time1,int time2){
        int time1Hour=time1/100;
        int time2Hour=time2/100;
        int time1Minutes=time1%100;
        int time2Minutes=time2%100;
        return time1Hour*60+time1Minutes-time2Hour*60-time2Minutes;
    }
    static int exchangeTime(int time,int cost){
        int minutes=time%100+cost;
        return time/100*100+(minutes/60)*100+minutes%60;
}}
class Work implements Comparable<Work>{
    String name;
    int startTime;
    int cost;
    public Work(String name,String startTime, String cost){
        this.name=name;
        this.startTime=changeTime(startTime);
        this.cost=Integer.parseInt(cost);
    }
    @Override
    public int compareTo(Work w){
        return this.startTime-w.startTime;
    }
    static int changeTime(String time){
    String[] str=time.split(":");
    return Integer.parseInt(str[0]+str[1]);
}
    
}
