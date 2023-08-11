class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA=arrayA[0];
        int gcdB=arrayB[0];
        for(int i=0;i<arrayA.length;i++){
            gcdA=gcd(gcdA,arrayA[i]);
            gcdB=gcd(gcdB,arrayB[i]);
        }
        if(gcdA==1&&gcdB==1){
            return 0;
        }
        if(gcdB!=1&&check(arrayA,gcdB)){
            answer=Math.max(gcdB,answer);
        }
        if(gcdA!=1&&check(arrayB,gcdA)){
            answer=Math.max(gcdA,answer);
            
        }
        return answer;
    }
    static boolean check(int[] array,int a){
        for(int cur:array){
            if(cur%a==0){
                return false;
            }
        }
        return true;
    }
    static int gcd(int a,int b){
        if(b==0) {return a;}
        else {return gcd(b,a%b);}
    }
}