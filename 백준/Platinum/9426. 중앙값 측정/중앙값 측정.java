


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
		static int size;
		static int k;
		static int logn;
		static int[] arr;
		static int[] tree;
		static int first;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		size=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		logn=0;
		for(int i=1;i<=65535;i*=2) {
			logn++;
		}
		tree=new int[(int)Math.pow(2, logn+1)];
		arr=new int[size+1];
		first=tree.length/2;
		long sum=0;
		for(int i=1;i<=size;i++) {
			int temp=Integer.parseInt(br.readLine());
			update(first+temp,1);
			arr[i]=temp;
			if(i>=k) {
				sum+=find((k+1)/2)-first;
				update(first+arr[i-k+1],-1);
			}
			
		}
		
		System.out.println(sum);
		
		}
  static int find(int rank) {
	  int index=1;
	  while(index<first) {
	if(rank<=tree[index*2]) {
		
		index*=2;}  
	else {rank-=tree[index*2];
		index=index*2+1;
		
		}
	
	  }
	  return index;
	}
  
  
  
  




static void update(int index,int num) {
	int temp=index;
	while(temp!=0) {
		
		tree[temp]+=num;
		temp/=2;
	}
	
	
	
}
}