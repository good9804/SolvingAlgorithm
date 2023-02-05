

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;



public class Main {
	static int all;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder answer;
	static int count;
	static int[] result;
	static int alldol;
	static HashSet<String> set=new HashSet<String>();
	public static void main(String[] args) throws IOException {
			
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st=new StringTokenizer(br.readLine());
	
		all=Integer.parseInt(st.nextToken());
		count=Integer.parseInt(st.nextToken());
		arr=new int[all];
		result=new int[all];
		visited=new boolean[all];
		answer=new StringBuilder();
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<all;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for(int i=0;i<all;i++) {
			dfs(0, i);
		}
		System.out.println(answer);
	
	}
	
	static void dfs(int currentcount,int index) {
	if(currentcount==count) {
		StringBuilder sb=new StringBuilder();
		
		for(int k=0;k<count;k++) {
				sb.append(result[k]).append(" ");
		}
		if(!set.contains(sb.toString())) {
			set.add(sb.toString());
			answer.append(sb).append("\n");
		}
		return;
	}
	for(int i=0;i<all;i++) {
		if(!visited[i]&&arr[index]<=arr[i]) {
			visited[i]=true;
			result[currentcount]=arr[i];
			dfs(currentcount+1,  i);
			visited[i]=false;
		}
	}
	}
}
