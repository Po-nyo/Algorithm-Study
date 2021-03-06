# [[BOJ-10430] 나머지 문제](https://www.acmicpc.net/problem/10430)

### 풀이 1

  문제에 주어진 식을 그냥 그대로 가져다 쓰면 쉽게 해결할수 있는 문제이다.  
  우선 A, B, C의 범위는 2보다 크거나 같거나, 10000보다 작거나 같다. 문제를 보았을때, 요구되는 가장 큰값이 10000 \* 10000 = 100,000,000 이므로 32bit 공간을 사용하는 int 자료형으로 커버할수 있다. (-2147483648 ~ 2147483647)  
  또한 문제를 보면 'A%C', 'B%C'는 문제의 해답을 구할때 반복해서 쓰임을 알수 있다. 따라서 'A%C', 'B%C'는 따로 변수에 저장해두어서 재사용하면 연산을 아낄수 있다.  
  함수호출이 발생하면 메모리 call stack에 push 되었다가, 함수 호출이 끝나면 call stack에서 pop 되는 과정을 거친다.  
이문제의 해답을 구하기 위해서는 총 4가지 연산 결과를 출력해야 한다. 이때 4번 출력함수를 call 하는것보다는 한번 출력함수를 call 하도록 구현하는것이 좋다.
