import java.util.*;
import java.lang.*;
import java.io.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character,Integer> mapRT=new HashMap<>();
        mapRT.put('R',0);
        mapRT.put('T',0);
        Map<Character,Integer> mapCF=new HashMap<>();
        mapCF.put('C',0);
        mapCF.put('F',0);
        Map<Character,Integer> mapJM=new HashMap<>();
        mapJM.put('J',0);
        mapJM.put('M',0);
        Map<Character,Integer> mapAN=new HashMap<>();
        mapAN.put('A',0);
        mapAN.put('N',0);
        for(int i=0;i<survey.length;i++){
            if(survey[i].contains("R")){
                if(choices[i]<4){
                    mapRT.put(survey[i].charAt(0),mapRT.get(survey[i].charAt(0))+4-choices[i]);
                }else if(choices[i]>4){
                    mapRT.put(survey[i].charAt(1),mapRT.get(survey[i].charAt(1))+choices[i]-4);
                }else{continue;}
            }else if(survey[i].contains("C")){
                if(choices[i]<4){
                    mapCF.put(survey[i].charAt(0),mapCF.get(survey[i].charAt(0))+4-choices[i]);
                }else if(choices[i]>4){
                    mapCF.put(survey[i].charAt(1),mapCF.get(survey[i].charAt(1))+choices[i]-4);
                }else{continue;}
            }else if(survey[i].contains("J")){
                if(choices[i]<4){
                    mapJM.put(survey[i].charAt(0),mapJM.get(survey[i].charAt(0))+4-choices[i]);
                }else if(choices[i]>4){
                    mapJM.put(survey[i].charAt(1),mapJM.get(survey[i].charAt(1))+choices[i]-4);
                }else{continue;}
            }else{
                if(choices[i]<4){
                    mapAN.put(survey[i].charAt(0),mapAN.get(survey[i].charAt(0))+4-choices[i]);
                }else if(choices[i]>4){
                    mapAN.put(survey[i].charAt(1),mapAN.get(survey[i].charAt(1))+choices[i]-4);
                }else{continue;}
            }
        }
        
        if(mapRT.get('R')>=mapRT.get('T')){
            answer+='R';
        }else answer+='T';
        if(mapCF.get('C')>=mapCF.get('F')){
            answer+='C';
        }else answer+='F';
        if(mapJM.get('J')>=mapJM.get('M')){
            answer+='J';
        } else answer+='M';
        if(mapAN.get('A')>=mapAN.get('N')){
            answer+='A';
        }else answer+='N';
        return answer;
    }
}