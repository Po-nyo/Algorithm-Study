import collections

def solution(bridge_length, weight, truck_weights):
    answer, current_weight = [bridge_length, 0]
    queue = collections.deque()
    trucks = collections.deque(truck_weights)

    for _ in range(bridge_length): queue.append(0)

    while len(trucks) > 0:
        answer += 1

        if len(queue) == bridge_length:
            current_weight -= queue.pop()
        
        if current_weight + trucks[0] <= weight:
            current_weight += trucks[0]
            queue.appendleft(trucks.popleft())
        else:
            queue.appendleft(0)

    while len(queue) > 0:
        if queue.popleft() > 0: break
        else: answer -= 1

    return answer


if __name__ == "__main__":
    print(solution(100, 100, [10, 10, 10, 10, 10, 10, 10, 10, 10, 10]))
