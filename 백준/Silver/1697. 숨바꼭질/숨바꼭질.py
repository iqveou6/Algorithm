from collections import deque

n, k = map(int, input().split())

answer = 0
visited = [0]*100001
def bfs(n):
    q = deque()
    global answer
    q.append(n)
    while q:
        num = q.popleft()
        if num == k:
            return visited[k]
        for x in (num-1, num+1, num*2):
            if 0 <= x <= 100000 and visited[x] == 0:
                visited[x] = visited[num] + 1
                q.append(x)



print(bfs(n))
