from collections import deque

n, k = map(int, input().split())
graph = []
virus = []
for i in range(n):
    temp = list(map(int, input().split()))
    for j in range(n):
        if temp[j] != 0:
            virus.append((temp[j], i, j))
    graph.append(temp)
virus.sort()
virus = deque(virus)

s, vx, vy = map(int, input().split())

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

time = 0

for _ in range(s):
    length = len(virus)
    for _ in range(length):
        kind, x, y = virus.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >= n:
                continue
            if graph[nx][ny] == 0:
                graph[nx][ny] = kind
                virus.append((kind, nx, ny))

print(graph[vx-1][vy-1])