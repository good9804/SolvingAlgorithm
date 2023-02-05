
import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
class Main {
	static int size;
	static int count;
	static String[] strarr;
	static boolean[] check;
	static HashSet<String> set=new HashSet<String>();
	public static void main(String[] args) throws IOException {
			
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	size= Integer.parseInt(br.readLine());
	strarr=new String[size];
	check=new boolean[size];
	count= Integer.parseInt(br.readLine());
	for(int i=0;i<size;i++) {
		strarr[i]=br.readLine();
	}
	String string="";
	dfs(0, 0, string);
	System.out.print(set.size());
	
	}
	
	static void dfs(int currentcount,int index,String str) {

		

		if(currentcount==count) {
		if(!set.contains(str)) {
			set.add(str);
		}
		return;
		}
		for(int i=0;i<size;i++) {
			if(!check[i]) {
			check[i]=true;
			dfs(currentcount+1, i, str+strarr[i]);
			check[i]=false;
			}
		}
		
	}

}
