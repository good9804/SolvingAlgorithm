

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
	static int[] arr;
	static int[] d;
	static int[] order;
	static int[] track;
	public static void main(String[] args) throws IOException{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	int size=Integer.parseInt(br.readLine());
	 arr=new int[size+1];
	d=new int[size+1];
	order=new int[size+1];
	track=new int[size+1];
	StringTokenizer st=new StringTokenizer(br.readLine());
	int i=1;
	while(st.hasMoreTokens()) {
		arr[i++]=Integer.parseInt(st.nextToken());
	}
	int length=1;
	d[1]=arr[1];
	order[1]=1;
	for(int j=2;j<=size;j++) {
	int index=doBinarySearch(arr[j], 1, length);
	order[j]=index;
	if(index>length) {
		length++;
		d[length]=arr[j];
		
	}
	else {d[index]=arr[j];}}
	int len=length;
	for(int j=size;j>=1;j--) {
		if(length==order[j]) {
			
			track[length]=arr[j];
			length--;
			
			
		}
	}
	StringBuilder sBuilder=new StringBuilder();
	sBuilder.append(len).append("\n");
	
	for(int k=1;k<=len;k++) {
		sBuilder.append(track[k]).append(" ");
	}
	System.out.println(sBuilder);
		
		
	}
	
	

	public static int doBinarySearch( int key, int from, int to) {
	    int low = from; // 왼쪽 범위
	    int high = to; // 오른쪽 범위

	    while (low <= high) { // 좌우가 뒤집어 질때까지 찾는다.
	        int mid = (low + high) / 2; // 중간값 찾기
	        if (d[mid] > key) {
	            high = mid - 1; // 찾고자 하는 값 보다 중간이 클경우
	        } else if (d[mid] < key) {
	            low = mid + 1; // 찾고자 하는 값 보다 중간이 작은경우
	        } else {
	            return mid; // key found.
	        }
	    }
	    return low; // key not found.
	}
}
