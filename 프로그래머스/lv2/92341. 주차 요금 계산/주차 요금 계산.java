import java.util.*;
class Solution {
    static int basicTime;
    static int basicMoney;
    static int time;
    static int money;
    public int[] solution(int[] fees, String[] records) {
        HashMap<String,Integer> allFees=new HashMap<>();
        HashMap<String,Integer> inOut=new HashMap<>();
        basicTime=fees[0];
        basicMoney=fees[1];
        time=fees[2];
        money=fees[3];
        
        for(int i=0;i<records.length;i++){
            String[] info=records[i].split(" ");
            
            if(info[2].equals("IN")){
                inOut.put(info[1],inOut.getOrDefault(info[1],changeTime(info[0])));
            }
            else{
                
                int inTime=inOut.get(info[1]);
                int outTime=changeTime(info[0]);
                if(allFees.containsKey(info[1])){
                    allFees.put(info[1],allFees.get(info[1])+outTime-inTime);
                }else{
                    allFees.put(info[1],outTime-inTime);
                }
                inOut.remove(info[1]);
            }
            
        }
        if(inOut.size()>0){
            for(String name:inOut.keySet()){
                int intime=inOut.get(name);
                int outtime=changeTime("23:59");
                if(allFees.containsKey(name)){
                    allFees.put(name,allFees.get(name)+outtime-intime);
                }else{
                    allFees.put(name,outtime-intime);
                }
            }
        }
        ArrayList<CarName> result=new ArrayList<>();
        for(String name:allFees.keySet()){
            int currentcost=allFees.get(name);
            if(currentcost<=basicTime){
                result.add(new CarName(name,basicMoney));
            }
            else{
                int curMoney=0;
                if((currentcost-basicTime)%time!=0){
                     curMoney=basicMoney+(((currentcost-basicTime)/time)+1)*money;
                 }
                else{
                    curMoney=basicMoney+(((currentcost-basicTime)/time))*money;
                }
                
                result.add(new CarName(name,curMoney));
            }
            
        }
        int[] answer = new int[result.size()];
        Collections.sort(result);
        for(int i=0;i<result.size();i++){
            answer[i]=result.get(i).cost;
        }
        
        
        return answer;
    }
    static int changeTime(String Time){
        String[] str=Time.split(":");
        return Integer.parseInt(str[0])*60+Integer.parseInt(str[1]);
    }
}
class CarName implements Comparable<CarName>{
    String name;
    int cost;
    public CarName(String name,int cost){
        this.name=name;
        this.cost=cost;
    }
    @Override
    public int compareTo(CarName c){
        return Integer.parseInt(this.name)-Integer.parseInt(c.name);
    }
}