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
	static int logN;
	static boolean[] visited;
	static int[] hap;
	static long[] diff;
	static ArrayList<Integer>[] map;
	public static void main(String[] args) throws IOException{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

	StringBuilder sb=new StringBuilder();
	while(true) {
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int size=Integer.parseInt(st.nextToken());
		int line=Integer.parseInt(st.nextToken());
		if(size+line==0) {

			
			System.out.println(sb);
			return;
		}
		hap=new int[size+1];
		diff=new long[size+1];
		for(int i=1;i<=size;i++) {
			hap[i]=i;
			diff[i]=0;
		}
		
		
		for(int i=0;i<line;i++) {
			st=new StringTokenizer(br.readLine());
			
			if(st.nextToken().equals("!")) {
				int first=Integer.parseInt(st.nextToken());
				int end=Integer.parseInt(st.nextToken());
				int cost=Integer.parseInt(st.nextToken());
				union(first, end, cost);
			}
			else {
				int first=Integer.parseInt(st.nextToken());
				int end=Integer.parseInt(st.nextToken());
				if(find(first)==find(end)) {
					long temp=diff[end]-diff[first];
					sb.append(temp).append("\n");
				}else sb.append("UNKNOWN").append("\n");
				
				
			}
			
		}
		
	}
	
	
	
	
	}
	static void union(int a,int b,int cost) {
		int roota=find(a);
		int rootb=find(b);
		
		diff[roota]=diff[b]-diff[a]-cost;
		
		
		hap[roota]=rootb;
		
		
	}
	static int find(int n) {
		if(n==hap[n]) {
			return n;
		}
		else {int index=find(hap[n]);
			diff[n]=diff[hap[n]]+diff[n];
		return hap[n]=index;
		}
		
	}
	
}
