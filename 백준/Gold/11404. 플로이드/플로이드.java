
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
	public static void main(String[] args) throws IOException{
			
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

	size= Integer.parseInt(br.readLine());
	int[][] table=new int[size+1][size+1];
	int line=Integer.parseInt(br.readLine());
	
	
	for(int i=0;i<line;i++) {
		StringTokenizer st=new StringTokenizer(br.readLine());
		int first=Integer.parseInt(st.nextToken());
		int end=Integer.parseInt(st.nextToken());
		int cost=Integer.parseInt(st.nextToken());
		if(table[first][end]==0||table[first][end]>cost) {
			table[first][end]=cost;
		}
	}
	for(int k=1;k<=size;k++) {
		for(int i=1;i<=size;i++)
			for(int j=1;j<=size;j++) {
				if(i!=j&&table[i][k]!=0&&table[k][j]!=0) {
					if(table[i][j]==0||table[i][j]>table[i][k]+table[k][j]) {
						table[i][j]=table[i][k]+table[k][j];
					}
				}
			}
		
	}
	StringBuilder sb=new StringBuilder();
	for(int i=1;i<=size;i++) {
		for(int j=1;j<=size;j++) {
			sb.append(table[i][j]).append(" ");
		}
		sb.append("\n");
		}
	
	System.out.println(sb);
	}

}
