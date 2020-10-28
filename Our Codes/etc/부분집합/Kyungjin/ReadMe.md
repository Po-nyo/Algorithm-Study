# 부분집합

## 풀이

보통 부분집합을 구하는 방법으로

각 원소의 포함여부를 boolean 값으로 나타내기로 하고,

boolean 배열이 가질 수 있는 모든 true/false 조합을 백트래킹으로 순회하여 찾곤한다.

<br>

하지만 부분집합이 나왔다고 해서 이 문제를 위의 방식으로 접근하면 풀기 힘들다.

문제에서 부분집합의 원소의 개수가 적은 것 부터 차례대로 출력하기를 요구하고 있어서

차라리 원소의 개수별로 부분집합을 구하는게 낫다.

결국, 이 문제는 superset 에서 원소를 중복되지 않게 n 개를 뽑는 조합을 구하는 문제와 같다.

```java
public class PowerSet {

    private int[] superSet;

    public void printEverySubset(int[] superSet) {
        this.superSet = superSet;

        printSubset(new int[]{});
        for(int i=1; i<=superSet.length; i++)
            n_subset(0, 0, new int[i]);
    }

    private void n_subset(int depth, int start, int[] subset) {
        if(depth == subset.length)
            printSubset(subset);
        else {
            for(int i=start; i<superSet.length; i++) {
                subset[depth] = superSet[i];
                n_subset(depth+1, i+1, subset);
            }
        }
    }

    private void printSubset(int[] subset) {
        System.out.print("{ ");
        for(int i : subset)
            System.out.print(i + " ");
        System.out.println("}");
    }
}
```

n_subset() 메소드가 부분집합 subset 의 크기만큼 superset 에서 원소를 뽑는 조합을 구하는 역할을 한다.

printEverySubset() 메소드를 보면 n_subset() 에 넘겨주는 subset 의 크기가 1 ~ n 인 것을 확인할 수 있다.

(※ 0인 경우는 따로 출력)
