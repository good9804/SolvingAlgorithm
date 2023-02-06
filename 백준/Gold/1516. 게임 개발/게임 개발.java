
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.IntPredicate;


public class Main {
	static ArrayList<Integer>[] lists;
	static int[][] table;
	static int k;
	static int[] cost;
	static int size;
	static int[] dp;
	static int[] arr;
	public static void main(String[] args) throws IOException {
			
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb=new StringBuilder();
	size=Integer.parseInt(br.readLine());
	dp=new int[size+1];
	arr=new int[size+1];
	cost=new int[size+1];
	lists=new ArrayList[size+1];
	for(int i=1;i<=size;i++) {
		lists[i]=new ArrayList<Integer>();
		
	}
	
	for(int i=1;i<=size;i++) {
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		cost[i]=Integer.parseInt(st.nextToken());
		
		while(st.hasMoreTokens()) {
			int temp=Integer.parseInt(st.nextToken());
			if(temp==-1) {break;}
			lists[temp].add(i);
			dp[i]++;
		}
		
		
	}
	Queue<Integer> q=new LinkedList<Integer>();
	
	for(int i=1;i<=size;i++) {
		
		if(dp[i]==0) {
			q.add(i);
		}}
	
	while(!q.isEmpty()) {
		int current=q.poll();
		for(int i=0;i< lists[current].size();i++) {
			int temp=lists[current].get(i);
			dp[temp]--;
			arr[temp]=Math.max(arr[temp], arr[current]+cost[current]);
			if(dp[temp]==0) {
				q.add(temp);
			}
			
		}
	}
	for(int i=1;i<=size;i++) {
		sb.append(arr[i]+cost[i]).append("\n");
	}
	System.out.println(sb);
	}

}

