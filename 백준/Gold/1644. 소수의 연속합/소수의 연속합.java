
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
import java.util.function.IntPredicate;


public class Main {
	static int logN;
	static long[] hap;

	public static void main(String[] args) throws IOException{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	int N=Integer.parseInt(br.readLine());
	if(N==1) {System.out.println(0);return;}
	boolean[] isPrime=new boolean[N+1];
	int[] arr=new int[N+1];
	int index=0;
	Arrays.fill(isPrime, true);
	for(int i=2;i<=N;i++) {

		if(isPrime[i]) {
			arr[index++]=i;
		for(int k=i*2;k<=N;k+=i) {
			isPrime[k]=false;
		}
		}
		
		
	}
	long sum=0;
	int answer=0;
	int start=0;
	int end=0;
	int temp=0;
	while(start<index) {
		
		if(arr[start]+arr[start+1]>N) {
			if(isPrime[N]) {answer++;}break;
		}
		for(int i=temp;i<=end;i++) {
			sum+=arr[i];
		}
		if(sum>N) {
			start++;
			end=start;
			temp=start;
			sum=0;
		}else if(sum<N) {
			end++;
			temp=end;
		}
		else {sum=0;
			answer++;
			start++;
			end=start;
			temp=start;}
		
		
		
	}
	System.out.println(answer);
	
	
	}
	}
