import java.util.*;

class Solution {
    
    public int solution(int storey) {
        //절대값이 10^c (c>=0) 정수 적힌버튼
        //현재층+버튼값 0보다 작을시 엘리베이터안움직임
        //현재층에서 최소한으로 0층이동
        String number=String.valueOf(storey);
        int[] numbers=new int[number.length()];
        for(int i=0;i<numbers.length;i++){
            numbers[i]=number.charAt(i)-'0';
       }
        int answer=0;
        for(int i=numbers.length-1;i>=0;i--){
            System.out.println(numbers[i]);
            System.out.println(answer);
            if(numbers[i]<5){
                System.out.println("미만");
                answer+=numbers[i];
            }
            else if(numbers[i]<10&&numbers[i]>5){
                answer+=10-numbers[i];
                if(i>=1){
                numbers[i-1]++;}
                if(i==0){
                        answer+=1;
                        return answer;
                    }
                
            }else if(numbers[i]==5&&i>=0){
                if(i==0){answer+=5;return answer;}
                if(numbers[i-1]<5){
                    answer+=5;
                }
                else{
                    answer+=5;
                    numbers[i-1]++;
                }
            }else{
                
                for(int j=i-1;j>=0;j--){
                    if(numbers[j]+1<10){
                        numbers[j]++;
                        break;
                    }else if(numbers[j]+1==10){
                        i--;
                        numbers[j]++;
                    }
                    if(j==0){
                            answer+=numbers[0]/10;
                            return answer;
                    }
                }
                if(i==0){
                            answer+=numbers[0]/10;
                            return answer;
                    
                }
        
            }
                
            
        }
        
        return answer;
    }
}