

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
	static ArrayList<Integer>[] smallArrayLists;
	static ArrayList<Integer>[] bigArrayLists;
	
	public static void main(String[] args) throws IOException{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st=new StringTokenizer(br.readLine());
	int size=Integer.parseInt(st.nextToken());
	int line=Integer.parseInt(st.nextToken());
	smallArrayLists=new ArrayList[size+1];
	bigArrayLists=new ArrayList[size+1];
	for(int i=1;i<=size;i++) {
		smallArrayLists[i]=new ArrayList<Integer>();
		bigArrayLists[i]=new ArrayList<Integer>();
		
	}
	for(int i=0;i<line;i++) {
		st=new StringTokenizer(br.readLine());
		int small=Integer.parseInt(st.nextToken());
		int big=Integer.parseInt(st.nextToken());
		smallArrayLists[big].add(small);
		bigArrayLists[small].add(big);
		
	}
	Queue<Integer> queue=new LinkedList<Integer>();
	int answer=0;
	for(int i=1;i<=size;i++) {
		queue.add(i);
		int count=0;
		boolean[] check=new boolean[size+1];
		check[i]=true;
	while(!queue.isEmpty()) {
	int current=queue.poll();
		for(int next:smallArrayLists[current]) {
			if(!check[next]) {
				count++;
				check[next]=true;
				queue.add(next);
			}
		}
	}
	queue.add(i);
	while(!queue.isEmpty()) {
		int current=queue.poll();
			for(int next:bigArrayLists[current]) {
				if(!check[next]) {
					count++;
					check[next]=true;
					queue.add(next);
				}
			}
		}
	if(count==size-1) {
		answer++;
	}
	
	}
	System.out.println(answer);
	
	
	
	
	
	
}
}
