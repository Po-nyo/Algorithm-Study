def solution(bridge_length, weight, truck_weights):
    current_weight = 0
    current_trucks = []
    time = 0

    while len(truck_weights) != 0 or len(current_trucks) != 0:
        time += 1
        
        # aging current_trucks
        current_trucks = list(map(lambda x: [x[0], x[1] + 1], current_trucks))
        
        # push
        if len(truck_weights) > 0 and current_weight + truck_weights[0] <= weight:
            current_trucks.append([truck_weights[0], 1])
            current_weight += truck_weights[0]
            truck_weights = truck_weights[1:]
        
        # remove complete
        if len(current_trucks) > 0 and current_trucks[0][1] >= bridge_length:
            current_weight -= current_trucks[0][0]
            current_trucks = current_trucks[1:]

    return time + 1