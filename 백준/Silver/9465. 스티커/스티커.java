

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;





public class Main {
	
	public static void main(String[] args) throws IOException {
			
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	int test=Integer.parseInt(br.readLine());
	for(int i=0;i<test;i++) {
		int size=Integer.parseInt(br.readLine());
		int[][] arr=new int[2][size+1];
		int[][]  dp=new int[2][size+1];
		for(int j=0;j<2;j++) {
			int index=1;
			StringTokenizer stringTokenizer=new StringTokenizer(br.readLine());
			while(stringTokenizer.hasMoreTokens()) {
				arr[j][index++]=Integer.parseInt(stringTokenizer.nextToken());
			}
			
		}
		dp[0][1]=arr[0][1];
		dp[1][1]=arr[1][1];
		if(size>1) {
		dp[0][2]=dp[1][1]+arr[0][2];
		dp[1][2]=dp[0][1]+arr[1][2];}
		for(int k=1;k<size;k++) {
			dp[0][k+1]=Math.max(dp[1][k], dp[1][k-1])+arr[0][k+1];
			dp[1][k+1]=Math.max(dp[0][k], dp[0][k-1])+arr[1][k+1];
		}
		System.out.println(Math.max(dp[0][size], dp[1][size]));
		
		
	}
	
	
	}
}
