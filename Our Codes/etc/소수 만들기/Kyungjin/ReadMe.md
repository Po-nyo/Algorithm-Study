# 소수 만들기

## 풀이

주어진 숫자로 순열을 만들고, 만들어진 순열이 소수인지 확인하는 방식으로 진행했다.

순열은 숫자를 1개 사용하는 것 부터 n개 모두 사용하는 것까지 따로 구했다.

나는 만들어진 순열이 소수인지 어떻게 확인할지 고민하다가, 만들 수 있는 가장 큰 수 까지의 크기를 가지는 boolean 배열을 만들었다.

언뜻 생각하면 메모리를 많이 사용할것도 같지만 boolean 은 참/거짓 1비트만 사용하기 때문에 사실 크게 부담스럽지 않다.

그리고 그 배열에서 소수가 아닌 것만 true 로 체크했다.

소수가 아닌 것을 고르는 알고리즘은 "에라토스 테네스의 체" 방식을 이용했다.

"에라토스 테네스의 체" 알고리즘의 시간복잡도는 <em>O(n*log(log(n)))</em> 으로, 소수를 구하는 문제에 많이 사용된다.

이렇게 한 번 소수인지 아닌지 판단하는 boolean 배열을 완성하고 나면, 어떤 수가 소수인지 아닌지는 순식간에 판별할 수 있다.

<br>

maxNumber 까지의 소수 판별 boolean 배열을 구성하는 부분
```java
private void construct_isNotPrimeNumber(int maxNumber) {
    isNotPrimeNumber[0] = true;
    if(maxNumber < 1)
        return;
    isNotPrimeNumber[1] = true;

    for(int i=2; i<Math.sqrt(maxNumber); i++) {
        if(isNotPrimeNumber[i])
            continue;
        for(int j=2*i; j<=maxNumber; j+=i)
            isNotPrimeNumber[j] = true;
    }
}
```

<br>

순열을 구하는 부분
```java
private void makeNumber(StringBuilder numString, int depth, int n) {
    if(depth == n) {
        int number = Integer.parseInt(numString.toString());
        if(!isNotPrimeNumber[number] && !primeNumbers.contains(number))
            primeNumbers.add(number);
    }
    else {
        for(int i=0; i<nums.length; i++) {
            if(!using[i]) {
                numString.append(nums[i]);
                using[i] = true;
                makeNumber(numString, depth + 1, n);
                using[i] = false;
                numString.deleteCharAt(depth);
            }
        }
    }
}
```
