# Anagram

## 풀이

'a' ~ 'z' 까지의 알파벳이 0 ~ 26 으로 맵핑되도록 크기 26짜리 배열을 만들고,

첫번째 문자열의 각 알파벳에 대하여, 알파벳이 등장할 때마다 배열에서 해당하는 위치의 값을 1 더하고,

두번째 문자열의 각 알파벳에 대하여 진행할 때는 배열에서 해당하는 위치의 값을 1 빼준다.

완성된 배열을 탐색하여 값이 0이 아닌 것이 있다면 두 문자열에서 "개수에 차이가 있는 알파벳"이므로

절댓값만큼 제거한다고 생각하여 카운트한다.

```java
public void solve(String a, String b) {
    int[] alphabet_count = new int[26];

    for(int i=0; i<a.length(); i++)
        alphabet_count[a.charAt(i) - 'a']++;

    for(int i=0; i<b.length(); i++)
        alphabet_count[b.charAt(i) - 'a']--;

    int count = 0;
    for(int i : alphabet_count)
        count += Math.abs(i);

    System.out.println(count);
}
```
