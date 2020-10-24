# [[Leetcode-125] Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)

## 풀이

정규식을 사용했다.

alphanumeric (영문 또는 숫자) 만 고려하기로 했고, 대소문자는 무시하기로 했으므로

문자열을 소문자로 바꾼 뒤 다음 정규식을 통해 alphanumeric 하지 않은 문자를 없애고 진행했다.

```java
s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
```

양 끝에서 시작해서 가운데로 좁혀오면서 문자가 같은지 비교한다.
