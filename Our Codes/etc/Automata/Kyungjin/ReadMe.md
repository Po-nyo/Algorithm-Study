# Automata

## 풀이

백트래킹으로 문제를 해결했다.

구하는 이전 상태의 수열 이름을 prev 로 하고, 현재 자리에 올 수 있는 후보 0과 1에 대하여

몇 가지 조건을 설정하여 조건을 통과하면 후보에 넣는 방식으로 진행했다.

간단하게는 그냥 조건없이 모든 0, 1 조합에 대해 다음 상태가 입력 값과 일치하는지 확인하는 방법이 있겠지만,

경우의 수를 덜어보고자 조건을 설정했다.

조건을 정하다보니 조금 복잡해졌는데, 간단하게 할 방법이 떠오르지 않았다.

부정적인 조건들을 설정하여 하나라도 만족하면 후보에 넣지 않고 통과시켰다.

```java
for(int i=0; i<=1; i++) {
    boolean[] negative_cases = new boolean[6];

    negative_cases[0] = prev < index && next < index && prev_seq[prev] == prev_seq[next] && sequence[index] != i;
    negative_cases[1] = prev < index && next < index && prev_seq[prev] != prev_seq[next] && sequence[index] == i;
    negative_cases[2] = prev_prev < index && prev < index && sequence[prev] == prev_seq[prev] && prev_seq[prev_prev] != i;
    negative_cases[3] = prev_prev < index && prev < index && sequence[prev] != prev_seq[prev] && prev_seq[prev_prev] == i;
    negative_cases[4] = next_next < index && next < index && sequence[next] == prev_seq[next] && prev_seq[next_next] != i;
    negative_cases[5] = next_next < index && next < index && sequence[next] != prev_seq[next] && prev_seq[next_next] == i;

    if(negative_cases[0] || negative_cases[1] || negative_cases[2] || negative_cases[3] || negative_cases[4] || negative_cases[5])
        continue;

    candidates[count++] = i;
}
```
