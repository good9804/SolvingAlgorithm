import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;





public class Main {
	static int all;
	static long[] arr;
	static boolean[] visited;
	static StringBuilder answer;
	static int count;
	static long[] result;
	static int alldol;
	static String string="";
	static HashSet<String> set=new HashSet<String>();
	public static void main(String[] args) throws IOException {
			
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	all=Integer.parseInt(br.readLine());
	
	arr=new long[all+1];
	for(int i=1;i<=all;i++) {
		arr[i]=Long.parseLong(br.readLine());
	}
	result=new long[all+1];
	result[1]=arr[1];
	if(all>1) {
	result[2]=arr[1]+arr[2];}
	for(int i=3;i<=all;i++) {
		result[i]=Math.max(result[i-2], (result[i-3]+arr[i-1]))+arr[i];
	}
	System.out.println(result[all]);
	
	}
}