# 다리를 지나는 트럭

## 풀이

다리를 큐로 생각하여 문제를 풀었다.

처음에 큐에 0을 다리의 길이 만큼 집어넣는다.

그리고 입력받은 트럭의 무게들에 대해 차례차례 다음과 같이 처리했다.

1. 큐에서 하나 꺼낸 값(다리를 막 지난 트럭의 무게)을 current_weight에서 빼주고 step을 1 증가시킨다.

2. current_weight에서 현재 트럭의 무게를 더한 값이 다리가 견딜 수 있는 무게이면 큐에 넣고 current_weight를 무게만큼 증가시킨다. 

3. 그렇지 않으면 큐에 0을 집어넣고, 1번을 다시 진행한다.

```
current_weight: 현재 다리 위에 있는 트럭들의 무게 합
step: 경과 시간
```

```python
for truck_weight in truck_weights:
    while True:
        current_weight -= bridge.popleft()
        step += 1

        if current_weight + truck_weight <= weight:
            bridge.append(truck_weight)
            current_weight += truck_weight
            break
        else:
            bridge.append(0)
```

위의 과정이 끝나면 모든 트럭이 다리를 지나거나 다리 위에 올라갔으므로,

current_weight가 0이 될 때까지 큐에서 꺼낸 값을 current_weight에 빼주면 된다.

이 때에도 큐에서 꺼낼 때마다 step을 1 증가시킨다.

```python
while current_weight > 0:
    current_weight -= bridge.popleft()
    step += 1
```
