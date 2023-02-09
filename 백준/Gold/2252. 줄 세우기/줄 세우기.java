
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
	static int[] arr;
	
	static ArrayList<Integer>[] map;
	public static void main(String[] args) throws IOException{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st=new StringTokenizer(br.readLine());
	int size=Integer.parseInt(st.nextToken());
	int line=Integer.parseInt(st.nextToken());
	map=new ArrayList[size+1];
	for(int i=1;i<=size;i++) {
		map[i]=new ArrayList<Integer>();
	}
	arr=new int[size+1];
	
	for(int i=0;i<line;i++) {
		
		st=new StringTokenizer(br.readLine());
		int first=Integer.parseInt(st.nextToken());
		int end=Integer.parseInt(st.nextToken());
		arr[end]++;
		map[first].add(end);
	}
	Queue<Integer> q=new LinkedList<Integer>();
	for(int i=1;i<=size;i++) {
		if(arr[i]==0) {
			q.add(i);
		}
	}
	StringBuilder sb=new StringBuilder();
	while(!q.isEmpty()) {
		int current= q.poll();
		sb.append(current).append(" ");
		
		for(int next:map[current]) {
			arr[next]--;
			if(arr[next]==0) {
				q.add(next);
			}
			
		}
	}
	
	System.out.println(sb);
	
	
	
	
	}}
