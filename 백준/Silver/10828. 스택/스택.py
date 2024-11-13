n = int(input())
stack = []
answer = []
for _ in range(n):
    info = list(input().split())
    if len(info) == 1:
        commend = info[0]
        if commend == 'pop':
            if stack:
                answer.append(stack.pop())
            else:
                answer.append(-1)
        elif commend == 'size':
            answer.append(len(stack))
        elif commend == 'empty':
            if stack:
                answer.append(0)
            else:
                answer.append(1)
        elif commend == 'top':
            if stack:
                answer.append(stack[-1])
            else:
                answer.append(-1)
    else:
        commend, x = info[0], int(info[1])
        stack.append(x)
for x in answer:
    print(x)