class Solution {
    static int[][] piro;
    static int[][] dx={{1,1,1},{5,1,1},{25,5,1}};
    static int min=Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        piro=new int[minerals.length/5+1][3];
        for(int i=0;i<piro.length;i++){
            if(i*5+5>minerals.length){
                for(int k=0;k<3;k++){
                int sum=0;
                
            for(int j=i*5;j<minerals.length;j++){
                if(minerals[j].equals("diamond")){
                    sum+=dx[k][0];
                }
                    else if(minerals[j].equals("iron")){
                        sum+=dx[k][1];
                    }
                        else{
                            sum+=dx[k][2];
                        }
                }
                piro[i][k]=sum;
                    System.out.println("piro "+sum);
            }
            }
            else{for(int k=0;k<3;k++){
                int sum=0;
                
            for(int j=5*i;j<i*5+5;j++){
                if(minerals[j].equals("diamond")){
                    sum+=dx[k][0];
                }
                    else if(minerals[j].equals("iron")){
                        sum+=dx[k][1];
                    }
                        else{
                            sum+=dx[k][2];
                        }
                }
                piro[i][k]=sum;
                System.out.println("piro "+sum);
            }}
            
            }
        int dsize=picks[0];
        int isize=picks[1];
        int ssize=picks[2];
        System.out.println(dsize);
        System.out.println(isize);
        System.out.println(ssize);
        System.out.println(min);
        System.out.println(piro.length);
        dfs(dsize,isize,ssize,0,0);
        
        
        
        
        
        return min;
    }
    static void dfs(int dsize,int isize,int ssize,int currentpiro,int currentlength){
        System.out.println(currentpiro);
        if(currentlength<piro.length-1){
            if(dsize>0){
            if(currentpiro+piro[currentlength][0]<min){
                dfs(dsize-1,isize,ssize,currentpiro+piro[currentlength][0],currentlength+1);
                
            }}
            if(isize>0){
            if(currentpiro+piro[currentlength][1]<min){
                dfs(dsize,isize-1,ssize,currentpiro+piro[currentlength][1],currentlength+1);
            }}
                        if(ssize>0){
            if(currentpiro+piro[currentlength][2]<min){
                dfs(dsize,isize,ssize-1,currentpiro+piro[currentlength][2],currentlength+1);
            }}
            if((dsize+ssize+isize)==0){
                min=Math.min(currentpiro,min);
            }
        }
        else if(currentlength==piro.length-1){
          System.out.println("current" +currentlength);
            
            if(dsize>0){
                System.out.println("dsizepiro"+piro[currentlength][0]);
                min=Math.min(currentpiro+piro[currentlength][0],min);
                
                System.out.println("dsize"+min);
            }
            if(isize>0){
                System.out.println("isizepiro"+piro[currentlength][1]);
                min=Math.min(currentpiro+piro[currentlength][1],min);
                
                System.out.println("isize"+min);
            }
            if(ssize>0){
                System.out.println("ssizepiro"+piro[currentlength][2]);
                min=Math.min(currentpiro+piro[currentlength][2],min);
                System.out.println("ssize"+min);
            }
            
            if((dsize+ssize+isize)==0){
                min=Math.min(currentpiro,min);
            }
        }
        
        
    }
}

