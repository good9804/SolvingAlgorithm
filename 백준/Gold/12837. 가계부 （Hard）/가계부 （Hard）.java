

import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

import java.util.List;

class Main {
	static int size;
	static int[] arr;
	static long[] tree;
	static int logn;
	static int first;
	static long max;
    public static void main(String[] args) throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	size=Integer.parseInt(st.nextToken());
    	int line=Integer.parseInt(st.nextToken());
    	logn=0;
    	for(int i=1;i<size;i*=2) {
    		logn++;
    		
    		
    	}
    	tree=new long[(int)Math.pow(2, logn+1)];
    	first=tree.length/2;
    	StringBuilder sb=new StringBuilder();
    	for(int i=0;i<line;i++) {
    		st=new StringTokenizer(br.readLine());
    		int choice=Integer.parseInt(st.nextToken());
    		
    		if(choice==1) {
    			int index=Integer.parseInt(st.nextToken());
    			long num=Long.parseLong(st.nextToken());
    		
    			update(first+index-1, num);
    			
    		}
    		else {
    			int start=first+Integer.parseInt(st.nextToken())-1;
    			int end=first+Integer.parseInt(st.nextToken())-1;
    			long sum=find(start,end);
    			sb.append(sum).append("\n");
    		}
    		
    	}
    	System.out.println(sb);
    
    
    
    }
    static long find(int start,int end){
    	long sum=0;
    	while(end>=start) {
    		if(end==start) {
    			sum+=tree[start];
    			return sum;
    		}
    		if(start%2==1) {
    			sum+=tree[start++];
    		}
    		if(end%2==0) {
    			sum+=tree[end--];
    		}
    		start/=2;
    		end/=2;
    		
    		
    		
    		
    	}
    	return sum;
    	
    	
    }
    static void update(int index,long num) {
    	int temp=index;
    	while(temp!=0) {
    		tree[temp]+=num;
    		temp/=2;
    	}
    	
    }
    }






