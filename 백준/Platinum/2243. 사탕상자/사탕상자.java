
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
	static int firstindex;
static long answer;

	public static void main(String[] args) throws IOException{
			
		
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	int line=Integer.parseInt(br.readLine());
	logn=0;
	for(int i=1;i<=1000000;i*=2) {logn++;}
	hap=new long[(int)Math.pow(2, logn+1)];
	 firstindex=(int)Math.pow(2, logn);
	for(int i=0;i<line;i++) {
	StringTokenizer st=new StringTokenizer(br.readLine());
		
	int choice=Integer.parseInt(st.nextToken());
	if(choice==1) {
		int rank=Integer.parseInt(st.nextToken());
		find(rank,1);
		hap[(int)answer]-=1;
		makehap((int)answer,-1);
		System.out.println(answer-firstindex+1);
		answer=0;
		}
	
	else {
		int candy=Integer.parseInt(st.nextToken());
		int count=Integer.parseInt(st.nextToken());
		hap[firstindex+candy-1]+=count;
		makehap(firstindex+candy-1, count);
	}
	}

}
	static void find(int rank,int index) {
		if(index>=firstindex) {
			answer=index;
			return ;
		}
		if(rank<=hap[index*2]) {
			index*=2;
		}
		else {
			rank-=hap[index*2];
			index=index*2+1;
		}
		find(rank, index);
	}
	static void makehap(int index,long num) {
		int temp=index/2;
		while(temp!=0) {
			hap[temp]+=num;
			temp/=2;
		}
	}
	}