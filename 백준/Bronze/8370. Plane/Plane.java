import java.util.*;

public class Main {
	public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
int[] arr= new int[4];
for(int i=0; i<4;i++) {
	arr[i]=sc.nextInt();
	
}
int a,b;
a=arr[0]*arr[1];
b=arr[2]*arr[3];
System.out.println(a+b);


}

}