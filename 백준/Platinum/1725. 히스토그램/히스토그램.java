

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
    	
    	for(int i=1;i<=size;i++) {
    		arr[i]=Integer.parseInt(br.readLine());
    		tree[first+i-1]=i;
    	}
    	arr[0]=Integer.MAX_VALUE;
    	init(1);
    	max=Long.MIN_VALUE;
    	find(first, first+size-1);
    	
    	System.out.println(max);
    	
    	
    }
    static int getmin(int start,int end) {
    	int result=tree[start];
    	while(end>=start) {
    		if(start==end) {
    			if(arr[result]>arr[tree[start]]) {
    				result=tree[start];
    			}
    			else if(arr[result]==arr[tree[start]]) {
    				if(result>tree[start]) {
    					result=tree[start];
    				}
    			}
    			return result;
    		}
    		if(start%2==1) {
    			if(arr[result]>arr[tree[start]]) {
    				result=tree[start];
    			}
    			else if(arr[result]==arr[tree[start]]) {
    				if(result>tree[start]) {
    					result=tree[start];
    				}
    			}
    			start++;
    		}
    		if(end%2==0) {
    			if(arr[result]>arr[tree[end]]) {
    				result=tree[end];
    			}
    			else if(arr[result]==arr[tree[end]]) {
    				if(result>tree[end]) {
    					result=tree[end];
    				}
    			}
    			end--;
    		}
    		
    		
    		
    		
    		start/=2;
    		end/=2;
    		
    	}
    	return result;
    	
    	
    }
    static void find(int start,int end) {
    	int minindex=getmin(start, end);
    	long temp=arr[minindex]*(end-start+1);
    	if(max<temp) {
    		max=temp;
    	}
    	if(first+minindex-2>=start) {
    		find(start, first+minindex-2);
    	}
    	if(first+minindex<=end) {
    		find(first+minindex, end);
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






