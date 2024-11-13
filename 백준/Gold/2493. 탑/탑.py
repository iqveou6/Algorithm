n = int(input())
arr = list(map(int, input().split()))

arr = arr[::-1]
cnt = n
answer = [0]*n
stack = []
for i in range(n):
    if stack:
        while True:
            if not stack:
                break
            if stack[-1][0] < arr[i]:
                value, index = stack.pop()
                answer[index] = n-i
            else:
                break
    stack.append((arr[i], n-i-1))

for x in answer:
    print(x, end = ' ')