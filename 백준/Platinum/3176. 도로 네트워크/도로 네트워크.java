
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
	static int[][] table;
	static int[][] min;
	static int[][] max;
	static int minanswer;
	static int maxanswer;
	static int[] depth;
	static ArrayList<Node>[] map;
	static int logN;

	public static void main(String[] args) throws IOException{
			
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	size=Integer.parseInt(br.readLine());
	logN=0;
	for(int i=1;i<=size;i*=2) {
		logN++;
	}
	map=new ArrayList[size+1];
	minanswer=Integer.MAX_VALUE;
	maxanswer=Integer.MIN_VALUE;
	depth=new int[size+1];
	for(int i=1;i<=size;i++) {
		map[i]=new ArrayList<Node>();
	}
	table=new int[logN+1][size+1];
	min=new int[logN+1][size+1];
	max=new int[logN+1][size+1];
	for(int i=0;i<size-1;i++) {
	StringTokenizer st=new StringTokenizer(br.readLine());
	int first=Integer.parseInt(st.nextToken());
	int end=Integer.parseInt(st.nextToken());
	int cost=Integer.parseInt(st.nextToken());
	
	map[first].add(new Node(end, cost));
	map[end].add(new Node(first, cost));
	}
	
	bfs(1);
	maketable();
	StringBuilder sb=new StringBuilder();
	int quest=Integer.parseInt(br.readLine());
	for(int i=0;i<quest;i++) {
		StringTokenizer st=new StringTokenizer(br.readLine());
		int start=Integer.parseInt(st.nextToken());
		int end=Integer.parseInt(st.nextToken());
		int parent=LCA(start,end);
		sb.append(minanswer).append(" ").append(maxanswer).append("\n");
		maxanswer=Integer.MIN_VALUE;
		minanswer=Integer.MAX_VALUE;
	}
	
		System.out.print(sb);
	}
	static int  LCA(int start,int end) {
		if(depth[start]>depth[end]) {
			return LCA(end, start);
		}
		
		int temp=depth[end]-depth[start];
		
		for(int i=0;i<=logN;i++) {
			
			if(((temp)& (1<<i))>=1) {

				minanswer=Math.min(minanswer, min[i][end]);
				maxanswer=Math.max(maxanswer, max[i][end]);
				end=table[i][end];
			}
		}
		if(start==end) {
			return start;
		}
		for(int i=logN;i>=0;i--) {
			if(table[i][start]!=table[i][end]) {
				minanswer=Math.min(minanswer, Math.min(min[i][start], min[i][end]));
				maxanswer=Math.max(maxanswer, Math.max(max[i][start], max[i][end]));
				start=table[i][start];
				end=table[i][end];
			}
		}
		
		minanswer=Math.min(minanswer,Math.min(min[0][start], min[0][end]));
		maxanswer=Math.max(maxanswer,Math.max(max[0][start], max[0][end]));
		
		return table[0][start];
		
	}
static void bfs(int start) {
	Queue<Integer> queue=new LinkedList<Integer>();
	table[0][start]=0;
	depth[start]=1;
	queue.add(start);
	
	while(!queue.isEmpty()) {
		int current=queue.poll();
		
		for(Node next:map[current]) {
			if(depth[next.end]==0) {
			depth[next.end]=depth[current]+1;
			table[0][next.end]=current;
			min[0][next.end]=next.cost;
			max[0][next.end]=next.cost;
			queue.add(next.end);
			
			}
		}
	}
	
	
	}
static void maketable() {
	for(int i=1;i<=logN;i++)
		for(int j=1;j<=size;j++) {
			table[i][j]=table[i-1][table[i-1][j]];
			min[i][j]=Math.min(min[i-1][j], min[i-1][table[i-1][j]]);
			max[i][j]=Math.max(max[i-1][j], max[i-1][table[i-1][j]]);
			
		}
}


}

class Node{
	int end;
	int cost;
	public Node(int end,int cost) {
		this.end=end;
		this.cost=cost;
	}
}
