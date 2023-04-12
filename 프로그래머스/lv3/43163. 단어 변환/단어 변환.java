class Solution {
    static int answer=Integer.MAX_VALUE;
    static boolean[] isVisted;
    static String[] allwords;
    public int solution(String begin, String target, String[] words) {
    
        isVisted=new boolean[words.length];
        allwords=words;
        dfs(begin,target,0);
        if(answer==Integer.MAX_VALUE){answer=0;}
        return answer;
    }
    static void dfs(String current,String target,int count){
        if(current.equals(target)){
            answer=Math.min(count,answer);
            return;
        }
        for(int i=0;i<isVisted.length;i++){
            if(!isVisted[i]){
                int temp=0;
                for(int j=0;j<current.length();j++){
                    System.out.println(allwords[i]);
                    if(current.charAt(j)==allwords[i].charAt(j)){
                        temp++;
                    }
                    
                    
                }
                if(temp==current.length()-1){
                    isVisted[i]=true;
                    dfs(allwords[i],target,count+1);
                    isVisted[i]=false;
                }
            }
            
            
        }
        
    }
}