# [[프로그래머스] [level2] 다리를 지나는 트럭](https://programmers.co.kr/learn/courses/30/lessons/42583/)

## 풀이 1 
queue 를 사용해서 해결하는 문제이다. 여러가지 접근법이 있겠지만 dummy 값을 이용해서
다리? 를 먼저 만드는 식으로 진행했다. 이 접근의 경우 나중에 모든 차량이 도로에 올라가거나
통과 했을때, 0이 아닌값이 나올때까지 -1을 해줘야한다.

```python
# 먼저 다리를 만든다
for _ in range(bridge_length): queue.append(0)

# 차량을 모두 올리고 통과시킨다.
while len(trucks) > 0:
    answer += 1

    if len(queue) == bridge_length:
        current_weight -= queue.pop()
        
    if current_weight + trucks[0] <= weight:
        current_weight += trucks[0]
        queue.appendleft(trucks.popleft())
    else:
        queue.appendleft(0)

# 차량이 모두 통과되거나 도로에 올라가면 
# 가장 마지막에 들어간 원소부터 0이 안나올때 까지 pop 하면서
# 결과값을 조정한다.
while len(queue) > 0:
    if queue.popleft() > 0: break
    else: answer -= 1
```
