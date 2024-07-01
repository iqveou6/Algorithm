from itertools import combinations
n, m = map(int, input().split())
data = []
house = []
chicken = []
arr = []

for i in range(n):
    info = list(map(int, input().split()))
    for j in range(n):
        if info[j] == 2:
            chicken.append((i, j))
        elif info[j] == 1:
            house.append((i, j))

candidates = list(combinations(chicken, m))

def get_sum(candidate):
    result = 0
    for hx, hy in house:
        temp = 1e9
        for cx, cy in candidate:
            temp = min(temp, abs(hx-cx) + abs(hy - cy))
        result += temp
    return result

result = 1e9
for candidate in candidates:
    result = min(result, get_sum(candidate))
print(result)