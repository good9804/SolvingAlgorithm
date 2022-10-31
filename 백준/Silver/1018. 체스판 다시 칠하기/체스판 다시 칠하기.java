import java.util.Scanner;

public class Main{
	
	static char arr[][]; // 입력받을 체스판이 저장 될 2차원 배열
	static int min = 64; // 최솟값을 찾기 위한 변수, 8x8 크기의 체스판에서 바꿔야 하는 최댓값은 64번 모두 바꾸는 경우이기에 64로 초기화
	
	static void check(int x, int y) { // 8x8 크기의 체스판에서 바꿔야 하는 경우의 수를 체크하는 메소드
		int cnt = 0;
		char color = arr[x][y]; // 전달받은 좌표의 좌상단 체스 색을 저장
		
		for(int i=x;i<x+8;i++) { // 전달받은 좌표에서 8x8 크기로 탐색
			for(int j=y;j<y+8;j++) {
				if(arr[i][j] != color) { // 체스판의 시작 색과 다르면 바꿔야 하므로 증가.
					cnt++;
				}
				
                // 체스판의 시작 색이 W이면 다음은 B가 나와야 하므로 비교를 위해 값을 변경 반대의 경우도 마찬가지
				if(color == 'W') color = 'B';
				else color = 'W';
			}
            // 다음 행의 시작 역시 바꾸어 주어야 한다.
			if(color == 'W') color = 'B';
			else color = 'W';
		}
		
        // cnt는 한 색의 변경 횟수, 64- cnt는 반대 색의 변경 횟수이다.
		cnt = Math.min(cnt, 64-cnt);
		
        // 여지껏 구한 min과 비교
		min = Math.min(cnt, min);
	}
	
    public static void main(String[] args){
      Scanner in = new Scanner(System.in);
        
      int n = in.nextInt();
      int m = in.nextInt();
      
      arr = new char[n][m];
      
      String input;
      
      for(int i=0;i<n;i++) { // 체스판 입력
    	  input = in.next();   	  
    	  for(int j=0;j<m;j++) {
    		  arr[i][j] = input.charAt(j);
    	  }
      }     
      
      for(int i=0;i<=n-8;i++) { // 체스판이 8x8크기 이상일 경우 자를 수 있는 범위의 좌표를 메소드에 전달 	    
    	  for(int j=0;j<=m-8;j++) {
    		 check(i,j);
    	  }
      }    
      
      	System.out.println(min); // 최솟값 출력
      	
      	in.close();
    }
}