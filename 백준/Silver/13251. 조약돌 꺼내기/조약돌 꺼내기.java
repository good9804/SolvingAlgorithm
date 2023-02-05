

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int color;
	static int[] dol;
	static int count;
	static int alldol;
	public static void main(String[] args) throws IOException {
			
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	color= Integer.parseInt(br.readLine());
	dol=new int[color];
	StringTokenizer st=new StringTokenizer(br.readLine());
	alldol=0;
	for(int i=0;i<color;i++) {
		dol[i]=Integer.parseInt(st.nextToken());
		alldol+=dol[i];}
	count=Integer.parseInt(br.readLine());
	
	double prop=alldol;
	for(int k=1;k<count;k++) {
		prop*=(alldol-k);
	}
	double sum=0;
	double answer=0;
	for(int k=0;k<color;k++) {
		if(dol[k]<count) {continue;}
		double temp=dol[k];
		double hap=1.0;
			for(int i=0;i<count;i++) {
				double temp2=temp-i;
				
				hap*=(double)(temp-i)/(double)(alldol-i);
			}
			answer+=hap;
	}
	
	System.out.println(answer);
		
	
	
	}
	

}
