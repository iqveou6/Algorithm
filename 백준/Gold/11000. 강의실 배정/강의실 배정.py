import heapq
from sys import stdin
n = int(stdin.readline())
time = []
for i in range(n):
    start, end = map(int, stdin.readline().split())
    time.append([start, end])
time.sort()
room = []
heapq.heappush(room, time[0][1])
for i in range(1, n):
    if room[0]>time[i][0]:
        heapq.heappush(room, time[i][1])
    else:
        heapq.heappop(room)
        heapq.heappush(room, time[i][1])
print(len(room))