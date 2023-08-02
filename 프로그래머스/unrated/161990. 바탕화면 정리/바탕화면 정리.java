import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
        int row=wallpaper.length;
        int minrow=Integer.MAX_VALUE;
        int mincol=Integer.MAX_VALUE;
        int maxrow=Integer.MIN_VALUE;
        int maxcol=Integer.MIN_VALUE;
        int col=wallpaper[0].length();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(wallpaper[i].charAt(j)=='#'){
                    minrow=Math.min(i,minrow);
                    mincol=Math.min(j,mincol);
                    maxrow=Math.max(i,maxrow);
                    maxcol=Math.max(j,maxcol);
                }
                
            }
        }
        int[] answer={minrow,mincol,maxrow+1,maxcol+1};
        return answer;
    }
}