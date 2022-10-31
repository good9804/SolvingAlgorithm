
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input= br.readLine();
		int mod=20000303;
		int now=0;
		for(int i=0;i<input.length();i++) {
			int v=input.charAt(i)-'0';
			now*=10;
			now=now+v;
			now%=mod;
			
		}
		System.out.println(now);
		}
}