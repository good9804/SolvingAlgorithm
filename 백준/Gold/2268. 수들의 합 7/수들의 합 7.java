

import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

import java.util.List;





class Main {
	static int size;
	static long[] arr;
	static int logn;
	static int first;
    public static void main(String[] args) throws IOException {
    	
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(br.readLine());
    size=Integer.parseInt(st.nextToken());
    logn=0;
    for(int i=1;i<size;i*=2) {
    	logn++;
    	
    }
    arr=new long[(int)Math.pow(2, logn+1)];
    first=arr.length/2;
    
    int line=Integer.parseInt(st.nextToken());
    StringBuilder sBuilder= new StringBuilder();
    for(int i=0;i<line;i++) {
    	st=new StringTokenizer(br.readLine());
    	int choice=Integer.parseInt(st.nextToken());
    	int a=Integer.parseInt(st.nextToken());
    	int b=Integer.parseInt(st.nextToken());
    	if(choice==0) {
    		if(a>b) {
    			int temp=a;
    			a=b;
    			b=temp;
    		}
    		long sum=find(first+a-1, first+b-1);
    		sBuilder.append(sum).append("\n");
    	}
    	else {
    		long temp=b-arr[first+a-1];
    		update(first+a-1, temp);
    	}
    	
    }
    System.out.println(sBuilder);
    
    
   }
    static long find(int start,int end) {
    	long result=0;
    	while(end>=start) {
    		
    		if (end==start) {
				result+=arr[start];
				return result;
			}
    		if(start%2==1) {
    			
    			result+=arr[start++];
    			
    		}
    		if(end%2==0) {
    			result+=arr[end--];
    		}
    		start/=2;
    		end/=2;
    	}
    	return result;
  
    	
    	
    }
    static void update(int index,long num) {
    	int temp=index;
    	while(temp!=0) {
    		arr[temp]+=num;
    		temp/=2;
    		
    	}
    	
    }
    }






