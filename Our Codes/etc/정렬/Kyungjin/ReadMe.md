# 정렬

## 풀이

간단한 정렬문제이고, 나도 간단하게 Comparable 인터페이스를 구현한 객체를 만들어서 문제를 해결했다.

필드에는 이름과 나이를 저장하며 정렬은 나이를 기준으로 하도록 compareTo() 메소드를 구현했다.

정렬은 자바에 이미 구현되어 있는 정렬 메소드를 사용했다.

```java
static class Person implements Comparable<Person> {
    private String name;
    private int age;

    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        return -Integer.compare(this.age, other.age);
    }
}
```