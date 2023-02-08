
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
	static int row;
	static int col;
	static int[][] hap;

	public static void main(String[] args) throws IOException{
			
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st=new StringTokenizer(br.readLine());
	row=Integer.parseInt(st.nextToken());
	col=Integer.parseInt(st.nextToken());
	table=new int[row+1][col+1];
	hap=new int[row+1][col+1];
	int index=1;
	for(int i=1;i<=row;i++) {
		String[] str=br.readLine().split("");
		for(int j=1;j<=col;j++) {
		table[i][j]=Integer.parseInt(str[j-1]);
		}
		}
	
	int sum=0;
	for(int i=1;i<=row;i++) {
		for(int j=1;j<=col;j++) {
			if(isRange(i-1, j-1)&&isRange(i, j-1)&&isRange(i-1, j)&&table[i][j]==1) {
				hap[i][j]=Math.min(hap[i-1][j-1], Math.min(hap[i][j-1], hap[i-1][j]))+1;
				sum=Math.max(sum, hap[i][j]);
			}else if(isRange(i-1, j-1)&&isRange(i, j-1)&&isRange(i-1, j)&&table[i][j]==0) {
				continue;
			}else {
				if(table[i][j]==1) {
					hap[i][j]=1;
					sum=Math.max(sum,hap[i][j]);
				}else hap[i][j]=0;
			}
		}
	}
	
	System.out.println(sum*sum);
}
	static boolean isRange(int x,int y) {
		return x>=1&&x<=row&&y>=1&&y<=col;
		
	}

}