

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
import java.util.StringTokenizer;








public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int size=Integer.parseInt(st.nextToken());
		int end=Integer.parseInt(st.nextToken());
		int[] arr=new int[size+1];
		int[] dp=new int[end+1];
		for(int i=1;i<=size;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		for(int i=1;i<=size;i++) {
			
			for(int j=1;j<=end;j++) {
				if(arr[i]==j) {dp[j]++;}
				if(arr[i]>j) {continue;}
				dp[j]=dp[j-arr[i]]+dp[j];
			}
		}
		System.out.println(dp[end]);
	}}