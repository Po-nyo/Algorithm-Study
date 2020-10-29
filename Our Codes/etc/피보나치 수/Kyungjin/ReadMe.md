# 피보나치 수

## 풀이

나는 n 번째 까지의 피보나치 수열을 미리 만들어 둔 후,

입력으로 들어온 숫자에 대하여 만들어둔 수열을 이용하여 탐색하고 처리했다.

입력으로 숫자가 많이 들어올수록, 숫자가 입력될 때마다 피보나치 수를 구하여 처리하는 방법보다 효율적인 방법이다.

피보나치 수열은 dp 방식으로 구했고, 생성자에서 피보나치 수열을 n 번째 까지 구해놓을수 있도록 구현했다.

```java
public class Fib {

    private List<Integer> fibList;

    public Fib(int n) {
        fibList = new ArrayList<>();

        fibList.add(0);
        fibList.add(1);

        for(int i=2; i<n; i++)
            fibList.add(fibList.get(i-2) + fibList.get(i-1));
    }

    public void solve(int k) {
        while(k > 0) {
            int max = 0;

            for(int i : fibList) {
                if(i > k)
                    break;
                max = i;
            }
            k -= max;
            System.out.print(max + " ");
        }
        System.out.println();
    }
}
```
