import java.io.*;
import java.lang.*;
import java.util.*;

class Solution {
    public int solution(int[] nums)  {
        Set<Integer> set=new HashSet<>();
        
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int all=set.size();
        
        if(all>=nums.length/2){
        return nums.length/2;
            
        }else return all;
        
        
        
        
        
        
        
        
        
    }
}