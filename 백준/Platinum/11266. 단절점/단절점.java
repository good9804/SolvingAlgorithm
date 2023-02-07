
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
	static int[] order;
	static int size;
	static boolean[] isCut;
	static int[] arr;
	static int answer;
	public static void main(String[] args) throws IOException {
			
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st=new StringTokenizer(br.readLine());
	size= Integer.parseInt(st.nextToken());
	lists=new ArrayList[size+1];
	isCut=new boolean[size+1];
	for(int i=1;i<=size;i++) {
		lists[i]=new ArrayList<Integer>();
	}
	order=new int[size+1];
	
	int line=Integer.parseInt(st.nextToken());
	
	for(int i=0;i<line;i++) {
	st=new StringTokenizer(br.readLine());
	int first=Integer.parseInt(st.nextToken());
	int end=Integer.parseInt(st.nextToken());
	lists[first].add(end);
	lists[end].add(first);
		
	}
	answer=0;
	for(int i=1;i<=size;i++) {
		if(order[i]==0) {
			dfs(i, true);
		}
	}
	
	StringBuilder sb=new StringBuilder();
	StringBuilder sb2=new StringBuilder();
	
	for(int i=1;i<=size;i++) {
		if(isCut[i]) {
			answer++;
			sb2.append(i).append(" ");
		}
	}
	sb.append(answer).append("\n").append(sb2);
	
	System.out.print(sb);
	}
	
	static int dfs(int index,boolean isFirst) {
		k++;
		order[index]=k;
		int temp=k;
		int child=0;
		for(int connect:lists[index]) {
			if(order[connect]==0) {
				child++;
				int low=dfs(connect, false);
				if(!isFirst&&low>=order[index]) {
					isCut[index]=true;
					
				}
				temp=Math.min(temp, low);
				
				
			}else temp=Math.min(temp, order[connect]);
			
			
		}
		if(isFirst&&child>=2) {
			isCut[index]=true;
			
		}
		
		return temp;
	}

}

