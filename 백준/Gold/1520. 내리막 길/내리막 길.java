import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;




class Point{
	int x;
	int y;
	public Point(int x,int y) {
		this.x=x;
		this.y=y;
		
	}
}


public class Main {
	static int row;
	static int col;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {-0,0,-1,1};
	static int[][] pan;
	static int[][] dp;
	static int sum;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		row=Integer.parseInt(st.nextToken());
		col=Integer.parseInt(st.nextToken());
		pan=new int[row][col];
		dp=new int[row][col];
		for(int i=0;i<row;i++) {
			st=new StringTokenizer(br.readLine());
			Arrays.fill(dp[i], -1);
			for(int j=0;j<col;j++) {
				pan[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		sum=0;
		dfs(new Point(0, 0));
		System.out.println(dp[0][0]);
		
		
		
	
	
	}
	static int dfs(Point p) {
		int x=p.x;
		int y=p.y;
		if(x==row-1&&y==col-1) {
			return 1;
		}
		if(dp[x][y]!=-1) {
			return dp[x][y];
		}
		dp[x][y]=0;
		for(int i=0;i<4;i++) {
			int xtemp=x+dx[i];
			int ytemp=y+dy[i];
			
			if(isRange(xtemp, ytemp)&&pan[xtemp][ytemp]<pan[x][y]) {
				dp[x][y]+=dfs(new Point(xtemp, ytemp));
			}
		}
		int k=0;
		return dp[x][y];
		
	}
	static boolean isRange(int x,int y) {
		return x>=0&&x<=row-1&&y>=0&&y<=col-1;
	}
}