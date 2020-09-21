# [[BOJ-1062] 가르침](https://www.acmicpc.net/problem/1062)

## 풀이

문제를 읽고나서 획기적인 방법을 고민해보았지만...
결국 배울 수 있는 모든 알파벳 조합에 대하여 조사하는 방법을 택했다.
그래도 무턱대고 정말로 모든 조합에 대해 조사하는 대신, 
주어진 단어들에서 한 번 이상 출현한 알파벳을 대상으로만 조사를 진행했다. 

문제에서 모든 단어는 "anta"로 시작하고 "tica"로 끝난다고 했으므로
'a', 'n', 't', 'i', 'c' 는 반드시 배워야하는 알파벳이다.
따라서 k가 5보다 작다면 읽을 수 있는 단어는 존재하지 않으므로 답은 항상 0이고,
한 번 이상 출현한 알파벳의 개수가 k-5 이하라면 모든 단어를 읽을 수 있으므로 답은 모든 단어의 개수이다.

main 메소드에서는 다음과 같이 n, k 그리고 단어들을 입력받아 Solution 객체를 통해 문제를 해결했다.
이 때, 모든 단어에서 접두사"anta"와 접미사"tica"는 입력받은 후 제거하고 진행했다.
    
```java
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    String[] input = line.split(" ");
    int n = Integer.parseInt(input[0]);
    int k = Integer.parseInt(input[1]);

    String[] words = new String[n];

    for(int i=0; i<n; i++) {
        String word = br.readLine();
        words[i] = word.substring(4, word.length() - 4);
    }

    new Solution().solve(words, k);
}
```

실제로 문제를 해결하는 부분은 Solution 객체에 작성했다.

먼저, Solution 객체에 네 개의 전역 변수를 만들어 사용했다.

```java
private String[] words;
private boolean[] alphabets;
private ArrayList<Character> candidates;
private int max;
```
words는 고정된 접두사와 접미사를 제외한 입력받은 단어이다.
alphabet은 0 ~ 25번 인덱스를 각각 a ~ z로 생각하여
배운 알파벳이면 true, 그렇지 않으면 false를 저장하여 구분하기 위해 만들었다.
candidates는 words에서 한 번 이상 출현한 알파벳 리스트이다.
max는 배울 수 있는 단어의 최대 개수이다.

실제 사용자가 호출하여 사용하는 메소드는 solve() 메소드이며 다음과 같이 구현했다.

```java
public void solve(String[] words, int k) {
    this.words = words;
    this.alphabets = new boolean[26];
    this.max = 0;

    this.candidates = candidates();

    if(k < 5)
        this.max = 0;
    else if(candidates.size() <= k-5)
        this.max = words.length;
    else
        backtrack(0, 5, k);

    System.out.println(this.max);
}
```

solve()는 인자로 단어들과 배울 수 있는 알파벳 개수를 입력받는다.
그리고 전역 변수들을 초기화 해준다.

이 때, candidates는 한 번 이상 출현한 알파벳 리스트이므로
ArrayList를 반환하는 메소드를 구현하여 사용했다.

그리고 경우에 따라 max값을 구하는데,
한 번 이상 출현한 알파벳들의 조합을 구하고 해당 조합으로 배울 수 있는 단어 개수를 구하는 핵심 기능은
backtrack() 메소드에 구현하여 사용했다. 
backtrack() 메소드에 전달해주는 인자는 start, depth, k 이며 각각
"candidates에서 탐색을 시작할 인덱스", "배운 알파벳 개수", "배울 수 있는 알파벳 개수" 이다.

다음은 한 번 이상 출현한 알파벳 리스트를 반환하는 candidates() 메소드 이다.

```java
private ArrayList<Character> candidates() {
    alphabets['a'-'a'] = true;
    alphabets['n'-'a'] = true;
    alphabets['t'-'a'] = true;
    alphabets['i'-'a'] = true;
    alphabets['c'-'a'] = true;

    ArrayList<Character> list = new ArrayList<>();

    for(String word : words) {
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(!alphabets[c-'a'] && !list.contains(c))
                list.add(c);
        }
    }

    return list;
}
```

다음은 핵심 기능을 구현한 backtrack() 메소드이다.

```java
private void backtrack(int start, int depth, int k) {
    if(depth == k) {
        count();
    }
    else {
        for(int i=start; i<this.candidates.size(); i++) {
            char c = this.candidates.get(i);
            this.alphabets[c-'a'] = true;
            backtrack(i+1, depth+1, k);
            this.alphabets[c-'a'] = false;
        }
    }
}
```

위에서 설명했듯이 start, depth, k는 각각
"candidates에서 탐색을 시작할 인덱스", "배운 알파벳 개수", "배울 수 있는 알파벳 개수" 이므로
depth와 k가 같아지면 count() 메소드를 통해 읽을 수 있는 단어 개수를 센다.
아직 배울 수 있는 알파벳 개수에 여유가 있으면 backtrack()을 재귀호출한다.

마지막으로 현재 배운 알파벳들로 읽을 수 있는 단어 개수를 세고, max값을 갱신하는 count() 메소드이다.

```java
private void count() {
    int cnt = 0;

    Loop:
    for(String word: this.words) {
        for(int i=0; i<word.length(); i++) {
            if(!alphabets[word.charAt(i)-'a'])
                continue Loop;
        }
        cnt++;
    }

    this.max = Math.max(this.max, cnt);
}
```
    
