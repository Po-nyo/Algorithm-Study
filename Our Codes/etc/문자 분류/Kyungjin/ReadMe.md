# 문자 분류

## 풀이

문제에 따르면 영문자와 한글 문자만 고려하면 된다.

그래서 나는 각 문자에 대해 isEnglish() 메소드를 통해 영문자인지 아닌지 판별했다.

```java
private boolean isEnglish(char c) {
    return (c>='a' && c<='z') || (c>='A' && c<='Z');
}
```

영어 문자이면 영어 문자를 모은 StringBuilder에 append하고, 

그렇지 않으면 한글 문자를 모은 StringBuilder에 append했다.

그리고 문제에서 원하는 출력은 완성된 두 개의 StringBuilder를 이용했다.

문자열을 더하는 연산은 String + String 보다 StringBuilder의 append()를 사용하는 것이 효율적이다.

```java
public void solve(String line) {
    StringBuilder en_sb = new StringBuilder();
    StringBuilder ko_sb = new StringBuilder();

    for(int i=0; i<line.length(); i++) {
        char current = line.charAt(i);

        if(isEnglish(current))
            en_sb.append(current);
        else
            ko_sb.append(current);
    }

    System.out.println(en_sb.toString() + ko_sb.toString());
    System.out.println(en_sb.length() + " " + ko_sb.length() + " " + line.length());
}
```
