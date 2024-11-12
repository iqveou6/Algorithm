n = int(input())
arr = list(map(int, input().split()))

arr.sort()

answer = 0

plus = 0
for x in arr:
    plus += x
    answer += plus

print(answer)