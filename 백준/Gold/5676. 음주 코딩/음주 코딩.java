

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

	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input;
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null) {
        	 st = new StringTokenizer(input);
			size=Integer.parseInt(st.nextToken());
			
			int line=Integer.parseInt(st.nextToken());
			logn=0;
			for(int i=1;i<size;i*=2) {
				logn++;
			}
			node=new long[(int)Math.pow(2, logn+1)];
			Arrays.fill(node, 1);
			first=node.length/2;
			int k=0;
			st=new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int temp=Integer.parseInt(st.nextToken());
				if(temp>0) {node[first+k]=1;}
				else if(temp==0) {node[first+k]=0;}
				else {node[first+k]=-1;}
				k++;
				
			}
			
			init(1);
			
			for(int i=0;i<line;i++) {
				st=new StringTokenizer(br.readLine());
				
				if(st.nextToken().equals("C")) {
					int changeindex=Integer.parseInt(st.nextToken());
					int temp=Integer.parseInt(st.nextToken());
					if(temp>0) {node[first-1+changeindex]=1;}
					else if(temp==0) {node[first-1+changeindex]=0;}
					else {node[first-1+changeindex]=-1;}
					updatetree(first-1+changeindex);
					
					
				}
				else {
					int start=first-1+Integer.parseInt(st.nextToken());
					int end=first-1+Integer.parseInt(st.nextToken());
					long answer=find(start, end);
					if(answer>0) {sb.append("+");}
					else if(answer==0){sb.append(0);}
					else sb.append("-");
				}
			}
			sb.append("\n");
		
			
			
			
			
			
			
			
			
			
		}
		
		System.out.println(sb);
		
		
		
		
		
		
	}
	static long find(int start,int end) {
		long result=1;
		while(end>=start) {
			if(start==end) {
				result*=node[start];
				return result;
			}
			if(start%2==1) {
				result*=node[start++];
				
			}
			if(end%2==0) {
				result*=node[end--];
				
			}
			start/=2;
			end/=2;
		}
		return result;
	}
	static long init(int index) {
		if(index>=first/2) {
			return node[index]=node[index*2]*node[index*2+1];
		}
		return node[index]=init(index*2)*init(index*2+1);
	}
	static void updatetree(int index) {
		int temp=index/2;
		while(temp!=0) {
			node[temp]=node[temp*2]*node[temp*2+1];
			temp/=2;
			
		}
	}
}