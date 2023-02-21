

import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

import java.util.List;



class Main {
	static int size;
	static int[] arr;
	static int[] tree;
	static int logn;
	static int first;
	static long max;
    public static void main(String[] args) throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	size=Integer.parseInt(br.readLine());
    	logn=0;
    	for(int i=1;i<size;i*=2) {
    		logn++;
    	}
    	arr=new int[size+1];
    	tree=new int[(int)Math.pow(2, logn+1)];
    	first=tree.length/2;
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	for(int i=1;i<=size;i++) {
    		arr[i]=Integer.parseInt(st.nextToken());
    		tree[first+i-1]=i;
    	}
    	int line=Integer.parseInt(br.readLine());
    	StringBuilder sb=new StringBuilder();
    	arr[0]=Integer.MAX_VALUE;
    	init(1);
    	for(int i=0;i<line;i++) {
    		st=new StringTokenizer(br.readLine());
    		int choice=Integer.parseInt(st.nextToken());
    		if(choice==1) {
    			int index=Integer.parseInt(st.nextToken());
    			int num=Integer.parseInt(st.nextToken());
    			arr[index]=num;
    			update(first+index-1);
    		}
    		else {
    			sb.append(tree[1]).append("\n");
    		}
    		
    	}
    	System.out.println(sb);
    	
    }
    static void update(int index) {
    	int temp=index/2;
    	while(temp!=0) {
    		if(arr[tree[temp*2]]<=arr[tree[temp*2+1]]) {
    			tree[temp]=tree[temp*2];
    		}else tree[temp]=tree[temp*2+1];
    		temp/=2;
    	}
    	
    	
    }
    static int init(int index) {
    	if(index>=first/2) {
    		if(arr[tree[index*2]]<=arr[tree[index*2+1]]) {
    			return tree[index]=tree[index*2];
    		}else return tree[index]=tree[index*2+1];
    		
    	}
    	if(arr[init(index*2)]<=arr[init(index*2+1)]) {
    		return tree[index]=tree[index*2];
    	}else return tree[index]=tree[index*2+1];
    	
    	
    }
    }






