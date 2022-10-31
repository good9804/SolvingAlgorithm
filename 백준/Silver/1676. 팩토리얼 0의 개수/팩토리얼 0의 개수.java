import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        int two = 0;
        int five = 0;
        for (int i = 1; i <= n; i++) {
            int k = i;

            while (k % 2 == 0) {	// 2 개수 세기
                two++;
                k /= 2;
            }

            while (k % 5 == 0) {	// 5 개수 세기
                five++;
                k /= 5;
            }
        }

        // 2와 5로 만들 수 있는 10의 개수
        System.out.println(five < two ? five : two);
    }
}