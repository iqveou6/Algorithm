from itertools import combinations
from collections import deque
n, m = map(int, input().split())
graph = []
safe_zone = []
virus = []
for i in range(n):
    info = list(map(int, input().split()))
    for j in range(m):
        if info[j]==0:
            safe_zone.append((i, j))
        if info[j]==2:
            virus.append((i, j))
    graph.append(info)
candidates = list(combinations(safe_zone, 3))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def spread_virus(n_graph):
    q = deque()
    for a, b in virus:
        q.append((a, b))

    while q:
        a, b = q.popleft()
        for i in range(4):
            na = a+dx[i]
            nb = b+dy[i]
            if 0<=na<n and 0<=nb<m:
                if n_graph[na][nb]==0:
                    n_graph[na][nb] = 2
                    q.append((na, nb))
answer = 0

def count(arr):
    global answer
    cnt = 0
    for i in range(n):
        for j in range(m):
            if arr[i][j]==0:
                cnt+=1
    answer = max(cnt, answer)

for candidate in candidates:
    new_graph = [[0]*m for _ in range(n)]

    for i in range(n):
        for j in range(m):
            new_graph[i][j] = graph[i][j]
    for x, y in candidate:
        new_graph[x][y] = 1
    spread_virus(new_graph)
    count(new_graph)
    for x, y in candidate:
        new_graph[x][y] = 0
print(answer)