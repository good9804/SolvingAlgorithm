import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int startIndex=n-1;
        boolean allZero=true;
        //startIndex를 결정하기위해 메소드를 작성해야함 무작정 n-1X
        for(int i=n-1;i>=0;i--){
            if(deliveries[i]!=0){
                startIndex=i;
                allZero=false;
                break;
            }
            else if(pickups[i]!=0){
                startIndex=i;
                allZero=false;
                break;
            }
        }
        if(allZero){
            return 0;
        }
        while(true){
            long deliveryCap=0;
            long pickupCap=0;
            int tempIndex=0;
            int tempIndex2=0;
            for(int i=startIndex;i>=0;i--){
                if(deliveryCap+deliveries[i]<=cap){
                    deliveryCap+=deliveries[i];
                    deliveries[i]=0;
                }else{
                    long temp=deliveryCap;
                    deliveryCap+=Math.abs(cap-deliveries[i]);
                    deliveries[i]-=cap-temp;
                    tempIndex=i;
                    break;
                }
            }
            for(int i=startIndex;i>=0;i--){
                if(pickupCap+pickups[i]<=cap){
                    pickupCap+=pickups[i];
                    pickups[i]=0;
                }else{
                    long temp=pickupCap;
                    pickupCap+=Math.abs(cap-pickups[i]);
                    pickups[i]-=cap-temp;
                    tempIndex2=i;
                    break;
                }
            }
            if(deliveryCap==0&&pickupCap==0){break;}
            answer+=(startIndex+1)*2;
            startIndex=Math.max(tempIndex,tempIndex2);
            
            
        }
        return answer;
    }
}