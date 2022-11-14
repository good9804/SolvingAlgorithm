class Solution {
    public int solution(String s) {
        String result="";
        String temp="";
        int answer;
    for(int i=0;i<s.length();i++){
            int k=s.charAt(i)-'0';
            if(0<=k&&k<=9){
                result+=s.charAt(i);
                continue;
            }
            temp+=s.charAt(i);
                        if(temp.equals("zero")){
                    result+="0";
                    temp="";
                    continue;
                }
                 if(temp.equals("one")){
                    result+="1";
                     temp="";
                    continue;
                }
                if(temp.equals("two")){
                    result+="2";
                    temp="";
                    continue;
                }
                                if(temp.equals("three")){
                    result+="3";
                                    temp="";
                    continue;
                }
                                    if(temp.equals("four")){
                    result+="4";
                                        temp="";
                    continue;
                }
                                if(temp.equals("five")){
                    result+="5";
                                    temp="";
                    continue;
                }
                                if(temp.equals("six")){
                    result+="6";
                                    temp="";
                    continue;
                }
                                if(temp.equals("seven")){
                    result+="7";
                                    temp="";
                    continue;
                }
                                if(temp.equals("eight")){
                    result+="8";
                                    temp="";
                    continue;
                }
                                if(temp.equals("nine")){
                    result+="9";
                                    temp="";
                    continue;
                }
                }
        
        answer=Integer.parseInt(result);
        return answer;}}
        
    
