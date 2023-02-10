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
import java.util.function.IntPredicate;


public class Main {
	static int logN;
	static int[] dp;
	static boolean[] visited;
	static int[] node;
	static int[] node2;
	static int[][] table;
	static long[] hap;
	static ArrayList<Node>[] map;
	public static void main(String[] args) throws IOException{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st=new StringTokenizer(br.readLine());
	int size=Integer.parseInt(st.nextToken());
	int line=Integer.parseInt(st.nextToken());
	int count=Integer.parseInt(st.nextToken());
	map=new ArrayList[size+1];
	dp=new int[size+1];
	int[] visited=new int[size+1];
	for(int i=1;i<=size;i++) {
		map[i]=new ArrayList<Node>();
	}
	for(int i=0;i<line;i++) {
		st=new StringTokenizer(br.readLine());
		
		int first=Integer.parseInt(st.nextToken());
		int end=Integer.parseInt(st.nextToken());
		int cost=Integer.parseInt(st.nextToken());
		map[first].add(new Node(end, cost));
	
	}
	PriorityQueue<Node> queue=new PriorityQueue<Node>();
	queue.add(new Node(1, 0));
	dp[1]=0;
	while(!queue.isEmpty()) {
		Node node=queue.poll();;
		if(visited[node.end]==count) {
			continue;
		}
		visited[node.end]++;
		dp[node.end]=node.cost;
		for(Node next:map[node.end]) {
				if(visited[next.end]<count) {

				
				queue.add(new Node(next.end, dp[node.end]+next.cost));}
			}
			
			
		}
		
	
	StringBuilder sb=new StringBuilder();
	for(int i=1;i<=size;i++) {
		if(visited[i]==count) {
			sb.append(dp[i]).append("\n");
		}else sb.append(-1).append("\n");
	}
	sb.setLength(sb.length()-1);
	System.out.println(sb);
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
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.cost, o.cost);
	}
}

