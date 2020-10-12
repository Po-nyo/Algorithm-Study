#숫자 등급 매기기

```java
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
```
내가 문제를 잘못 이해했을 수도 있지만 나는 n과 m을 받을 때 m을 지정할 수 있는 개수라고 생각했다. \n
그래서 그래서 지정숫자를 저장해 놓을 배열을 하나 만들었다. 알고리즘 자체는 간단했다. \n
나와있는 조건에 해당하는 순서로 if문을 만들었다. \n
울트라 레어는 i가 1일 때(2의 0승은 1이기 때문에 2의 거듭제곱이므로 포함된다.) 그리고 and연산을 통해서 2진수로 2의 거듭제곱을 표현한다. \n
예를 들어 2의 4제곱인 16의 이진수 1000과 2의 4제곱 -1 인 15의 이진수느 0111이고 이 둘을 &연산하면 0000이 된다. 따라서 i & (i - 1) == 0이면 2의 거듭제곱이란 표시가 된다. \n
나머지 울트라 레어 조건인 모든 지정 숫자의 배수 일 경우를 포함시킨다. \n
수퍼 레어 조건인 2개의 지정숫자의 배수인 표현을 위 와같이 하고, 레어인 조건을 XOR(^)연산을 통하여 나타낸다. \n
3개의 조건중 true가 되는 조건은 100 010 001 111이며 이중 111인경우는 이미 앞에서 나왔기 때문에 여기에 포함되지 않는다. \n
만약 모든 조건을 만족 하지않으면 nomal에 1을 더해준다.
