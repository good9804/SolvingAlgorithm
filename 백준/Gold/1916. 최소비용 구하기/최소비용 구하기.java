


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
import java.util.StringTokenizer;





public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int size=Integer.parseInt(br.readLine());
		int line=Integer.parseInt(br.readLine());
		ArrayList<Node>[] lists=new ArrayList[size+1];
		for(int i=1;i<=size;i++) {
			lists[i]=new ArrayList<Node>();
		}
		for(int i=1;i<=line;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int first=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			int cost=Integer.parseInt(st.nextToken());
			lists[first].add(new Node(end, cost));
			
		}
		StringTokenizer st=new StringTokenizer(br.readLine());
		int start=Integer.parseInt(st.nextToken());
		int end=Integer.parseInt(st.nextToken());
		PriorityQueue<Node> pQueue=new PriorityQueue<Node>();
		
		pQueue.add(new Node(start, 0));
		int[] result=new int[size+1];
		Arrays.fill(result, Integer.MAX_VALUE);
		result[start]=0;
		while(!pQueue.isEmpty()) {
			Node current=pQueue.poll();
			if(current.cost>result[current.end]) {
				continue;
			}
			for(Node n:lists[current.end]) {
				if(result[n.end]>result[current.end]+n.cost) {
					result[n.end]=result[current.end]+n.cost;
					pQueue.add(new Node(n.end, result[n.end]));
				}
			}
		}
		System.out.println(result[end]);
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