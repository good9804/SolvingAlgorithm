
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;


class Main {
	static int[] tree;
	static int first;
	static int answer;
    public static void main(String[] args) throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	int line=Integer.parseInt(br.readLine());
    	int logn=0;
    	for(int i=1;i<2000000;i*=2) {
    		logn++;
    	}
    	tree=new int[(int)Math.pow(2, logn+1)];
    	first=tree.length/2;
    	StringBuilder sb=new StringBuilder();
    	for(int i=0;i<line;i++) {
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		int choice=Integer.parseInt(st.nextToken());
    		if(choice==1) {
    			int num=Integer.parseInt(st.nextToken());
    			update(first+num-1, 1);
    		}
    		else {
    			answer=0;
    			int rank=Integer.parseInt(st.nextToken());
    			find(rank,1);
    			sb.append(answer-first+1).append("\n");
    			update(answer,-1);
    		}
    		
    		
    	}
    	System.out.println(sb);
    	
    }
    static void find(int rank,int index) {
    	if(index>=first) {
    		answer=index;
    		return;
    	}
    	if(tree[index*2]>=rank) {
    		find(rank, index*2);
    	}
    	else {
    		rank-=tree[index*2];
    		find(rank, index*2+1);
    	}
    	
    	
    }
    static void update(int index,int num) {
    	tree[index]+=num;
    	int temp=index/2;
    	while(temp!=0) {
    		tree[temp]+=num;
    		temp/=2;
    		
    	}
    	
    }}