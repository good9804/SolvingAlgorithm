

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
import java.util.Stack;
import java.util.StringTokenizer;







public class Main {
	static int[] arr;
	static int size;
	static int logn;
	static long[] node;
	static int first;
	static int result;
	static ArrayList<Node>[] lists;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		size=Integer.parseInt(st.nextToken());
		int line=Integer.parseInt(st.nextToken());
		
		lists=new ArrayList[size+1];
		for(int i=1;i<=size;i++) {
			
			lists[i]= new ArrayList<Node>();
		}
		for(int i=0;i<line;i++) {
			
			st=new StringTokenizer(br.readLine());
			int first=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			int cost=Integer.parseInt(st.nextToken());
			lists[first].add(new Node(end, cost));
			lists[end].add(new Node(first, cost));
		}
		
		st=new StringTokenizer(br.readLine());
		int node1=Integer.parseInt(st.nextToken());
		int node2=Integer.parseInt(st.nextToken());
		int temp1=findpath(1,node1 )+findpath(node1, node2)+findpath(node2, size);
		int temp2=findpath(1,node2 )+findpath(node2, node1)+findpath(node1, size);
		if(temp1>= 200000000 || temp2>=200000000) {
			System.out.println(-1);
		}else System.out.print(Math.min(temp1, temp2));
		
	
	
	}

	static int findpath(int start,int end) {
			
		PriorityQueue<Node> pq=new PriorityQueue<Node>();
		int[] result=new int[size+1];
		Arrays.fill(result, 200000000);
			result[start]=0;
			pq.add(new Node(start, 0));
			while(!pq.isEmpty()) {
				Node current=pq.poll();
				for(Node next:lists[current.end]) {
					if(result[next.end]>result[current.end]+next.cost) {
						result[next.end]=result[current.end]+next.cost;
						pq.add(new Node(next.end, result[next.end]));
					}
				}
				
			}
			return result[end];
	
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
	return Integer.compare(this.end, o.cost);
}
}