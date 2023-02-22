


import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;


class Main {
	static int size;
	static long[] tree;
	static int[] count;
	static int first1;
    public static void main(String[] args) throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	size=Integer.parseInt(br.readLine());
    	int logn=0;
    	for(int i=1;i<200000;i*=2) {
    		logn++;
    	}
    	
    	tree=new long[(int)Math.pow(2, logn+1)];
    	count=new int[tree.length];
    	first1=tree.length/2;
    	long answer=1;
    	for(int i=0;i<size;i++) {
    		int num=Integer.parseInt(br.readLine());
    		if(i==0) {
    			update1(first1+num, num);
    			update2(first1+num, 1);
    			continue;
    		}
    		
    		long countsum1=countsum(first1, first1+num-1);
    		int k=count[first1];
    		long distancesum1=distancesum(first1, first1+num-1);
    		long countsum2=countsum(first1+num+1, first1+200001);
    		long distancesum2=distancesum(first1+num+1, first1+200001);
    		answer=answer*((countsum1*num-distancesum1)%1000000007+(distancesum2-countsum2*num)%1000000007);
			update1(first1+num, num);
			update2(first1+num, 1);
    		answer%=1000000007;
    		
    		
    		
    		
    	}
    	System.out.println(answer);
    	
    
    
    
    }
    static long countsum(int start,int end) {
    	long sum=0;
    	while(end>=start) {
    		if(end==start) {
    			sum+=count[start];
    			return sum;
    		}
    		if(start%2==1) {
    			sum+=count[start++];
    		}
    		if(end%2==0) {sum+=count[end--];}
    		start/=2;
    		end/=2;
    	}
    	return sum;
    }
    static long distancesum(int start,int end) {
    	long sum=0;
    	while(end>=start) {
    		if(end==start) {
    			sum+=tree[start];
    			return sum;
    		}
    		if(start%2==1) {
    			sum+=tree[start++];
    		}
    		if(end%2==0) {sum+=tree[end--];}
    		start/=2;
    		end/=2;
    	}
    	return sum;
    }
    static void update2(int index,int num) {
    	count[index]+=num;
    	int temp=index/2;
    	while(temp!=0) {
    		
    		count[temp]+=num;
    		temp/=2;
    	}
    	
    }
    static void update1(int index,int num) {
    	tree[index]+=num;
    	int temp=index/2;
    	while(temp!=0) {
    		
    		tree[temp]+=num;
    		temp/=2;
    	}
    	
    }}