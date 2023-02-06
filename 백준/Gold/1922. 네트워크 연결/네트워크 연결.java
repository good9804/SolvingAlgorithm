
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException {
			int sum=0;
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

	StringBuilder sb=new StringBuilder();
	
	int allcom=Integer.parseInt(br.readLine());
	arr=new int[allcom+1];
	for(int i=1;i<=allcom;i++) {arr[i]=i;}
	int line=Integer.parseInt(br.readLine());
	boolean[] visited=new boolean[allcom+1];
	ArrayList<Com> list=new ArrayList<Com>();
	for(int i=1;i<=line;i++) {
		StringTokenizer st=new StringTokenizer(br.readLine());
		int first=Integer.parseInt(st.nextToken());
		int end=Integer.parseInt(st.nextToken());
		int cost=Integer.parseInt(st.nextToken());
		list.add(new Com(first, end, cost));
	}
	
	
	Collections.sort(list);
	int count=0;
	for(int i=0;i<=line;i++) {
		if(count==allcom-1) {
			System.out.println(sum);
			return;
		}
		int first=list.get(i).first;
		int end=list.get(i).end;
		if(find(first)!=find(end)) {
			union(first,end);
			sum+=list.get(i).cost;
			count++;
		} else continue;
	}
	

	}
	

	static void union(int a,int b) {
		a=find(a);
		b=find(b);
		if(a!=b) {
			if(a>b) {
				arr[a]=b;
			}else arr[b]=a;
		}
	}
	static int find(int a) {
		if(arr[a]==a) {
			return a;
		}
			
		return	arr[a]=	find(arr[a]);
			
	}
}


class Com implements Comparable<Com>{
	int first;
	int end;
	int cost;
	public Com(int first,int end,int cost) {
		this.first=first;
		this.end=end;
		this.cost=cost;
	}
	
	@Override
	public int compareTo(Com c) {
		return this.cost-c.cost;
	}
}

