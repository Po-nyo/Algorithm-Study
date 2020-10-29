# 개미 수열

## 풀이

개미 수열은 n 번째 수열을 구하려면 n-1 번째 수열을 구해야 한다.

문제에서 몇 번째 수열을 출력할지는 여러 번 입력될 수 있다고 했으므로,

출력을 위해 구해야 하는 수열이 있는 경우 모두 재사용할 수 있도록 리스트에 저장해두는 방식을 선택했다.

현재까지 구해진 수열보다 더 높은 번째의 수열을 구해야 하는 경우 process() 메소드를 통해 개미 수열 리스트를 확장한다.

```java
public class AntSequence {

    private List<String> sequence;

    public AntSequence(String start) {
        this.sequence = new ArrayList<>();

        sequence.add(start);
    }

    public String getNthSequence(int n) {
        if(sequence.size() < n)
            process(n);

        return sequence.get(n-1);
    }

    private void process(int n) {
        while(sequence.size() < n) {
            String lastSequence = sequence.get(sequence.size() - 1);
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<lastSequence.length(); i++) {
                char current = lastSequence.charAt(i);
                int count = count_continuous(lastSequence, current, i);

                sb.append(current).append(count);

                i += count-1;
            }

            sequence.add(sb.toString());
        }
    }

    private int count_continuous(String str, char target, int start) {
       int count = 1;

       for(int i=start+1; i<str.length(); i++) {
           char current = str.charAt(i);

           if(target == current)
               count++;
           else
               return count;
       }

       return count;
    }
}
```
