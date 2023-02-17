
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
import java.util.StringTokenizer;;









public class Main {
	static int[] arr;
	static int size;
	static int logn;
	static long[] hapnode;
	static long[] smallnode;
	static int first;
	static int result;
	static long max;

	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		size=Integer.parseInt(br.readLine());

		logn=0;
		for(int i=1;i<size;i*=2) {
			
			logn++;
		}
		hapnode=new long[(int)Math.pow(2, logn+1)];
		smallnode=new long[hapnode.length];
		first=hapnode.length/2;
		arr=new int[size+1];
		arr[0]=Integer.MAX_VALUE;
		int k=0;
		StringTokenizer st=new StringTokenizer(br.readLine()); 
		for(int i=1;i<=size;i++) {
			int temp=Integer.parseInt(st.nextToken());
			hapnode[first+i-1]=temp;
			smallnode[first+i-1]=i;
			arr[i]=temp;
		}
		if(size==1) {
			System.out.println(arr[1]*arr[1]);
			return;
		}
		hapinit(1);
		smallinit(1);
	max=Long.MIN_VALUE;
		findmax(first, first+size-1);
		System.out.println(max);
		
		}
	
	
	
	
	
	static void findmax(int start,int end) {
		long index=findsmall(start, end);
		long temp=arr[(int)index]*findhap(start, end);
		if(temp>max) {
			max=temp;
		}
		if((int)(first+index-2)>=start) {
		findmax(start,(int)(first+index-2));}
		if((int)(first+index)<=end) {
		findmax((int)(first+index), end);
		}
	}
	
	static long findsmall(int start,int end) {
		long result=0;
		while(end>=start) {
			if(end==start) {
				if(arr[(int)result]>arr[(int)smallnode[start]]) {
					result=smallnode[start];
				} else if(arr[(int)result]==arr[(int)smallnode[start]]) {
					if(result>smallnode[start]) {
						result=smallnode[start];
					}
				}
				return result;
			}
			if(start%2==1) {
				if(arr[(int)result]>arr[(int)smallnode[start]]) {
					result=smallnode[start];
				}else if(arr[(int)result]==arr[(int)smallnode[start]]) {
					if(result>smallnode[start]) {
						result=smallnode[start];
					}
				
			}
				start++;
				}
			if(end%2==0) {
				if(arr[(int)result]>=arr[(int)smallnode[end]]) {
					result=smallnode[end];
				}else if(arr[(int)result]==arr[(int)smallnode[end]]) {
					if(result>smallnode[end]) {
						result=smallnode[end];
					}
			
					}
				end--;
				}

			start/=2;
			end/=2;
			}
			
		return result;
		
	}
	static long findhap(int start,int end) {
		long result=0;
		while(end>=start) {
			if(end==start) {
				result+=hapnode[start];
				return result;
			}
			if(start%2==1) {
				result+=hapnode[start++];
			}
			if(end%2==0) {
				result+=hapnode[end--];
			}
			start/=2;
			end/=2;
		}
		return result;
		
	}
	
	static long hapinit(int index){
		if(index>=first/2) {
			return hapnode[index]=hapnode[index*2]+hapnode[index*2+1];
		}
		return  hapnode[index]=  hapinit(index*2)+hapinit(index*2+1);
		
	}
	static long smallinit(int index) {
		if(index>=first/2) {
			if(arr[(int)smallnode[index*2]]<=arr[(int)smallnode[index*2+1]]) {
				return smallnode[index]=smallnode[index*2];}
			else return smallnode[index]=smallnode[index*2+1];
			
		}
		if(arr[(int)smallinit(index*2)]<=arr[(int)smallinit(index*2+1)]) {
			return smallnode[index]=smallnode[index*2];}
		else return smallnode[index]=smallnode[index*2+1];
		
	}
}