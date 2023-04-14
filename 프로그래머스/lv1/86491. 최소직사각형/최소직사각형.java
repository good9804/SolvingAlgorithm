import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int garo=0;
        int sero=0;
        int maxgaro=0;
        int maxsero=0;
        for(int i=0;i<sizes.length;i++){
            if(sizes[i][0]>sizes[i][1]){
                garo=sizes[i][0];
                sero=sizes[i][1];
            }else{
                  garo=sizes[i][1];
                sero=sizes[i][0];
            }
            maxgaro=Math.max(garo,maxgaro);
            maxsero=Math.max(sero,maxsero);
            
        }
        
        
        return maxgaro*maxsero;
    }
}