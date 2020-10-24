# 정렬

## 풀이

간단한 정렬문제이다.
 
자바에서는 Comparable 인터페이스를 impl한 객체에 대해 정렬 메소드를 사용할 수 있다.
 
그래서 Comparable 인터페이스를 구현한 객체를 만들어서 문제를 해결했다.

필드에 물건의 이름, 가격, 유통기한을 저장하며 compareTo() 메소드 코드를 통해 문제에서 원하는 정렬을 구현했다.

유통기한은 String 으로 주어지는데, 정렬할 때 이를 굳이 년/월/일의 숫자형태로 parsing 할 필요가 없다.

String 비교 시 사전순서대로 비교하게 되는데, 이 때 숫자는 0 ~ 9 순서로 생각되기 때문.

```java
static class Stuff implements Comparable<Stuff> {
    private String name;
    private int price;
    private String shelfLife;

    public Stuff(String name, int price, String shelfLife) {
        this.name = name;
        this.price = price;
        this.shelfLife = shelfLife;
    }

    @Override
    public int compareTo(Stuff other) {
        int compared = this.name.compareTo(other.name);
        if(compared != 0)
            return compared;

        compared = Integer.compare(this.price, other.price);
        if(compared != 0)
            return -compared;

        compared = this.shelfLife.compareTo(other.shelfLife);
        return compared;
    }
}
```
