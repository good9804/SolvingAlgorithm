

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

import java.util.List;


class Main {
	static int size;
	static int[] tree;
	static int first;
    public static void main(String[] args) throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	size=Integer.parseInt(br.readLine());
    	int logn=0;
    	for(int i=1;i<size;i*=2) {
    		logn++;
    		
    		
    	}
    	tree=new int[(int)Math.pow(2, logn+1)];
    	int[] arr=new int[size+1];
    	first=tree.length/2;
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	for(int i=0;i<size;i++) {
    		int temp=Integer.parseInt(st.nextToken());
    		arr[i+1]=temp;
    		if(temp%2==0) {
    			update(first+i, 1);
    		}
    		
    	}
    	int line=Integer.parseInt(br.readLine());
    	for(int i=0;i<line;i++) {
    		st=new StringTokenizer(br.readLine());
    		int choice=Integer.parseInt(st.nextToken());
    		if(choice==1) {
    			int index=Integer.parseInt(st.nextToken());
    			int changeindex=first+index-1;
    			int temp=Integer.parseInt(st.nextToken());
    			if(temp%2==0) {
    				if(arr[index]%2==1) {
    					update(changeindex, 1);
    				}
    			}
    			if(temp%2==1) {
    				if(arr[index]%2==0) {
    					update(changeindex, -1);
    				}
    			}
    			arr[index]=temp;
    			
    		}
    		else if(choice==2) {
    			int start=first+Integer.parseInt(st.nextToken())-1;
    			int end=first+Integer.parseInt(st.nextToken())-1;
    			if(start>end) {
    				int temp=start;
    				start=end;
    				end=temp;
    			}
    			int sum=find(start, end);
    			sb.append(sum).append("\n");
    		}
    		else {
    			int start=first+Integer.parseInt(st.nextToken())-1;
    			int end=first+Integer.parseInt(st.nextToken())-1;
    			if(start>end) {
    				int temp=start;
    				start=end;
    				end=temp;
    			}
    			int sum=find(start, end);
    			sb.append(end-start+1-sum).append("\n");
    		}
    		
    		
    	}
    	System.out.println(sb);
    	
    }
    static int find(int start,int end) {
    	int sum=0;
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
    static void update(int index,int num) {
    	int temp=index;
    	while(temp!=0) {
    		tree[temp]+=num;
    		
    		temp/=2;
    	}
    	
    }
    
    
    }






