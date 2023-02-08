
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
	static long[] hap;
	static int logn;
	static int size;


	public static void main(String[] args) throws IOException{
			
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st=new StringTokenizer(br.readLine());
	size=Integer.parseInt(st.nextToken());
	logn=0;
	for(int i=1;i<=size;i*=2) {
		logn++;}
	
	long allsize=(long)Math.pow(2, logn+1);
	long firstindex=(long)Math.pow(2, logn);
	
	hap=new long[(int)allsize*2];
	
	
	
	int line=Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken());
	
	for(int i=0;i<size;i++) {
		long temp=Long.parseLong(br.readLine());
		hap[(int)firstindex+i]=temp;
		makehap(temp, firstindex+i);
	}
	StringBuilder sb=new StringBuilder();
	for(int i=0;i<line;i++) {
		st=new StringTokenizer(br.readLine());
		int choice=Integer.parseInt(st.nextToken());
		if(choice==1) {
			long changeindex=Long.parseLong(st.nextToken());
			long number=Long.parseLong(st.nextToken());
			long temp=number-hap[(int)(firstindex+changeindex)-1];
			hap[(int)firstindex+(int)changeindex-1]=number;
			makehap(temp,(long)firstindex+changeindex-1);
			
		}
		else {
			long left=Long.parseLong(st.nextToken());
			long right=Long.parseLong(st.nextToken());
			long start=firstindex+left-1;
			long end=firstindex+right-1;
			long sum=0;
			while(start<=end) {
			if(start%2==1) {
				sum+=hap[(int)start++];
			}
			if(end%2==0) {
				sum+=hap[(int)end--];
			}
			start/=2;
			end/=2;}
			sb.append(sum).append("\n");
			
		}
	}
	System.out.println(sb);

}
	static void makehap(long k,long index) {
		int temp=(int)index/2;
		while(temp!=0) {
			hap[temp]+=k;
			temp/=2;
			}
			
	}
	
	}