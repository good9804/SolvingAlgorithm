
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
	static ArrayList<node>[] lists;
	
	
	static int size;
	
	static int[] arr;
	public static void main(String[] args) throws IOException {
			
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st=new StringTokenizer(br.readLine());
	size= Integer.parseInt(st.nextToken());
	int line=Integer.parseInt(st.nextToken());
	int start=Integer.parseInt(br.readLine());
	lists=new ArrayList[size+1];
	arr=new int[size+1];
	for(int i=1;i<=size;i++) {
		lists[i]=new ArrayList<node>();
		arr[i]=Integer.MAX_VALUE;
	}
	
	for(int i=0;i<line;i++) {
		st=new StringTokenizer(br.readLine());
		int first=Integer.parseInt(st.nextToken());
		int end=Integer.parseInt(st.nextToken());
		int cost=Integer.parseInt(st.nextToken());
		lists[first].add(new node(end, cost));
	}
	PriorityQueue<node> queue=new PriorityQueue<node>();
	arr[start]=0;
	queue.add(new node(start, 0));
	while(!queue.isEmpty()) {
		node node=queue.poll();
		if(node.cost>arr[node.end]) {continue;}
		for(node next:lists[node.end]) {
			if(arr[next.end]>arr[node.end]+next.cost) {
				arr[next.end]=arr[node.end]+next.cost;
				queue.add(new node(next.end,arr[next.end]));
			}
		}
	}
	
	StringBuilder sb=new StringBuilder();
	
	for(int i=1;i<=size;i++) {
		if(i==start) {
			sb.append(0).append("\n");
			continue;
		}
		if(arr[i]==Integer.MAX_VALUE) {sb.append("INF").append("\n");
		continue;}
		sb.append(arr[i]).append("\n");
	}
	System.out.println(sb);
	}

}
class node implements Comparable<node>{
	
	int end;
	int cost;
	public node(int end,int cost) {
		
		this.end=end;
		this.cost=cost;
	}
	
	@Override
	public int compareTo(node n) {
		return Integer.compare(this.cost, n.cost);
	}
}

