

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








public class Main {
	static int size;
	static int[][] arr;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		size=Integer.parseInt(br.readLine());
		arr=new int[size+1][3];
		dp=new int[size+1][3];
		for(int i=0;i<=size;i++) {
		Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		for(int i=1;i<=size;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
			arr[i][2]=Integer.parseInt(st.nextToken());
		}
		dfs(0, 0, 0);
		System.out.println(Math.min(dp[size][0], Math.min(dp[size][1], dp[size][2])));
	
	}
	static void dfs(int index,int sum,int color) {
		if(index==size) {
			if(dp[index][color]>sum) {
				dp[index][color]=sum;
			}
			return;
		}
		if(dp[index][color]>sum) {
			dp[index][color]=sum;
		}else return;
		if(index==0) {
			dfs(index+1, sum+arr[index+1][0], 0);
			dfs(index+1, sum+arr[index+1][1], 1);
			dfs(index+1, sum+arr[index+1][2], 2);
			return;
		}
		if(color==0) {
			dfs(index+1, sum+arr[index+1][1], 1);
			dfs(index+1, sum+arr[index+1][2], 2);
		}else if(color==1) {
			dfs(index+1, sum+arr[index+1][0], 0);
			dfs(index+1, sum+arr[index+1][2], 2);
		}
		else {
			dfs(index+1, sum+arr[index+1][0], 0);
			dfs(index+1, sum+arr[index+1][1], 1);
		}
		
		
		
		
		
		
	} }