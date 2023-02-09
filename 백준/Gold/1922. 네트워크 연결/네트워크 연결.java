
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
	static boolean[] visited;
	static int[] hap;
	static ArrayList<Integer>[] map;
	public static void main(String[] args) throws IOException{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	int size=Integer.parseInt(br.readLine());
	int line=Integer.parseInt(br.readLine());
	map=new ArrayList[size+1];
	hap=new int[size+1];
	for(int i=1;i<=size;i++) {
		map[i]=new ArrayList<Integer>();
		hap[i]=i;
	}
	visited=new boolean[size+1];
	PriorityQueue<Com> q=new PriorityQueue();
	for(int i=0;i<line;i++) {
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		int first=Integer.parseInt(st.nextToken());
		int end=Integer.parseInt(st.nextToken());
		int cost=Integer.parseInt(st.nextToken());
		q.add(new Com(first, end, cost));
	}
	long sum=0;
	StringBuilder sb=new StringBuilder();
	while(!q.isEmpty()) {
		Com com= q.poll();
		if(find(com.end)==find(com.first)) {continue;}
		visited[com.first]=true;
		visited[com.end]=true;
		sum+=com.cost;
		union(com.first,com.end);
		
	}
	
	System.out.println(sum);
	
	
	
	
	}
	static void union(int a,int b) {
		a=find(a);
		b=find(b);
		hap[a]=b;
		
	}
	static int find(int index) {
		if(index==hap[index]) {return index;}
		return hap[index]=find(hap[index]);
	}
	
}
class Com implements Comparable<Com>{
	int first;
	int end;
	int cost;
	public Com(int first,int end,int cost){
		this.first=first;
		this.end=end;
		this.cost=cost;
	}
	@Override
	public int compareTo(Com c) {
		return Integer.compare(this.cost, c.cost);
	}
	
}
