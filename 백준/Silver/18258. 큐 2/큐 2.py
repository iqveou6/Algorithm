from collections import deque

n = int(input())
queue = deque()
answer = []
for _ in range(n):
    temp = -1
    commend = input().split(" ")
    if len(commend) == 2:
        queue.append(commend[1])
    else:
        if commend[0] == 'pop':
            if queue:
                temp = queue.popleft()
        elif commend[0] == 'size':
            temp = len(queue)
        elif commend[0] == 'empty':
            if not queue:
                temp = 1
            else:
                temp = 0
        elif commend[0] == 'front':
            if queue:
                temp = queue[0]
        else:
            if queue:
                temp = queue[-1]
        answer.append(temp)

for x in answer:
    print(x)
