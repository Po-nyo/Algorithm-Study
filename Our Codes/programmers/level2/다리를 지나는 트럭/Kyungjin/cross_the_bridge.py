# Programmers level2 - 다리를 지나는 트럭

import collections


def solution(bridge_length, weight, truck_weights):
    bridge = collections.deque()
    current_weight = 0
    step = 0

    for _ in range(bridge_length):
        bridge.append(0)

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

    while current_weight > 0:
        current_weight -= bridge.popleft()
        step += 1

    return step


if __name__ == '__main__':
    print(solution(2, 10, [7, 4, 5, 6]))
    print(solution(100, 100, [10]))
    print(solution(100, 100, [10, 10, 10, 10, 10, 10, 10, 10, 10, 10]))
