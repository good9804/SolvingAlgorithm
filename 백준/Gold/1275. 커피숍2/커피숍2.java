
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
	static long[] hap;

	public static void main(String[] args) throws IOException{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st=new StringTokenizer(br.readLine());
	int size=Integer.parseInt(st.nextToken());
	int turn=Integer.parseInt(st.nextToken());
	logN=0;
	for(int i=1;i<=size;i*=2){
		logN++;
	}
	
	hap=new long[(int)Math.pow(2, logN+1)];
	long firstindex=(long) Math.pow(2, logN);
	st=new StringTokenizer(br.readLine());
	for(int i=0;i<size;i++) {
		makehap((int)firstindex+i, Long.parseLong(st.nextToken()));
	}
	StringBuilder sb=new StringBuilder();
	for(int i=0;i<turn;i++) {
		st=new StringTokenizer(br.readLine());
		long sum=0;
		long start=firstindex+Integer.parseInt(st.nextToken())-1;
		long end=firstindex+Integer.parseInt(st.nextToken())-1;
		long changeindex=firstindex+Integer.parseInt(st.nextToken())-1;
		long num=Long.parseLong(st.nextToken());
		if(start>end) {
			long temp=start;
			start=end;
			end=temp;
		}
		while(end>=start) {
			if(start%2==1) {
				sum+=hap[(int)start++];
			}
			if(end%2==0) {
				sum+=hap[(int)end--];
			}
		start/=2;
		end/=2;
		}
		sb.append(sum).append("\n");
		
		makehap((int)changeindex, num-hap[(int)changeindex]);
		
		
	}
	
	System.out.println(sb);
	
}
	
	static void makehap(int index,long num) {
		int temp=index;
		while(temp!=0) {
			hap[temp]+=num;
			temp/=2;
			
		}
		
	}}
