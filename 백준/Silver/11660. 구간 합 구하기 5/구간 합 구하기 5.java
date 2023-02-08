
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
	static int[][] table;

	static int[][] hap;

	public static void main(String[] args) throws IOException{
			
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st=new StringTokenizer(br.readLine());
	int size=Integer.parseInt(st.nextToken());
	int line=Integer.parseInt(st.nextToken());
	table=new int[size+1][size+1];
	hap=new int[size+1][size+1];
	int index=1;
	for(int i=1;i<=size;i++) {
		st=new StringTokenizer(br.readLine());
		for(int j=1;j<=size;j++) {
		table[i][j]=Integer.parseInt(st.nextToken());
		}
		}
	
	int sum=0;
	for(int i=1;i<=size;i++) {
		sum=0;
		for(int j=1;j<=size;j++) {
		sum+=table[i][j];
		hap[i][j]=sum;
		}
	}
	StringBuilder sb=new StringBuilder();
	for(int i=0;i<line;i++) {
		st=new StringTokenizer(br.readLine());
		int firstx=Integer.parseInt(st.nextToken());
		int firsty=Integer.parseInt(st.nextToken());
		int endx=Integer.parseInt(st.nextToken());
		int endy=Integer.parseInt(st.nextToken());
		sum=0;
		for(int j=firstx;j<=endx;j++) {
			sum+=hap[j][endy]-hap[j][firsty-1];
		}
		sb.append(sum).append("\n");
		
	}
	
	System.out.println(sb);
}


}