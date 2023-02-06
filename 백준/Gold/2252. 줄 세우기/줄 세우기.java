
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static int[] arr;
	static int temp;
	static boolean isInclude;
	static ArrayList<Integer>[] graph;
	StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
			
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st=new StringTokenizer(br.readLine());
	StringBuilder sb=new StringBuilder();
	int size=Integer.parseInt(st.nextToken());
	boolean[] visted=new boolean[size+1];
	graph=new ArrayList[size+1];
	
	for(int i=1;i<=size;i++) {
		graph[i]=new ArrayList<Integer>();
	}
	arr=new int[size+1];
	int test=Integer.parseInt(st.nextToken());
	for(int i=0;i<test;i++) {
		
		st=new StringTokenizer(br.readLine());
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		arr[b]++;
		graph[a].add(b);
	}
	Queue<Integer> q=new LinkedList<Integer>();
	for(int i=1;i<=size;i++) {
		if(arr[i]==0) {
			q.add(i);
		}
	}
	int count=0;
	while(!q.isEmpty()) {
		int current=q.poll();
	sb.append(current).append(" ");
	
		for(int i=0;i<graph[current].size();i++) {
			if(arr[graph[current].get(i)]>0) {
				arr[graph[current].get(i)]--;
				if(arr[graph[current].get(i)]==0) {
					q.add(graph[current].get(i));
				}
			}
			
		}
	
	
	}
	System.out.print(sb);
	}
	
	
}

