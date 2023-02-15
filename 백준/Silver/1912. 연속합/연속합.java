
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
		int size=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int[] arr=new int[size+1];
		int i=1;
		while(st.hasMoreTokens()) {
			arr[i++]=Integer.parseInt(st.nextToken());
		}
		int[] dp=new int[size+1];
		int sum=Integer.MIN_VALUE;
		for(int j=1;j<=size;j++) {
			dp[j]=Math.max(dp[j-1]+arr[j], arr[j]);
			if(sum<dp[j]) {sum=dp[j];}
		}
		System.out.println(sum);
		
	}}