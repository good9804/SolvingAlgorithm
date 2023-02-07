
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static int size;
	static int[] arr;
	static StringBuilder sb;
	static ArrayList<Node>[] lists;
	static boolean[] flag;
	static int start;
	static int end;
	static boolean[][] table;
	static boolean[] visited;
	static ArrayList<Integer>[] mostshortArrayLists;
	public static void main(String[] args) throws IOException{
			
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	sb=new StringBuilder();
	while(true) {
	StringTokenizer st=new StringTokenizer(br.readLine());
	size=Integer.parseInt(st.nextToken());
	
	int line=Integer.parseInt(st.nextToken());
	
	if((size+line)==0) {
		System.out.print(sb);
		return;
	}
	st=new StringTokenizer(br.readLine());
	start=Integer.parseInt(st.nextToken());
	end=Integer.parseInt(st.nextToken());
	arr=new int[size];
	flag=new boolean[size];
	lists=new ArrayList[size];
	table=new boolean[size][size];
	visited=new boolean[size];
	mostshortArrayLists=new ArrayList[size];
	
	for(int i=0;i<size;i++) {
		lists[i]=new ArrayList<Node>();
		mostshortArrayLists[i]=new ArrayList<Integer>();
		arr[i]=Integer.MAX_VALUE;
	
	}
	arr[start]=0;
	for(int i=0;i<line;i++) {
		st=new StringTokenizer(br.readLine());
		int first=Integer.parseInt(st.nextToken());
		int end=Integer.parseInt(st.nextToken());
		int cost=Integer.parseInt(st.nextToken());
		lists[first].add(new Node(end, cost));
		
		
	}
	findshort(start,0);
	dfs(end);

	secondfind(start, 0);
	if(arr[end]==Integer.MAX_VALUE) {
		sb.append(-1).append("\n");
	} else sb.append(arr[end]).append("\n");
	}
	
	}
	
	static void dfs(int i) {
		visited[i]=true;
		for(int k:mostshortArrayLists[i]) {
			table[k][i]=true;
			if(!visited[k]) {
			dfs(k);}
		}
	}
	static void findshort(int start,int cost) {
		PriorityQueue<Node> q=new PriorityQueue<Node>();
		q.add(new Node(start, 0));
		
		while(!q.isEmpty()) {
			Node current=q.poll();
			if(current.cost>arr[current.end]) {continue;}
			for(Node next:lists[current.end]) {
				if(arr[next.end]==arr[current.end]+next.cost) {
					mostshortArrayLists[next.end].add(current.end);
				}
				if(arr[next.end]>arr[current.end]+next.cost) {
					
					arr[next.end]=arr[current.end]+next.cost;
					mostshortArrayLists[next.end].clear();
					mostshortArrayLists[next.end].add(current.end);
					q.add(new Node(next.end, arr[next.end]));
				}
				
			}
			
			
			
		}
	}
	static void secondfind(int start,int cost) {
		
		PriorityQueue<Node> q=new PriorityQueue<Node>();
		q.add(new Node(start, 0));
		Arrays.fill(arr, Integer.MAX_VALUE);
		arr[start]=0;
		while(!q.isEmpty()) {
			Node current=q.poll();
			if(current.cost>arr[current.end]) {continue;}
			for(Node next:lists[current.end]) {
				if(table[current.end][next.end]) {continue;}
				if(arr[next.end]==arr[current.end]+next.cost) {
					mostshortArrayLists[next.end].add(current.end);
				}
				if(arr[next.end]>arr[current.end]+next.cost) {
					
					arr[next.end]=arr[current.end]+next.cost;
					mostshortArrayLists[next.end].clear();
					mostshortArrayLists[next.end].add(current.end);
					q.add(new Node(next.end, arr[next.end]));
				}
				
			}
			
			
			
		}
		
	}

}
class Node implements Comparable<Node>{
	int end;
	int cost;
	public Node(int end,int cost) {
		this.end=end;
		this.cost=cost;
	}
	
	@Override
	public int compareTo(Node n) {
		return Integer.compare(this.cost, n.cost);
	}
}
