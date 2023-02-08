
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
	int size=Integer.parseInt(br.readLine());
	table=new int[size+1][size+1];
	hap=new int[size+1][size+1];
	for(int i=1;i<=size;i++) {
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int j=1;j<=i;j++) {
				table[i][j]=Integer.parseInt(st.nextToken());
			
			hap[i][j]=Math.max(hap[i-1][j-1], hap[i-1][j])+table[i][j];
			
		}
	}
	int max=Integer.MIN_VALUE;
	for(int i=1;i<=size;i++) {
		int temp=hap[size][i];
		if(temp>max) {
			max=temp;
		}
	}
	System.out.println(max);
}


}