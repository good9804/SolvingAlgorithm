
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
	static ArrayList<Integer>[] lists;
	static int[][] table;
	static int k;
	static int[] depth;
	static int size;
	
	public static void main(String[] args) throws IOException {
			
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	size=Integer.parseInt(br.readLine());
	 k=0;
	for(int i=1;i<size;i*=2) {
		k++;
	}
	depth=new int[size+1];
	table=new int[k+1][size+1];
	lists=new ArrayList[size+1];
	for(int i=1;i<=size;i++) {
		lists[i]=new ArrayList<Integer>();
	}
		StringBuilder sb=new StringBuilder();
	
	for(int i=1;i<size;i++) {
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		int first=Integer.parseInt(st.nextToken());
		int end=Integer.parseInt(st.nextToken());
		lists[first].add(end);
		lists[end].add(first);
	}
	bfs(1,0);
	maketable();
	
	int find=Integer.parseInt(br.readLine());
	
	for(int j=0;j<find;j++) {
		StringTokenizer st=new StringTokenizer(br.readLine());
		int answer=LCA(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()) );
		sb.append(answer).append("\n");
		
	}
	
	System.out.println(sb);
	}
	
	static void bfs(int root,int count) {
		Queue<Integer> queue=new LinkedList<Integer>();
		depth[root]=1;
		queue.add(root);
		while(!queue.isEmpty()) {
			int current=queue.poll();
			for(int i=0;i<lists[current].size();i++) {
				int temp=lists[current].get(i);
				if(depth[temp]==0) {
					table[0][temp]=current;
				depth[temp]=depth[current]+1;
				queue.add(temp);}
			}
		}
	}
	
	static void maketable() {
		for(int i=1;i<=k;i++) {
			for(int j=1;j<=size;j++) {
				table[i][j]=table[i-1][table[i-1][j]];
			}
			
		}
	}
	static int LCA(int a,int b) {
		if(depth [a]>depth[b]) {
			return LCA(b, a);
		}
		int answer=0;
		int temp=depth[b]-depth[a];
		
		for(int i=0;i<=k;i++) {
			if(((temp)&(1<<i))>=1) {
				b=table[i][b];
				
			}
		}
		if(a==b) {
			return b;
			
		}
		
		for(int i=k;i>=0;i--) {
			
			if(table[i][a]!=table[i][b]) {
				a=table[i][a];
				b=table[i][b];
			}
		}
		
		
		return table[0][a];
		
		
		
		
	}
	
	
	

}

