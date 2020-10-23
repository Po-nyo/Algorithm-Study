# [뉴스 클러스터링 [2018 KAKAO BLIND RECRUITMENT]](https://programmers.co.kr/learn/courses/30/lessons/17677)

## 풀이

문제에서 핵심적인 것은 다중 집합의 역할을 하는 기능을 구현하는 것이었다.

나는 HashMap 을 사용해서 key 에 원소를, value 에 해당 원소의 개수를 저장하는 방식으로 해결했다.

```java
private Map<String, Integer> makeMultipleSet(String str) {
    Map<String, Integer> k_gram_set = new HashMap<>();

    for(int i=0; i<str.length()-1; i++) {
        char a = str.charAt(i);
        char b = str.charAt(i+1);

        if(!Character.isAlphabetic(a) || !Character.isAlphabetic(b))
            continue;

        String k_gram = "" + str.charAt(i) + str.charAt(i+1);

        k_gram_set.put(k_gram, k_gram_set.getOrDefault(k_gram, 0) + 1);
    }

    return k_gram_set;
}
```

합집합은 또 다른 HashMap 을 생성하여 직접 구한 뒤 value 들의 합을 구하여 원소의 개수를 셌고,

교집합의 경우에는 교집합을 구하지 않고 value 들의 합을 구하여 개수만 셌다.

코드를 짜면서 어떻게하면 코드를 더 짧게 짤 수 있을까 고민하면서 여러가지 방법을 시도해보았다.

평소 잘 사용하지 않던 람다식도 써보고, reduce()도 사용해보았다.

Map 에 key 값이 존재하는 경우에 value + 1 을 하고,

key 값이 존재하지 않는 경우에는 value 를 1 로하여 Map 에 입력하는 Counter 와 같은 기능을 하는 코드도

평소에는 if-else 문을 사용하다가 getOrDefault() 를 사용하여 한 줄 코드로 작성할 수 있다는 것을 알아냈다.

```java
public int solution(String str1, String str2) {
    str1 = str1.toLowerCase();
    str2 = str2.toLowerCase();

    Map<String, Integer> multiple_set1 = makeMultipleSet(str1);
    Map<String, Integer> multiple_set2 = makeMultipleSet(str2);

    Map<String, Integer> union = new HashMap<>(multiple_set1);
    multiple_set2.forEach((k, v) -> union.merge(k, v, Integer::max));

    int count_union = union.values().stream().reduce(0, Integer::sum);
    int count_intersection = 0;
    for(String key : multiple_set1.keySet())
        count_intersection += Math.min(multiple_set1.get(key), multiple_set2.getOrDefault(key, 0));

    float jaccard_similarity;
    if(count_intersection == count_union)
        jaccard_similarity = 1;
    else
        jaccard_similarity = (float)count_intersection / count_union;

    return (int)(jaccard_similarity * 65536);
}
```

