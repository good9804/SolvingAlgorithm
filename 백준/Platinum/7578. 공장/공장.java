import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static int logN;
	static int[] depth;
	static boolean[] visited;
	static int[] node;
	static int[] node2;
	static int[][] table;
	static long[] hap;
	static ArrayList<Integer>[] map;
	public static void main(String[] args) throws IOException{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

	int size=Integer.parseInt(br.readLine());
	 node=new int[size+1];
	node2=new int[size+1];
	logN=0;
	for(int i=1;i<=size;i*=2) {
	logN++;}
	 hap=new long[(int)Math.pow(2, logN+1)];
	int firstindex=(int) Math.pow(2, logN);
	StringTokenizer st=new StringTokenizer(br.readLine());
	for(int i=1;i<=size;i++) {
		int temp=Integer.parseInt(st.nextToken());
		node[i]=temp;
	}
	HashMap<Integer,Integer> hash=new HashMap<Integer, Integer>(); 
	st=new StringTokenizer(br.readLine());
	for(int i=1;i<=size;i++) {
		int temp=Integer.parseInt(st.nextToken());
		node2[i]=temp;
		hash.put(temp, i);
	}
	long sum=0;
	for(int i=1;i<=size;i++) {
		int temp=node[i];
		int index=hash.get(temp);
		makehap(firstindex+index-1, 1);
		
		int start=firstindex+index;
		int end=firstindex*2-1;
		long temp2=0;
		while(start<=end) {
			if(start%2==1) {
				temp2+=hap[start++];
			}

			if(end%2==0) {
				temp2+=hap[end--];
			}
			start/=2;
			end/=2;
		}
		sum+=temp2;
		
	}
	
	System.out.println(sum);
	
	
	
	
	
	
	}
	static void makehap(int index,long num) {
		int temp=index;
		while(temp!=0) {
			hap[temp]+=num;
			temp/=2;
			
		}
	}
}
