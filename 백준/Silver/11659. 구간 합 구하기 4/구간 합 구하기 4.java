
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
	static int size;
	static int[] table;

	static int[] hap;

	public static void main(String[] args) throws IOException{
			
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st=new StringTokenizer(br.readLine());
	int size=Integer.parseInt(st.nextToken());
	int line=Integer.parseInt(st.nextToken());
	table=new int[size+1];
	hap=new int[size+1];
	st=new StringTokenizer(br.readLine());
	int index=1;
	while(st.hasMoreTokens()) {
		table[index++]=Integer.parseInt(st.nextToken());
	}
	int sum=0;
	for(int i=1;i<=size;i++) {
		sum+=table[i];
		hap[i]=sum;
	}
	StringBuilder sb=new StringBuilder();
	for(int i=0;i<line;i++) {
		st=new StringTokenizer(br.readLine());
		int first=Integer.parseInt(st.nextToken());
		int end=Integer.parseInt(st.nextToken());
		sb.append(hap[end]-hap[first-1]).append("\n");
		
	}
	
	System.out.println(sb);
}


}