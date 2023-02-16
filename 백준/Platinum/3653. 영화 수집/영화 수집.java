


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
		
	int test=Integer.parseInt(br.readLine());
	StringBuilder sb=new StringBuilder();
	for(int i=0;i<test;i++) {
		StringTokenizer st=new StringTokenizer(br.readLine());
		size=Integer.parseInt(st.nextToken());
		int movie=Integer.parseInt(st.nextToken());
		arr=new int[size+movie];
		st=new StringTokenizer(br.readLine());
		int k=1;
		logn=0;
		for(int j=1;j<size+movie;j*=2) {
			logn++;
		}
		node=new long[(int)Math.pow(2, logn+1)];
		first=(int)Math.pow(2, logn);
		for(int j=movie;j<size+movie;j++) {
			arr[k++]=j;
			node[first+j]=1;
		}

		maketree(1);
		int index=1;
		while(st.hasMoreTokens()) {
			int temp=Integer.parseInt(st.nextToken());
			result=0;
			find(first, first+arr[temp]-1);
			updatetree(first+arr[temp],-1);
			arr[temp]=movie-index++;
			updatetree(first+arr[temp],1);
			sb.append(result).append(" ");
		}
		
		
		sb.append("\n");
		
		
		
	}
	System.out.println(sb);
	
	}
	static void updatetree(int index,long num) {
		int temp=index;
		while(temp!=0) {
			node[temp]+=num;
			temp/=2;
		}
	}
	static void find(int start,int end) {
		while(start<=end) {
			if(start==end) {
				result+=node[start];
				break;
			}
			if(start%2==1) {
				result+=node[start++];
			}
			if(end%2==0) {
				result+=node[end--];
			}
			start/=2;
			end/=2;
			
		}
		
		
		
	}
	static long maketree(int index) {
		if(index>=first/2) {
			return node[index]=node[index*2]+node[index*2+1];
		}
		return node[index]=maketree(index*2)+maketree(index*2+1);
	}
	
}