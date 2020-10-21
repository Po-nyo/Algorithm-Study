# [[BOJ-2042] 구간 합 구하기](https://www.acmicpc.net/problem/2042)

## 풀이

문제의 입력 조건에서 수의 개수는 최대 100만개, 최대 수정 연산 10000번, 최대 구간 합 연산 10000번.

그리고 걸려있는 제한시간.

일반적인 배열을 사용한 선형탐색으로는 시간초과로 문제를 해결하지 못한다.

<br>

만약 수정 연산이 없는 문제였다면 배열의 n번 인덱스에 0부터 n 까지의 합을 저장해서

시간복잡도 <em>O(1)</em>로 해결될 수도 있는 문제였지만, 수정 연산이 있기 때문에 그렇지 않게 되었다.

그래서 구간 합 연산과 수정 연산 모두 시간복잡도 <em>O(log n)</em>만에 해결할 수 있는 세그먼트 트리를 구현해보았다.

<br>

세그먼트 트리(Segment-Tree)란 특정 구간의 합을 가지고 있는 노드 들로 구성된 Binary Tree 이다.

세그먼트 트리의 root 는 모든 구간의 합을 가지고 있다.

또, mid 를 해당 Tree 의 가운데라고 한다면

Left Tree 는 0 ~ mid 까지의 합을 가지고 Right Tree 는 mid+1 ~ 배열의 끝 까지의 합을 가진다.

이렇게 Left Tree 와 Right Tree 가 단일 Leaf 가 될 때 까지,

구간을 절반으로 나누어 재귀적으로 트리를 구성하면 세그먼트 트리가 완성된다.

<br>

다음은 문제 해결을 위해 구성한 Segment-Tree 이다.

문제에서 수의 범위가 -2<sup>63</sup> <= n <= 2<sup>63</sup>-1 라고 했으므로 long 타입을 사용했다.

```java
public class SegmentTree {

    private long[] segTree;
    private long[] array;
    private final int root = 1;
    private int begin;
    private int end;

    public SegmentTree(long[] array) {
        this.array = array;
        int size = (int)Math.pow(2, (int)Math.ceil((Math.log(array.length)/Math.log(2)+1))) + 1;
        segTree = new long[size];

        this.begin = 0;
        this.end = array.length-1;

        inIt(root, begin, end);
    }

    private long inIt(int n, int begin, int end) {
        if(begin == end)
            segTree[n] = array[begin];
        else {
            int mid = (begin + end) / 2;
            segTree[n] = inIt(2*n, begin, mid) + inIt(2*n+1, mid+1, end);
        }

        return segTree[n];
    }

    public long getSum(int from, int to) {
        return getSum_recursively(root, begin, end, from, to);
    }

    private long getSum_recursively(int n, int begin, int end, int from, int to) {
        if(from > end || to < begin)
            return 0;
        else if(from <= begin && to >= end)
            return segTree[n];
        else {
            int mid = (begin + end) / 2;
            return getSum_recursively(2*n, begin, mid, from, to) + getSum_recursively(2*n+1, mid+1, end, from, to);
        }
    }

    public void update(int index, long newValue) {
        long diff = newValue - array[index];
        array[index] = newValue;
        update_recursively(root, begin, end, index, diff);
    }

    private void update_recursively(int n, int begin, int end, int index, long diff) {
        if(index < begin || index > end)
            return;
        else {
            segTree[n] += diff;
            if(begin == end)
                return;
            else {
                int mid = (begin + end) / 2;
                update_recursively(2*n, begin, mid, index, diff);
                update_recursively(2*n+1, mid+1, end, index, diff);
            }
        }
    }
}
```

트리는 배열로 구현했다.

크기가 n인 배열을 세그먼트 트리로 작성하기 위해서 필요한 세그먼트 트리 배열의 크기(size) 는 트리의 높이를 h라고 했을 때,

**size = 2<sup>(h + 1)</sup> + 1 이다.**

여기서 +1 은 root 의 index 를 0부터 사용하지 않고 1부터 사용할 것이기 때문이다.

그리고 Binary Tree 이기 때문에 **높이(h)는 h = ceil(log<sub>2</sub>n)** 이다. (ceil: 소숫점 이하 올림)

n 번째 노드의 Left Tree 는 n * 2 로 구하고, Right Tree 는 n * 2 + 1 로 구할 것이기 때문에 root 의 index 는

0부터 시작하는 것보다 1부터 시작하는 것이 편리하다.

<br>

자바에는 밑을 2로하는 로그 식을 계산해주는 함수가 없어서 위의 코드에서는 높이(h)를 계산하기 위해

log n / log 2 로 계산 후, Math.ceil() 을 사용하여 소숫점 이하 올림 해주었다.

위 코드의 식을 수식으로 표현하면 다음과 같다.

**size = 2<sup>ceil(log n / log 2) + 1</sup> + 1**

<br>

마지막으로 남은 부분들을 설명하면, 

세그먼트 트리를 재귀적으로 구성했듯이 구간 합을 구하거나 수정하는 연산도 재귀적인 방법으로 진행하게 된다. 

<br>

세그먼트 트리의 구성과 탐색이 동일한 방식의 재귀호출로 이루어지기 때문에,

사용자는 트리 배열의 어느 인덱스에 어떤 구간에 해당하는 어느 값이 들어갔는지 전혀 신경쓰지 않아도 된다.

구간 합을 원한다면 그저 구간의 정보를 던져주면 getSum_recursively() 메소드의 재귀호출을 통해 원하는 값을 얻을 수 있고,

특정 index 의 값 수정을 원한다면 원하는 index 정보와 수정할 값 정보를 던져주면 마찬가지로

update_recursively() 메소드에서 재귀호출을 통해 알아서 해당하는 index 의 값을 수정한다.

<br>

getSum_recursively() 메소드와 update_recursively() 메소드는 재귀적으로 호출되면서

노드에 해당하는 인덱스와 시작인덱스 그리고 끝인덱스를 계속해서 갱신해주어야 하기 때문에 해당하는 인자를 넘겨주어야 한다.

맨 처음 호출에서 root 의 인덱스는 1, 시작인덱스는 0 으로 고정되어있고, 끝 인덱스도 배열의 마지막 인덱스로 고정되어 있으므로

SegmentTree 를 사용하는 사용자 입장에서 굳이 호출할 때마다 해당 정보를 적어줘야 할 필요도 없고,

잘못 적는다면 원하는 값을 얻지 못할 수도 있다.

그래서 getSum() 메소드와 update() 메소드를 정의하여 핵심 인자만 전달하면 나머지 인자들은

n = 1, begin = 0, end = array.length()-1 로 하여

실제 재귀적으로 구현된 메소드를 호출하는 것으로 안전하게 원하는 값을 얻을 수 있도록 설계했다.

<br>

나는 값을 입력받는 경우에 Scanner 가 편리해서 자주 사용하는데,

이번 문제에서는 입력값이 많아서 입력을 더 빠르게 처리할 수 있는 BufferedReader 를 사용했다.

```java
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] array = new long[n];
        for(int i=0; i<n; i++)
            array[i] = Integer.parseInt(br.readLine());

        SegmentTree segTree = new SegmentTree(array);

        for(int i=0; i<m+k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());

            if(a == 1)
                segTree.update(b-1, c);
            else if(a == 2)
                System.out.println(segTree.getSum(b-1, (int)c-1));
        }

        br.close();
    }
}
```
