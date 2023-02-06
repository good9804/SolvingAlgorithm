
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
public class Main {
	static int[] arr;
	static int temp;
	static boolean isInclude;
	public static void main(String[] args) throws IOException {
			
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st=new StringTokenizer(br.readLine());
	StringBuilder sb=new StringBuilder();
	int size=Integer.parseInt(st.nextToken());
	int test=Integer.parseInt(st.nextToken());
	isInclude=false;
	 arr=new int[size+1];
	 temp=0;
	for(int i=0;i<=size;i++) {
		arr[i]=i;
	}
	for(int i=0;i<test;i++) {
		st=new StringTokenizer(br.readLine());
		int choice=Integer.parseInt(st.nextToken());
		if(choice==0) {
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			union(a, b);
			
		}
		else {

			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int aa=find(a);
			int answer=find(b);
			if(aa==answer) {
				sb.append("YES").append("\n");
			}else sb.append("NO").append("\n");
		
		}
		
	}
		System.out.println(sb);
		
	}
	static void union(int a,int b) {
		a=find(a);
		b=find(b);
		if(a!=b) {
			if(a>b) {
				arr[a]=b;
			}else arr[b]=a;
		}
	}
	static int find(int a) {
		if(arr[a]==a) {
			temp=a;
			return a;
		}
			
		return	arr[a]=	find(arr[a]);
			
	}
	
	
	}

