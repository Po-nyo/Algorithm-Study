import java.util.Scanner;

public class Number_Grade {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int n, m;
		int UR = 0;
		int SR = 0;
		int R = 0;
		int nomal = 0;
		
		n = input.nextInt();
		m = input.nextInt();
		
		int[] arr = new int[m+1];
		
		for(int i = 0; i <= m; i++) {
			arr[i] = input.nextInt();
		} // m개의 지정숫자 입력
		
		for(int i = 1; i <= n; i++) {
			if((i == 1) || ((i & (i-1)) == 0 ) || (i % arr[0]==0 && i % arr[1] == 0 && i % arr[2] == 0)) {
				UR++;
			// 2의 거듭제곱은 이진수로 표현하면 10, 100, 1000 으로 표현되고 
			// 2의 거듭제곱 - 1 은 이진수로  01, 011, 011 으로 표현되어 서로 & 연산을 하면 0이 반환된다.
			}else if((i%arr[0]==0 && i%arr[1]==0 && i% arr[2] !=0) || 
					 (i%arr[0]==0 && i%arr[1]!=0 && i% arr[2] ==0) ||
					 (i%arr[0]!=0 && i%arr[1]==0 && i% arr[2] ==0)) {
				SR++;
			}else if(i%arr[0]==0 ^ i%arr[1]==0 ^ i% arr[2] ==0) { // true true true인 경우는 앞에서 다 나왔기 때문에 xor연산을 사용가능하다.
				R++;
			}else {
				nomal++;
			}		
		}
		
		System.out.printf("UR: %d SR: %d R: %d N: %d", UR, SR, R, nomal);
		
	}

}
