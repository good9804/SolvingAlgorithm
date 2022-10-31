import java.util.Scanner;
import java.math.BigInteger;
public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		BigInteger A=scanner.nextBigInteger();
		BigInteger B=scanner.nextBigInteger();
		scanner.close();
		
		System.out.println(A.divide(B));
		System.out.println(A.remainder(B));
		
	}

}